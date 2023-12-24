package fr.esiea.pokejava.model.player;

import fr.esiea.pokejava.game.Game;
import fr.esiea.pokejava.model.attack.Attack;
import fr.esiea.pokejava.model.monster.Monster;
import fr.esiea.pokejava.model.objects.Items;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Player {
    private int number;

    private Monster currentMonster;
    private HashMap<String,Monster> team;
    private List<Items> bag;

    private boolean attackNextMove;

    private Attack nextMove;

    public Monster getCurrentMonster() {
        return currentMonster;
    }

    public void setCurrentMonster(Monster currentMonster) {
        this.currentMonster = currentMonster;
    }

    public boolean isAttackNextMove() {
        return attackNextMove;
    }

    public Attack getNextMove() {
        return nextMove;
    }

    public void setNextMove(Attack nextMove) {
        this.nextMove = nextMove;
    }

    public Player(int number, HashMap<String,Monster> team, List<Items> bag) {
        this.number = number;
        this.team = team;
        this.bag = bag;
        this.attackNextMove = false;
        this.nextMove = null;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public HashMap<String,Monster> getTeam() {
        return team;
    }

    public void setTeam(HashMap<String,Monster> team) {
        this.team = team;
    }

    public List<Items> getBag() {
        return bag;
    }

    public void setBag(List<Items> bag) {
        this.bag = bag;
    }

    public void addTeam(Monster pokemon){
    }

    public void setAttackNextMove(boolean attackNextMove) {
        this.attackNextMove = attackNextMove;
    }
    public boolean getAttackNextMove(){
        return this.attackNextMove;
    }

    public void displayMonsters() {
        System.out.println("Votre équipe est composé : ");
        for (Monster monster : team.values()) {
            System.out.println(monster);
        }
    }

   public void displayItems() {
        System.out.println("Objets de player " + number + " :");
        for (Items item : bag) {
            System.out.println(item.getNom());
        }
    }

   public boolean isDefeated() {
        for (Monster monster : team.values()) {
            if (monster.getHp() > 0) {
                return false;
            }
        }
        return true;
    }
    public void switchMonster() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choisissez dans votre équipe : ");
        for (Monster poke:
             team.values()) {
            if(poke != currentMonster){
                System.out.println(poke);
            }
        }
        System.out.println("Pour annuler taper 'cancel'");
        String result = sc.nextLine();
        if(!result.equals("cancel")){
            while(!team.containsKey(result)){
                System.out.println("Ce pokémon n'est pas dans votre équipe...");
                result = sc.nextLine();
            }
            currentMonster = team.get(result);
            System.out.println("Joueur" + number + " a changé de monstre.");

        }else{
            System.out.println("Vous avez annulé.");
            Game.turn(this);
        }
    }
    public void attack(Player defender){
        calculateDamage(this.nextMove, this.getCurrentMonster(), defender.getCurrentMonster());
    }
    public void calculateDamage(Attack attack, Monster attacker, Monster defender){
        double coef = 0.85 + Math.random() * 0.15;
        double avantage = 1;
        List<String> weakness = Game.mapWeakness.get(defender.getType());
        List<String> effectiveness = Game.mapEffectiveness.get(defender.getType());
        if(weakness.contains(attack.getType())){
            avantage = 2;
        }
        if(effectiveness.contains(attack.getType())){
            avantage = 0.5;
        }
        int degats = (int)(((11*attacker.getAttack()*attack.getPower())/(25*defender.getDefense())+2)*avantage* coef);

        defender.setHp(defender.getHp()- degats);
    }

    public void displayCurrentMonster() {
        System.out.println("Joueur " + this.getNumber());
        System.out.println("Votre pokémon actuel : ");
        System.out.println(this.currentMonster);
    }
}

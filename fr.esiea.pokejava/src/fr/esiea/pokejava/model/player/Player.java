package fr.esiea.pokejava.model.player;

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

    public Player(int number,HashMap<String,Monster> team, List<Items> bag) {
        this.number = number;
        this.team = team;
        this.bag = bag;
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
    public void switchMonster(Scanner sc) {
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
            currentMonster = team.get(result);
            System.out.println("Joueur" + number + " a changé de monstre.");

        }else{
            System.out.println("Joueur" + number + " a changé de monstre.");

        }
    }
}

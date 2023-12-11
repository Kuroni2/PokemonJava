package fr.esiea.pokejava.model.player;

import fr.esiea.pokejava.model.monster.Monster;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Player {
    private int number;
    private String nom;
    private HashMap<String,Monster> team;
    private List<Objects> bag;

    public Player(int number,String nom,HashMap<String,Monster> team, List<Objects> bag) {
        this.number = number;
        this.nom = nom;
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

    public List<Objects> getBag() {
        return bag;
    }

    public void setBag(List<Objects> bag) {
        this.bag = bag;
    }

    public void addTeam(Monster pokemon){
    }

    void displayMonsters() {
        System.out.println("Monstres de " + name + ":");
        for (Monster monster : monsters) {
            monster.displayStatus();
        }
    }

    void displayItems() {
        System.out.println("Objets de " + name + ":");
        for (Item item : items) {
            System.out.println(item.name);
        }
    }

    boolean isDefeated() {
        for (Monster monster : monsters) {
            if (monster.health > 0) {
                return false;
            }
        }
        return true;
    }
}

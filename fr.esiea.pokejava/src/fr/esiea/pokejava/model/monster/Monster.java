package fr.esiea.pokejava.model.monster;

import fr.esiea.pokejava.model.state.State;

public abstract class Monster {

    private String name;

    private int hp;

    private int attack;

    private int defense;

    private int speed;

    private State status;

    public Monster(String name, int hp, int attack, int defense, int speed){
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
    }
    public Monster(Monster monster){
        this.name = monster.name;
        this.hp = monster.hp;
        this.attack = monster.attack;
        this.defense = monster.defense;
        this.speed = monster.speed;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}

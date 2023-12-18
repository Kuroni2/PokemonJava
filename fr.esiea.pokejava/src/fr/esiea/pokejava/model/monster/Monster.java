package fr.esiea.pokejava.model.monster;

import fr.esiea.pokejava.model.attack.Attack;
import fr.esiea.pokejava.model.state.State;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Monster {

    private String name;

    private int hp;
    private int hpMin;
    private int hpMax;
    private int attackMin;
    private int attackMax;
    private int defenseMin;
    private int defenseMax;
    private int speedMin;
    private int speedMax;

    private int attack;

    private int defense;

    private int speed;

    private Map<String,Attack> attacks;

    private State status;

    public Monster(String name, int hp, int attack, int defense, int speed){
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.attacks  = new HashMap<>();
        this.status = null;

    }
    public Monster(Monster monster){
        this.name = monster.name;
        this.hpMin = monster.hpMin;
        this.hpMax = monster.hpMax;
        this.hp = hpMin + (int)(Math.random()*(hpMax-hpMin));
        //Attack
        this.attackMin = monster.attackMin;
        this.attackMax = monster.attackMax;
        this.attack = attackMin + (int)(Math.random()*(attackMax-attackMin));
        //Defense
        this.defenseMax = monster.defenseMax;
        this.defenseMin = monster.defenseMin;
        this.defense = defenseMin + (int)(Math.random()*(defenseMax-defenseMin));
        //Speed
        this.speedMax = monster.speedMax;
        this.speedMin = monster.speedMin;
        this.speed = speedMin + (int)(Math.random()*(speedMax-speedMin));

        this.status = null;
        this.attacks  = new HashMap<>();

    }
    public Monster(Map<String, String> data) {
        this.name = data.get("Name");
        //Attack
        this.attackMin = Integer.parseInt(data.get("Attack").split(" ")[0]);
        this.attackMax = Integer.parseInt(data.get("Attack").split(" ")[1]);
        //Defense
        this.defenseMin = Integer.parseInt(data.get("Defense").split(" ")[0]);
        this.defenseMax = Integer.parseInt(data.get("Defense").split(" ")[1]);
        //HP
        this.hpMin = Integer.parseInt(data.get("HP").split(" ")[0]);
        this.hpMax = Integer.parseInt(data.get("HP").split(" ")[1]);
        //Speed
        this.speedMin = Integer.parseInt(data.get("Speed").split(" ")[0]);
        this.speedMax = Integer.parseInt(data.get("Speed").split(" ")[1]);
        this.status = null;

        this.attacks  = new HashMap<>();


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
    @Override
    public String toString() {
        String result ="";
        result += "Name : " + name +"\n";
        result +=   "Hp : " + hp +"\n";
        result +=   "Attack : " + attack+"\n";
        result +=   "Defense : " + defense+"\n";
        result +=   "Speed : " + speed+"\n";
        return result;
    }
    public abstract boolean isSameType(Attack attack);

    public Map<String,Attack> getAttacks() {
        return attacks;
    }
}

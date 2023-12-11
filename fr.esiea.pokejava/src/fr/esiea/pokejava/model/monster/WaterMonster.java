package fr.esiea.pokejava.model.monster;

public class WaterMonster extends Monster{

    private double flood;

    private double fall;

    public WaterMonster(String name, int hp, int attack, int defense, int speed) {
        super(name, hp, attack, defense, speed);
    }
}

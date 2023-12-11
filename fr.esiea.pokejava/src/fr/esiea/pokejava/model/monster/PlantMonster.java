package fr.esiea.pokejava.model.monster;

public class PlantMonster extends NatureMonster{

    private double healStatus;
    public PlantMonster(String name, int hp, int attack, int defense, int speed) {
        super(name, hp, attack, defense, speed);
    }
}

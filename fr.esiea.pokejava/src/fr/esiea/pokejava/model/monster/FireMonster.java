package fr.esiea.pokejava.model.monster;

public class FireMonster extends Monster{

    private double burn;
    public FireMonster(String name, int hp, int attack, int defense, int speed) {
        super(name, hp, attack, defense, speed);
    }

    public FireMonster(FireMonster pokemon) {
        super(pokemon);
        this.burn = pokemon.burn;
    }
}

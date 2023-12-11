package fr.esiea.pokejava.model.monster;

public class NatureMonster  extends Monster{

    private double heal;
    public NatureMonster(String name, int hp, int attack, int defense, int speed) {
        super(name, hp, attack, defense, speed);
    }

    public NatureMonster(NatureMonster pokemon) {
        super(pokemon);
        this.heal = pokemon.heal;
    }
}

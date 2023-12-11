package fr.esiea.pokejava.model.monster;

public class InsectMonster extends NatureMonster{

    private double poison;
    public InsectMonster(String name, int hp, int attack, int defense, int speed) {
        super(name, hp, attack, defense, speed);
    }
    public InsectMonster(InsectMonster pokemon){
        super(pokemon);
        this.poison = pokemon.poison;
    }
}

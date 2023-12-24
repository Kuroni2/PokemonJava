package fr.esiea.pokejava.model.monster;

import fr.esiea.pokejava.model.attack.Attack;
import fr.esiea.pokejava.model.attack.ElectricAttack;
import fr.esiea.pokejava.model.attack.FireAttack;
import fr.esiea.pokejava.parser.MonsterParser;

import java.nio.DoubleBuffer;
import java.util.Map;

public class FireMonster extends Monster{

    private double burn;
    public FireMonster(String name, int hp, int attack, int defense, int speed) {
        super(name, hp, attack, defense, speed);
    }

    public FireMonster(FireMonster pokemon) {
        super(pokemon);
        this.burn = pokemon.burn;
    }

    public FireMonster(Map<String,String> data){
        super(data);
        this.burn = Double.parseDouble(data.get("Burn"));
    }
    public boolean isSameType(Attack attack){
        return attack instanceof FireAttack;
    }
    @Override
    public String getType() {
        return "Feu";
    }

}

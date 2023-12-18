package fr.esiea.pokejava.model.monster;

import fr.esiea.pokejava.model.attack.Attack;
import fr.esiea.pokejava.model.attack.ElectricAttack;
import fr.esiea.pokejava.model.attack.WaterAttack;

import java.util.Map;

public class WaterMonster extends Monster{

    private double flood;

    private double fall;

    public WaterMonster(String name, int hp, int attack, int defense, int speed) {
        super(name, hp, attack, defense, speed);
    }

    public WaterMonster(WaterMonster pokemon) {
        super(pokemon);
        this.fall = pokemon.fall;
        this.flood = pokemon.flood;
    }
    public WaterMonster(Map<String,String> data){
        super(data);
        this.flood = Double.parseDouble(data.get("Flood"));
        this.fall = Double.parseDouble(data.get("Fall"));
    }
    public boolean isSameType(Attack attack){
        return attack instanceof WaterAttack;
    }
}

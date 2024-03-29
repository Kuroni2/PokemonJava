package fr.esiea.pokejava.model.monster;

import fr.esiea.pokejava.model.attack.Attack;
import fr.esiea.pokejava.model.attack.ElectricAttack;
import fr.esiea.pokejava.model.attack.PlantAttack;

import java.util.Map;

public class PlantMonster extends NatureMonster{

    private double healStatus;
    public PlantMonster(String name, int hp, int attack, int defense, int speed) {
        super(name, hp, attack, defense, speed);
    }
    public PlantMonster(PlantMonster pokemon){
        super(pokemon);
        this.healStatus = pokemon.healStatus;
    }
    public PlantMonster(Map<String, String> data){
        super(data);
        this.healStatus = Double.parseDouble(data.get("HealStatus"));
    }
    public boolean isSameType(Attack attack){
        return attack instanceof PlantAttack;
    }
    @Override
    public String getType() {
        return "Plante";
    }
}

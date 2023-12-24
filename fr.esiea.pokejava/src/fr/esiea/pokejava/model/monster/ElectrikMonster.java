package fr.esiea.pokejava.model.monster;

import fr.esiea.pokejava.model.attack.Attack;
import fr.esiea.pokejava.model.attack.ElectricAttack;

import java.util.Map;

public class ElectrikMonster  extends Monster{

    private double paralysis;
    public ElectrikMonster(String name, int hp, int attack, int defense, int speed) {
        super(name, hp, attack, defense, speed);
    }
    public ElectrikMonster(ElectrikMonster pokemon){
        super(pokemon);
        this.paralysis = pokemon.paralysis;
    }
    public ElectrikMonster(Map<String,String> data){
        super(data);
        this.paralysis = Double.parseDouble(data.get("Paralysis"));
    }
    public boolean isSameType(Attack attack){
        return attack instanceof ElectricAttack;
    }
    @Override
    public String getType() {
        return "Electrique";
    }


}

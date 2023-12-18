package fr.esiea.pokejava.model.monster;

import fr.esiea.pokejava.model.attack.Attack;
import fr.esiea.pokejava.model.attack.ElectricAttack;
import fr.esiea.pokejava.model.attack.InsectAttack;

import java.util.Map;

public class InsectMonster extends NatureMonster{

    private double poison;
    public InsectMonster(String name, int hp, int attack, int defense, int speed) {
        super(name, hp, attack, defense, speed);
    }
    public InsectMonster(InsectMonster pokemon){
        super(pokemon);
        this.poison = pokemon.poison;
    }
    public InsectMonster(Map<String,String> data){
        super(data);
        this.poison = Double.parseDouble(data.get("Poison"));
    }
    public boolean isSameType(Attack attack){
        return attack instanceof InsectAttack;
    }
}

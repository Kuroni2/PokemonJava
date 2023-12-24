package fr.esiea.pokejava.model.monster;

import fr.esiea.pokejava.model.attack.Attack;
import fr.esiea.pokejava.model.attack.ElectricAttack;

import java.util.Map;

public class NatureMonster  extends Monster{

    private double heal;
    public NatureMonster(String name, int hp, int attack, int defense, int speed) {
        super(name, hp, attack, defense, speed);
    }

    public NatureMonster(NatureMonster pokemon) {
        super(pokemon);
        this.heal = pokemon.heal;
    }
    public NatureMonster(Map<String,String> data){
        super(data);
        this.heal = Double.parseDouble(data.get("Heal"));
    }

    @Override
    public boolean isSameType(Attack attack) {
        return false;
    }
    @Override
    public String getType() {
        return null;
    }


}

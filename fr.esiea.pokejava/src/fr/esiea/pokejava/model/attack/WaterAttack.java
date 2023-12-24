package fr.esiea.pokejava.model.attack;

import java.util.Map;

public class WaterAttack extends Attack{
    public WaterAttack(String name, int power, int nbUse, double fail) {
        super(name, power, nbUse, fail);
    }
    public  WaterAttack(Map<String,String> data){
        super(data);
    }
    public WaterAttack(WaterAttack attack){
        super(attack.getName(),attack.getPower(),attack.getNbUse(),attack.getFail());
    }
    @Override
    public String toString() {
        String result = super.toString();
        result += "Type : Eau";
        return result;
    }
    @Override
    public String getType() {
        return "Water";
    }
}

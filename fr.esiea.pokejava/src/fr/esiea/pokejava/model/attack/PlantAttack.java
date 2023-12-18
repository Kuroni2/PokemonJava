package fr.esiea.pokejava.model.attack;

import java.util.Map;

public class PlantAttack extends Attack{
    public PlantAttack(String name, int power, int nbUse, double fail) {
        super(name, power, nbUse, fail);
    }
    public  PlantAttack(Map<String,String> data){
        super(data);
    }
    public PlantAttack(PlantAttack attack){
        super(attack.getName(),attack.getPower(),attack.getNbUse(),attack.getFail());
    }
    @Override
    public String toString() {
        String result = super.toString();
        result += "Type : Plante";
        return result;
    }
}

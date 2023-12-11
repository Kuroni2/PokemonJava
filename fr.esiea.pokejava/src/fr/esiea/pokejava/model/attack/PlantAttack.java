package fr.esiea.pokejava.model.attack;

import java.util.Map;

public class PlantAttack extends Attack{
    public PlantAttack(String name, int power, int nbUse, double fail) {
        super(name, power, nbUse, fail);
    }
    public  PlantAttack(Map<String,String> data){
        super(data);
    }
}

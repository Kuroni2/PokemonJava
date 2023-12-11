package fr.esiea.pokejava.model.attack;

import java.util.Map;

public class WaterAttack extends Attack{
    public WaterAttack(String name, int power, int nbUse, double fail) {
        super(name, power, nbUse, fail);
    }
    public  WaterAttack(Map<String,String> data){
        super(data);
    }
}

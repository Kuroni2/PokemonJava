package fr.esiea.pokejava.model.attack;

import java.util.Map;

public class ElectricAttack extends Attack{
    public ElectricAttack(String name, int power, int nbUse, double fail) {
        super(name, power, nbUse, fail);
    }
    public ElectricAttack(Map<String,String> data){
        super(data);
    }
}

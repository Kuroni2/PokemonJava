package fr.esiea.pokejava.model.attack;

import java.util.Map;

public class NormalAttack extends Attack{
    public NormalAttack(String name, int power, int nbUse, double fail) {
        super(name, power, nbUse, fail);
    }
    public NormalAttack(Map<String,String> data){
        super(data);
    }
}

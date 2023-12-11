package fr.esiea.pokejava.model.attack;

import java.util.Map;

public class FireAttack extends Attack{
    public FireAttack(String name, int power, int nbUse, double fail) {
        super(name, power, nbUse, fail);
    }
    public FireAttack(Map<String,String> data){
        super(data);
    }
}

package fr.esiea.pokejava.model.attack;

import java.util.Map;

public class InsectAttack extends Attack{
    public InsectAttack(String name, int power, int nbUse, double fail) {
        super(name, power, nbUse, fail);
    }
    public  InsectAttack(Map<String,String> data){
        super(data);
    }
}

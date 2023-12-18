package fr.esiea.pokejava.model.attack;

import java.util.Map;

public class NormalAttack extends Attack{
    public NormalAttack(String name, int power, int nbUse, double fail) {
        super(name, power, nbUse, fail);
    }
    public NormalAttack(Map<String,String> data){
        super(data);
    }
    public NormalAttack(NormalAttack attack){
        super(attack.getName(),attack.getPower(),attack.getNbUse(),attack.getFail());
    }
    @Override
    public String toString() {
        String result = super.toString();
        result += "Type : Normal";
        return result;
    }
}

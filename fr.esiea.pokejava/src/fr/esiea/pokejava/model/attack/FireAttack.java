package fr.esiea.pokejava.model.attack;

import java.util.Map;

public class FireAttack extends Attack{
    public FireAttack(String name, int power, int nbUse, double fail) {
        super(name, power, nbUse, fail);
    }
    public FireAttack(Map<String,String> data){
        super(data);
    }
    public FireAttack(FireAttack attack){
        super(attack.getName(),attack.getPower(),attack.getNbUse(),attack.getFail());
    }
    @Override
    public String toString() {
        String result = super.toString();
        result += "Type : Feu";
        return result;
    }
    @Override
    public String getType() {
        return "Feu";
    }
}

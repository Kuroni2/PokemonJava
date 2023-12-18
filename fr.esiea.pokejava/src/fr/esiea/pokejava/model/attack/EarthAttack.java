package fr.esiea.pokejava.model.attack;

import java.util.Map;

public class EarthAttack extends Attack{
    public EarthAttack(String name, int power, int nbUse, double fail) {
        super(name, power, nbUse, fail);
    }
    public  EarthAttack(Map<String,String> data){
        super(data);
    }
    public EarthAttack(EarthAttack attack){
        super(attack.getName(),attack.getPower(),attack.getNbUse(),attack.getFail());
    }

    @Override
    public String toString() {
       String result = super.toString();
       result += "Type : Sol";
        return result;
    }
}

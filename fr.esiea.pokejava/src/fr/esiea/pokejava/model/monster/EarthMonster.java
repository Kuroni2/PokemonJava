package fr.esiea.pokejava.model.monster;

import fr.esiea.pokejava.model.attack.Attack;
import fr.esiea.pokejava.model.attack.EarthAttack;
import fr.esiea.pokejava.model.attack.ElectricAttack;

import java.util.Map;

public class EarthMonster  extends Monster{

    private double hide;
    public EarthMonster(String name, int hp, int attack, int defense, int speed,double hide) {
        super(name, hp, attack, defense, speed);
        this.hide = hide;
    }
    public EarthMonster(EarthMonster monster){
        super(monster);
        this.hide = monster.hide;
    }
    public EarthMonster(Map<String,String> data){
        super(data);
        this.hide = Double.parseDouble(data.get("Hide"));
    }
    public boolean isSameType(Attack attack){
        return attack instanceof EarthAttack;
    }

    @Override
    public String getType() {
        return "Sol";
    }


}

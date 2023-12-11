package fr.esiea.pokejava.model.monster;

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
}

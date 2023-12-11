package fr.esiea.pokejava.model.attack;

public class Attack {

    private String name;
    private String type;
    private int power;
    private int nbUse;
    private double fail;

    public Attack(String name, String type, int power, int nbUse, double fail) {
        this.name = name;
        this.type = type;
        this.power = power;
        this.nbUse = nbUse;
        this.fail = fail;
    }
}

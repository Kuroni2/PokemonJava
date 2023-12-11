package fr.esiea.pokejava.model.attack;

import java.util.Map;

public abstract class Attack {

    private String name;
    private int power;
    private int nbUse;
    private double fail;

    public Attack(String name,  int power, int nbUse, double fail) {
        this.name = name;
        this.power = power;
        this.nbUse = nbUse;
        this.fail = fail;
    }
    public Attack(Map<String, String> data) {
        this.name = data.get("Name");
        this.power = Integer.parseInt(data.get("Power"));
        this.nbUse = Integer.parseInt(data.get("NbUse"));
        this.fail = Double.parseDouble(data.get("Fail"));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getNbUse() {
        return nbUse;
    }

    public void setNbUse(int nbUse) {
        this.nbUse = nbUse;
    }

    public double getFail() {
        return fail;
    }

    public void setFail(double fail) {
        this.fail = fail;
    }

}

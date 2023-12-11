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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

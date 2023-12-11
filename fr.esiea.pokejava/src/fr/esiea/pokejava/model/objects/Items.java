package fr.esiea.pokejava.model.objects;

public abstract class Items {
    String nom;
    String type;
    public Items(String nom, String type) {
        this.nom = nom;
        this.type = type;
    }
    public abstract void utiliser();

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

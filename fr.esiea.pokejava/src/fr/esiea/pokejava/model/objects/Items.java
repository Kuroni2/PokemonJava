package fr.esiea.pokejava.model.objects;

public abstract class Items {
    String nom;
    public Items(String nom) {
        this.nom = nom;
    }
    public abstract void utiliser();

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

}

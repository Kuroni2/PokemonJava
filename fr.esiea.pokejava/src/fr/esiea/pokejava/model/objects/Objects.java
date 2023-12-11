package fr.esiea.pokejava.model.objects;

public abstract class Objects {
    String nom;
    public Objects(String nom) {
        this.nom = nom;
    }
    public abstract void utiliser();
}

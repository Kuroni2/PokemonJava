package fr.esiea.pokejava.model.objects;

public abstract class Objects {
    String nom;
    String type;
    public Objects(String nom, String type) {
        this.nom = nom;
        this.type = type;
    }
    void use(Monster target) {
        // Logique d'utilisation de l'objet sur le monstre
        System.out.println("Utilisation de l'objet " + name + " sur " + target.name);
    }
    public abstract void utiliser();
}

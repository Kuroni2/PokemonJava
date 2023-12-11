package fr.esiea.pokejava.model.objects;

public abstract class Objects {
    String nom;
        public Object(String nom) {
            this.nom = nom;
        }
        abstract void utiliser();
}

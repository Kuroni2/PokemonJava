package fr.esiea.pokejava.model.objects;


public class Potion extends Objet {
    int pointsDeVie;
    int bonusAttaque;

    public Potion(String nom, int pointsDeVie, int bonusAttaque) {
        super(nom);
        this.pointsDeVie = pointsDeVie;
        this.bonusAttaque = bonusAttaque;
    }

    @Override
    void utiliser() {
        // Implémentation spécifique de l'effet de la potion
        System.out.println("La potion '" + nom + "' a été utilisée.");
        System.out.println("Effet : Régénération de " + pointsDeVie + " points de vie");
        System.out.println("Effet : Augmentation de l'attaque de " + bonusAttaque);
        // Logique de mise à jour des caractéristiques du monstre
    }
}

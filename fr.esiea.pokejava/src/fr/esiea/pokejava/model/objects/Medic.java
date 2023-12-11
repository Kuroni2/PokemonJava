package fr.esiea.pokejava.model.objects;

public class Medicament extends Objet {
    String effet;

    public Medicament(String nom, String effet) {
        super(nom);
        this.effet = effet;
    }

    @Override
    void utiliser() {
        // Implémentation spécifique de l'effet du médicament
        System.out.println("Le médicament '" + nom + "' a été utilisé.");
        System.out.println("Effet : " + effet);
        // Logique de gestion de l'état du monstre
    }
}

/* 
// Exemple d'utilisation
public class TestObjets {
    public static void main(String[] args) {
        Potion potionSoin = new Potion("Potion de soin", 50, 0);
        Medi
*/
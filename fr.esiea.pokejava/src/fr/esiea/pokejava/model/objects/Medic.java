package fr.esiea.pokejava.model.objects;

public class Medic {
    def__init__ (self, name , effect)
        self.name = name
        self.effect = effect

    def use(self, target):
        print(f"Utilisation du médicament {self.name} sur {target.name}")
        self.effect(target)

/*class Monster:
    def __init__(self, name, health, attack):
        self.name = name
        self.health = health
        self.attack = attack

    def display_status(self):
        print(f"{self.name}: Vie - {self.health}, Attaque - {self.attack}")
*/
# Exemple d'effets pour les potions et médicaments
def heal_effect(target):
    target.health += 20
    print(f"{target.name} a été soigné de 20 points de vie.")

def buff_attack_effect(target):
    target.attack += 5
    print(f"{target.name} a obtenu un bonus de 5 points d'attaque.")

def cure_burn_effect(target):
    print(f"{target.name} a été guéri de la brûlure.")

# Création d'objets
health_potion = Potion("Potion de Vie", heal_effect)
attack_buff_potion = Potion("Potion de Force", buff_attack_effect)
burn_cure_medicament = Medicament("Médicament Anti-Brûlure", cure_burn_effect)

}
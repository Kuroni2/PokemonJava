package fr.esiea.pokejava.model.objects;

public class Pot {

    def __init__(self, name, effect):
        self.name = name
        self.effect = effect

    def use(self, target):
        print(f"Utilisation de la potion {self.name} sur {target.name}")
        self.effect(target)

# Création d'un monstre
dragon = Monster("Dragon", 50, 10)
        
# Utilisation d'objets sur le monstre
dragon.display_status()
health_potion.use(dragon)
attack_buff_potion.use(dragon)
burn_cure_medicament.use(dragon)
dragon.display_status()
}

package fr.esiea.pokejava.game;

import fr.esiea.pokejava.model.monster.*;
import fr.esiea.pokejava.model.player.Player;
import fr.esiea.pokejava.parser.MonsterParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Game {
    public static Player player1 = new Player(1,new HashMap<>(),new ArrayList<>());
    public static Player player2 = new Player(2,new HashMap<>(),new ArrayList<>());

    public static HashMap<String,Monster> pokedex = new HashMap<>();

    private static final MonsterParser mParser = new MonsterParser();

    public static void main(String[] args) {
        pokedex.put("Salamèche",new FireMonster("Salamèche",20,15,15,15));
        pokedex.put("Carapuce",new WaterMonster("Carapuce",20,15,15,15));
        pokedex.put("Herbizarre",new PlantMonster("Herbizarre",20,15,15,15));
        //Game.mParser.parse();
        Scanner sc = new Scanner(System.in);
        System.out.println(" |  __ \\    | |           | |                  \n" +
                " | |__) |__ | | _____     | | __ ___   ____ _  \n" +
                " |  ___/ _ \\| |/ / _ \\_   | |/ _` \\ \\ / / _` | \n" +
                " | |  | (_) |   <  __/ |__| | (_| |\\ V / (_| | \n" +
                " |_|   \\___/|_|\\_\\___|\\____/ \\__,_| \\_/ \\__,_| \n" +
                "                                               \n" +
                "                                         ");
            init();
            selectTeam(player1);
            selectTeam(player2);
            battle();

    }
    public static void init(){
        pokedex.put("Salamèche",new FireMonster("Salamèche",20,15,15,15));
        pokedex.put("Carapuce",new WaterMonster("Carapuce",20,15,15,15));
        pokedex.put("Herbizarre",new PlantMonster("Herbizarre",20,15,15,15));

//        for (Monster monster :
//                Game.pokedex) {
//            pokenames.put(monster.getName(), monster);
//        }
    }

    public static void selectTeam(Player player){

        Scanner sc = new Scanner(System.in);
        System.out.println("Player " + player.getNumber()+" you need to chose your team. ");
        System.out.println("You can choose in this list :");
        for (String name :
                pokedex.keySet()) {
            System.out.println(name);
        }
        while (player.getTeam().size() != 3) {
            String pokeName = sc.nextLine();
            while (!pokedex.containsKey(pokeName)) {
                System.out.println("Hmmm... Ce pokémon n'est pas dans la liste...");
                pokeName = sc.nextLine();
            }
            while(player.getTeam().containsKey(pokeName)){
                System.out.println("Vous avez déjà ce Pokémon dans votre équipe...");
                pokeName = sc.nextLine();
            }
            Monster pokemon = pokedex.get(pokeName);
            System.out.println("Parfait, vous avez choisi "+ pokeName);
            System.out.println("Votre équipe est composé actuellement de : ");

            if(pokemon instanceof EarthMonster){
                player.getTeam().put(pokeName, new EarthMonster((EarthMonster) pokemon));
            }else if(pokemon instanceof FireMonster){
                player.getTeam().put(pokeName, new FireMonster((FireMonster) pokemon));
            }else if(pokemon instanceof WaterMonster){
                player.getTeam().put(pokeName, new WaterMonster((WaterMonster) pokemon));
            }else if(pokemon instanceof ElectrikMonster){
                player.getTeam().put(pokeName, new ElectrikMonster((ElectrikMonster) pokemon));
            }else if(pokemon instanceof PlantMonster){
                player.getTeam().put(pokeName, new PlantMonster((PlantMonster) pokemon));
            }else if(pokemon instanceof InsectMonster){
                player.getTeam().put(pokeName, new InsectMonster((InsectMonster) pokemon));
            }

            for (Monster monster:
                    player.getTeam().values()) {
                System.out.println(monster.getName());
            }
        }

    }
    public static void battle(){

        static void switchMonster(Player player, Scanner scanner) {
            // Logique de changement de monstre
            System.out.println(player.nom + " a changé de monstre.");
        }
    
        static void useObjects(Player player, Scanner scanner) {
            // Logique d'utilisation d'un objet
            System.out.println(player.nom + " a utilisé un objet.");
        }
    
        static void attack(Player player, Player opponent) {
            // Logique d'attaque entre les monstres
            System.out.println(player.nom + " a attaqué " + opponent.name + ".");
        }
    
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
    
            // Création des joueurs et de leurs monstres
            Player player1 = new Player("Joueur 1");
            Player player2 = new Player("Joueur 2");
    
            player1.monsters.add(new Monster("Dragon", 50, 10, 8));
            player1.monsters.add(new Monster("Gobelin", 30, 5, 12));
    
            player2.monsters.add(new Monster("Loup", 40, 8, 10));
            player2.monsters.add(new Monster("Orc", 35, 7, 9));
    
            // Début du combat
            while (!player1.isDefeated() && !player2.isDefeated()) {
                // Affichage des statuts des joueurs
                player1.displayMonsters();
                player2.displayMonsters();
    
                // Affichage des options et prise de décision du joueur 1
                System.out.println("\n" + player1.nom + ", choisissez une action :");
                System.out.println("1. Changer de monstre");
                System.out.println("2. Utiliser un objet");
                System.out.println("3. Attaquer");
                int choice = scanner.nextInt();
    
                switch (choice) {
                    case 1:
                        switchMonster(player1, scanner);
                        break;
                    case 2:
                        useObjects(player1, scanner);
                        break;
                    case 3:
                        attack(player1, player2);
                        break;
                    default:
                        System.out.println("Choix invalide. Réessayez.");
                        break;
                }
    
                // Laisser un peu de temps pour afficher les résultats avant de passer au tour suivant
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
    
                // Échange des rôles (joueur 2 agit)
                Player temp = player1;
                player1 = player2;
                player2 = temp;
            }
    
            // Affichage du résultat du combat
            if (player1.isDefeated()) {
                System.out.println(player2.nom + " a remporté le combat !");
            } else {
                System.out.println(player1.nom + " a remporté le combat !");
            }
    
            scanner.close();
        }
    }


}
                                                                                                  
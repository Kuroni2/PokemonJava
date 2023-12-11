package fr.esiea.pokejava.game;

import fr.esiea.pokejava.model.attack.Attack;
import fr.esiea.pokejava.model.monster.*;
import fr.esiea.pokejava.model.player.Player;
import fr.esiea.pokejava.parser.MonsterParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Game {
    public static Player player1 = new Player(1,new HashMap<>(),new ArrayList<>());
    public static Player player2 = new Player(2,new HashMap<>(),new ArrayList<>());

    public static HashMap<String,Monster> pokedex = new HashMap<>();
    public static HashMap<String, Attack> attacks = new HashMap<>();

    private static final MonsterParser mParser = new MonsterParser();

    public static void main(String[] args) {
        String userDir = System.getProperty("user.dir");
        System.out.println(userDir);
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
        mParser.parse();

    }

    public static void selectTeam(Player player){

        Scanner sc = new Scanner(System.in);
        System.out.println("Joueur " + player.getNumber()+" vous devez choisir votre équipe. ");
        System.out.println("Vous pouvez choisir des pokémons dans cette liste (pas de doublon) :");
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
            player.displayMonsters();

        }

    }
    public static void battle(){

        Scanner scanner = new Scanner(System.in);
        // Début du combat
        while (!player1.isDefeated() && !player2.isDefeated()) {
            // Affichage des statuts des joueurs
            player1.displayMonsters();
            player2.displayMonsters();

            // Affichage des options et prise de décision du joueur 1
            System.out.println("\n Joueur" + player1.getNumber() + ", choisissez une action :");
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
            System.out.println("Joueur" + player2.getNumber() + " a remporté le combat !");
        } else {
            System.out.println("Joueur" + player1.getNumber() + " a remporté le combat !");
        }


    }
   public static void switchMonster(Player player, Scanner scanner) {
        // Logique de changement de monstre
        System.out.println("Joueur" + player.getNumber() + " a changé de monstre.");
    }

    public static void useObjects(Player player, Scanner scanner) {
        // Logique d'utilisation d'un objet
        System.out.println("Joueur" + player.getNumber() + " a utilisé un objet.");
    }

    public static void attack(Player player, Player opponent) {
        // Logique d'attaque entre les monstres
        System.out.println("Joueur" + player.getNumber() + " a attaqué le joueur " +opponent.getNumber() + ".");
    }



}
                                                                                                  
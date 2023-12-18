package fr.esiea.pokejava.game;

import fr.esiea.pokejava.model.attack.*;
import fr.esiea.pokejava.model.monster.*;
import fr.esiea.pokejava.model.player.Player;
import fr.esiea.pokejava.parser.AttackParser;
import fr.esiea.pokejava.parser.MonsterParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Game {
    public static Player player1 = new Player(1,new HashMap<>(),new ArrayList<>());
    public static Player player2 = new Player(2,new HashMap<>(),new ArrayList<>());

    public static Player currentPlayer = player1;

    public static HashMap<String,Monster> pokedex = new HashMap<>();
    public static HashMap<String, Attack> attacks = new HashMap<>();

    private static final MonsterParser mParser = new MonsterParser();
    private static final AttackParser aParser = new AttackParser();

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
            selectAttack(player1);
            selectTeam(player2);
            selectAttack(player2);
            battle();

    }
    public static void init(){
        mParser.parse();
        aParser.parse();

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
    public static void selectAttack(Player player){
        Scanner sc = new Scanner(System.in);
        System.out.println("Très bien, maintenant tu dois choisir les attaques de tes pokémons tu as le choix parmi celle-ci : ");
        for (Monster monster : player.getTeam().values()){
            System.out.println("Allez choisi les attaques de ton " + monster.getName());
            for (Attack attack : attacks.values()){
                if(monster.isSameType(attack) || attack instanceof NormalAttack){
                    System.out.println(attack);
                }
            }
            while(monster.getAttacks().size() != 4){
                String attackName = sc.nextLine();
                while(!attacks.containsKey(attackName)){
                    System.out.println("Hmmm... Il semblerait que cette attaque n'existe pas ou n'est pas dans la liste...");
                   attackName = sc.nextLine();
                }
                while(monster.getAttacks().containsKey(attackName)){
                    System.out.println("Il semblerait que ce pokémon connaît déjà cette attaque...");
                    attackName = sc.nextLine();

                }
                Attack attack = attacks.get(attackName);
                if(attack instanceof EarthAttack){
                    monster.getAttacks().put(attackName, new EarthAttack((EarthAttack) attack));
                }else if(attack instanceof FireAttack){
                    monster.getAttacks().put(attackName, new FireAttack((FireAttack) attack));
                }else if(attack instanceof WaterAttack){
                    monster.getAttacks().put(attackName, new WaterAttack((WaterAttack) attack));
                }else if(attack instanceof ElectricAttack){
                    monster.getAttacks().put(attackName, new ElectricAttack((ElectricAttack) attack));
                }else if(attack instanceof PlantAttack){
                    monster.getAttacks().put(attackName, new PlantAttack((PlantAttack) attack));
                }else if(attack instanceof InsectAttack){
                    monster.getAttacks().put(attackName, new InsectAttack((InsectAttack) attack));
                }else if(attack instanceof NormalAttack){
                    monster.getAttacks().put(attackName, new NormalAttack((NormalAttack) attack));
                }

            }
        }

    }
    public static void battle(){

        Scanner scanner = new Scanner(System.in);
        // Début du combat
        while (!player1.isDefeated() && !player2.isDefeated()) {
            // Affichage des options et prise de décision du joueur 1
            action(currentPlayer,scanner);
            // Laisser un peu de temps pour afficher les résultats avant de passer au tour suivant
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Échange des rôles (joueur 2 agit)
            if(currentPlayer == player1){
                currentPlayer = player2;
            }else{
                currentPlayer = player1;
            }
        }

        // Affichage du résultat du combat
        if (player1.isDefeated()) {
            System.out.println("Joueur" + player2.getNumber() + " a remporté le combat !");
        } else {
            System.out.println("Joueur" + player1.getNumber() + " a remporté le combat !");
        }


    }


    public static void useObjects(Player player, Scanner scanner) {
        // Logique d'utilisation d'un objet
        System.out.println("Joueur" + player.getNumber() + " a utilisé un objet.");
    }

    public static void attack(Player player, Player opponent) {
        // Logique d'attaque entre les monstres
        System.out.println("Joueur" + player.getNumber() + " a attaqué le joueur " +opponent.getNumber() + ".");
    }

    public static void action(Player player, Scanner scanner){
        System.out.println("\n Joueur" + player1.getNumber() + ", choisissez une action :");
        System.out.println("1. Changer de monstre");
        System.out.println("2. Utiliser un objet");
        System.out.println("3. Attaquer");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                player1.switchMonster( scanner);
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

    }


}
                                                                                                  
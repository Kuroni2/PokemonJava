package fr.esiea.pokejava.game;

import fr.esiea.pokejava.model.game.EndState;
import fr.esiea.pokejava.model.game.GameState;
import fr.esiea.pokejava.model.monster.Monster;
import fr.esiea.pokejava.parser.MonsterParser;

import java.util.List;
import java.util.Scanner;

public class Game {
    public static GameState state;

    public static List<Monster> pokedex;

    private static final MonsterParser mParser = new MonsterParser();

    public static void main(String[] args) {
        Game.mParser.parse("../config/pokemon.txt");
        Scanner sc = new Scanner(System.in);
        System.out.println(" |  __ \\    | |           | |                  \n" +
                " | |__) |__ | | _____     | | __ ___   ____ _  \n" +
                " |  ___/ _ \\| |/ / _ \\_   | |/ _` \\ \\ / / _` | \n" +
                " | |  | (_) |   <  __/ |__| | (_| |\\ V / (_| | \n" +
                " |_|   \\___/|_|\\_\\___|\\____/ \\__,_| \\_/ \\__,_| \n" +
                "                                               \n" +
                "                                         ");
        while(!(Game.state instanceof EndState)){
           String result =  sc.nextLine();
            if(result.equals("end")){
                Game.state = new EndState();
            }
        }
    }
}

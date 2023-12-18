package fr.esiea.pokejava.parser;

import fr.esiea.pokejava.game.Game;
import fr.esiea.pokejava.model.monster.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MonsterParser {
    public void parse() {
        try (BufferedReader br = new BufferedReader(new FileReader("fr.esiea.pokejava/config/pokemon.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("Monster")) {
                    Map<String, String> monsterData = parseMonster(br);
                    System.out.println("Monster Data: " + monsterData);
                    switch (monsterData.get("Type")){
                        case("Electric") -> Game.pokedex.put(monsterData.get("Name"),new ElectrikMonster(monsterData));
                        case("Water") -> Game.pokedex.put(monsterData.get("Name"),new WaterMonster(monsterData));
                        case("Earth") -> Game.pokedex.put(monsterData.get("Name"),new EarthMonster(monsterData));
                        case("Insect") -> Game.pokedex.put(monsterData.get("Name"),new InsectMonster(monsterData));
                        case("Plant") -> Game.pokedex.put(monsterData.get("Name"),new PlantMonster(monsterData));
                        case("Fire") -> Game.pokedex.put(monsterData.get("Name"),new FireMonster(monsterData));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Map<String, String> parseMonster(BufferedReader br) throws IOException {
        Map<String, String> monsterData = new HashMap<>();
        String line;

        while ((line = br.readLine()) != null && !line.trim().equals("EndMonster")) {
            String[] parts = line.split("\\s+", 2);

            if (parts.length == 2) {
                String key = parts[0].trim();
                String value = parts[1].trim();
                monsterData.put(key, value);
            }
        }

        return monsterData;
    }

}

package fr.esiea.pokejava.parser;

import fr.esiea.pokejava.game.Game;
import fr.esiea.pokejava.model.attack.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AttackParser {
    public void parse() {
        try (BufferedReader br = new BufferedReader(new FileReader("fr.esiea.pokejava/config/attack"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("Attack")) {
                    Map<String, String> attackData = parseMonster(br);
                    System.out.println("Attack Data: " + attackData);
                    switch (attackData.get("Type")){
                        case("Electric") -> Game.attacks.put(attackData.get("Name"),new ElectricAttack(attackData));
                        case("Water") -> Game.attacks.put(attackData.get("Name"),new WaterAttack(attackData));
                        case("Earth") -> Game.attacks.put(attackData.get("Name"),new EarthAttack(attackData));
                        case("Insect") -> Game.attacks.put(attackData.get("Name"),new InsectAttack(attackData));
                        case("Plant") -> Game.attacks.put(attackData.get("Name"),new PlantAttack(attackData));
                        case("Fire") -> Game.attacks.put(attackData.get("Name"),new FireAttack(attackData));
                        default -> Game.attacks.put(attackData.get("Name"),new NormalAttack(attackData));
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

        while ((line = br.readLine()) != null && !line.trim().equals("EndAttack")) {
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

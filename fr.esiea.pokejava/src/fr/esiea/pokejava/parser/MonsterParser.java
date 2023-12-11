package fr.esiea.pokejava.parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MonsterParser {
    public void parse(String filePath) {
        String filename = filePath;

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("Monster")) {
                    Map<String, String> monsterData = parseMonster(br);
                    System.out.println("Monster Data: " + monsterData);
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

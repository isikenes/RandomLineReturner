package com.ei.RandomLineReturner;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Path path = Paths.get(args[0]);
        Random random = new Random();
        try {
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            int x = Integer.parseInt(args[1]);
            HashSet<String> randomLines = new HashSet<>();

            while (randomLines.size() != x) {
                randomLines.add(lines.get(random.nextInt(lines.size())));
            }

            for (String s : randomLines) {
                System.out.println(s);
            }
        } catch (IOException e) {
            System.out.format("I/O error: %s%n", e);
        }
    }

}

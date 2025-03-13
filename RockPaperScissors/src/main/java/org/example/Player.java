package org.example;

import java.util.Scanner;

public class Player {
    private String name;
    private int numWins;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumWins() {
        return numWins;
    }

    public void addNumWins() {
        this.numWins++;
    }

    public Move makeMove() {
        String move;

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print(this.name + " joga: ");
            move = scanner.next().toUpperCase();

            try {
                return Move.valueOf(move);
            } catch (IllegalArgumentException e) {
                System.out.println("Movimento inválido: " + move);
            }
        }
    }
}

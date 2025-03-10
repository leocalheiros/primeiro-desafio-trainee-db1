package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private final Player player1 = new Player();
    private final Player player2 = new Player();
    private final Scanner scanner = new Scanner(System.in);
    private final GameHistory gameHistory = new GameHistory();
    private String option = "";

    public Game(){}

    public void round() {
        Move move1 = player1.makeMove();
        Move move2 = player2.makeMove();
        String winner;

        if (move1.beats(move2)) {
            System.out.println(player1.getName() + " ganhou");
            player1.addNumWins();
            winner = player1.getName();
        } else if (move2.beats(move1)) {
            System.out.println(player2.getName() + " ganhou");
            player2.addNumWins();
            winner = player2.getName();
        } else {
            System.out.println("Empate");
            winner = "EMPATE";
        }

        System.out.println("\nPlacar: ");
        System.out.println(player1.getName() + ": " + player1.getNumWins());
        System.out.println(player2.getName() + ": " + player2.getNumWins());
        gameHistory.add(player1.getName(), player2.getName(), move1, move2, winner);
    }

    public void start() {
        System.out.print("Jogador 1, digite seu nome: ");
        player1.setName(scanner.nextLine());
        System.out.print("Jogador 2, digite seu nome: ");
        player2.setName(scanner.nextLine());
        round();

        while (!option.equals("n")) {
            System.out.print("\nDeseja jogar novamente? (s/n): ");
            option = scanner.nextLine().toLowerCase();
            if (!option.equals("s") && !option.equals("n")) {
                System.out.println("Opção inválida: " + option);
            } else if (option.equals("s")) {
                round();
            }
        }

        gameHistory.print();
    }
}

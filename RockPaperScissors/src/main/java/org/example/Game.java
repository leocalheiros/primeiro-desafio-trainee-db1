package org.example;

import java.util.Scanner;

public class Game {
    private final Player player1 = new Player();
    private final Player player2 = new Player();
    private final Scanner scanner = new Scanner(System.in);
    private final GameHistory gameHistory = new GameHistory();

    public boolean checkOption() {
        String option;
        while (true) {
            System.out.print("\nDeseja jogar novamente? (s/n): ");
            option = scanner.nextLine().toLowerCase();
            if (option.equals("s")) return true;
            if (option.equals("n")) return false;

            System.out.println("Opção inválida: " + option);
        }

    }

    public void round() {
        Move move1 = player1.makeMove();
        Move move2 = player2.makeMove();
        boolean hasPlayer1Won = move1.beats(move2);
        boolean hasPlayer2Won = move2.beats(move1);
        boolean hasTied = !hasPlayer2Won && !hasPlayer1Won;
        String winner = "";

        if (hasPlayer1Won) {
            System.out.println(player1.getName() + " ganhou");
            player1.addNumWins();
            winner = player1.getName();
        }

        if (hasPlayer2Won) {
            System.out.println(player2.getName() + " ganhou");
            player2.addNumWins();
            winner = player2.getName();
        }

        if (hasTied) {
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

        do {
            round();
        } while (checkOption());

        gameHistory.print();
    }
}

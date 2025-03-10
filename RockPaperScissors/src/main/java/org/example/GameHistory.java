package org.example;

import java.util.ArrayList;
import java.util.List;

public class GameHistory {
    private final List<String> history = new ArrayList<>();

    public void print() {
        if (history.size() > 5) {
            history.removeFirst();
        }
        System.out.println("\n========== ÚLTIMAS PARTIDAS ==========");
        for (String s : history) {
            System.out.println(s);
        }
    }

    public void add(String player1, String player2, Move move1, Move move2, String winner) {
        history.add(String.format("%s (%s) vs %s (%s): %s", player1, move1, player2, move2, winner));
    }
}

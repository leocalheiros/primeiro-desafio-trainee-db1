package org.example;

public enum Move {
    PEDRA,
    PAPEL,
    TESOURA;

    public boolean beats(Move m) {
        return (this == PEDRA && m == TESOURA) ||
                (this == PAPEL && m == PEDRA) ||
                (this == TESOURA && m == PAPEL);
    }
}

package src.entities.jeu;

/**
 * les new Case() sont seulement utilises dans board
 */

public class Case {
    /**
     * les enums quon va pouvoir utiliser pour la mise en place d1 board vide
     *
     */
    public static final int taille = 8;
    public static final char[] index = {'A','B','C','D','E','F','G','H'};

    private char X; //horizontal
    private int Y; //vertical //

    public Case(char X, int Y) {
        this.X = X;
        this.Y = Y;
    }

    public char getX() {
        return X;
    }

    public int getY() {
        return Y;
    }
}

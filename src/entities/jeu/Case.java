package src.entities.jeu;

/**
 * case quoi
 */

public class Case {
    /**
     * les enums quon va pouvoir utiliser pour la mise en place d1 board vide ou utliser les index
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

    @Override
    public String toString() {
        return "" + X + Y;   // pas necessaire et inutil pour linstant
    }
}

package src.entities.jeu;

/**
 * case quoi
 */

public class Case {
    /**
     * les enums quon va pouvoir utiliser pour la mise en place d1 board vide ou utliser les index
     */
    public static final int taille = 8;
    private static final char[] index = {'A','B','C','D','E','F','G','H'};

    private final char X; //horizontal
    private final int Y; //vertical //

    public Case(char X, int Y) {
        assert X >= index[0] && X <= index[index.length - 1];
        assert Y > 0 && Y <= taille;
        this.X = X;
        this.Y = Y;
    }

    public char getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public static char[] getIndex(){
        return index.clone();
    }

    @Override
    public String toString() {
        return "" + X + Y;   // pas necessaire et inutil pour linstant
    }

    public boolean sameCase(Case c){return c.getX() == this.getX() && c.getY() == this.getY();}
}

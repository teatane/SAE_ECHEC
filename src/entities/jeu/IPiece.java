package src.entities.jeu;
import java.util.*;

public interface IPiece {

    Case getPosition();
    String getNom();
    String getColor();
    void setPosition(Case position);
    List<Case> getMove(Map<Case, IPiece> board);
    boolean sameColor(String color);
}

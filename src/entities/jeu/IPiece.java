package src.entities.jeu;
import java.util.*;

public interface IPiece {

    public Case getPosition();
    public String getNom();
    public String getColor();
    public void setPosition(Case position);
    public List<Case> getMove(Map<Case, IPiece> board);
    public boolean sameColor(String color);
}

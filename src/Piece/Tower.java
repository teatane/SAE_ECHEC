package src.Piece;

import java.util.*;

public class Tower implements IPiece{

    public String nom;
    public String position;
    public String color;


    public Tower(String position){
        this.nom = "tower";
        this.position = position;
    }

    @Override
    public String getPosition(){
        return position;
    }

    @Override
    public String getNom(){
        return nom;
    }

    @Override
    public String getColor(){
        return color;
    }

    @Override
    public boolean sameColor(String color){
        return this.color.equals(color);
    }

    @Override
    public void setPosition(String position){
        this.position = position;
    }


    @Override
    public List<String> getMove(Map<String, IPiece> board) {

        String pos = this.position;
        char lettre = pos.charAt(0);  // colonne A-H
        char chiffre = pos.charAt(1); // ligne 1-8

        List<String> movePossible = new ArrayList<>();

        // vertical haut
        for (char i = (char)(chiffre + 1); i <= '8'; i++) {
            String newPos = "" + lettre + i;

            if (!board.containsKey(newPos)) {
                movePossible.add(newPos);
            } else {
                movePossible.add(newPos);   // capture possible
                break;                      // stoppe le rayon
            }
        }

        // vertical bas
        for (char i = (char)(chiffre - 1); i >= '1'; i--) {
            String newPos = "" + lettre + i;

            if (!board.containsKey(newPos)) {
                movePossible.add(newPos);
            } else {
                movePossible.add(newPos);
                break;
            }
        }

        // horizontal droit
        for (char i = (char)(lettre + 1); i <= 'H'; i++) {
            String newPos = "" + i + chiffre;

            if (!board.containsKey(newPos)) {
                movePossible.add(newPos);
            } else {
                movePossible.add(newPos);
                break;
            }
        }

        // horizontal gauche
        for (char i = (char)(lettre - 1); i >= 'A'; i--) {
            String newPos = "" + i + chiffre;

            if (!board.containsKey(newPos)) {
                movePossible.add(newPos);
            } else {
                movePossible.add(newPos);
                break;
            }
        }

        return movePossible;
    }
}

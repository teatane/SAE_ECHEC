package src.Piece;

import java.util.*;

public class King implements IPiece{

    public String nom;
    public String position;
    public String color;


    public King(String position, String color){
        this.nom = "king";
        this.position = position;
        this.color = color;
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
    public void setPosition(String position){
        this.position = position;
    }

    @Override
    public boolean sameColor(String color){
        return this.color.equals(color);
    }


    @Override
    public List<String> getMove(Map<String, IPiece> board) {
        String pos = this.position;   // utiliser this, pas un paramètre externe
        char lettre = pos.charAt(0);
        char chiffre = pos.charAt(1);
        List<String> movePossible = new ArrayList<>();

        int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
        int[] dy = {-1,-1,-1,  0, 0, 1, 1, 1};

        for (int i = 0; i < dx.length; i++) {
            char newLettre = (char)(lettre + dx[i]);
            char newChiffre = (char)(chiffre + dy[i]);

            if (newLettre >= 'A' && newLettre <= 'H' &&
                    newChiffre >= '1' && newChiffre <= '8') {

                String newPos = "" + newLettre + newChiffre;
                movePossible.add(newPos);
            }
        }

        return movePossible;
    }

}

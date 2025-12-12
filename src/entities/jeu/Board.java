package src.entities.jeu;

import java.util.*;

public class Board {

    private Map<String, IPiece> board = new LinkedHashMap<>();


    public Board() { // initialiser un board vide
        for (int i = 0; i < Case.getTaille(); i++) {
            String tmp = Case.getIndex()[i];
            for (int j = 1; j <= Case.getTaille(); j++) {
                String indice = tmp + String.valueOf(j);
                board.put(indice,null);
            }
        }
    }

    public Map<String, IPiece> getBoard() {
        return board;
    } // return le board et son etat actuel


    public void setPiece(String position, IPiece piece){
        board.put(position, piece);
    } // a la position, on remplace lancienne valeur par un nouveau qui pourrait etre null

    //à changer en cas ou le mode de jeu demande le nbr de piece capturee compte
    public void removePiece(String position){ setPiece(position, null); }

    public List<String> mouvPossible(IPiece piece){

        List<String> moves = piece.getMove(board);

        for (Map.Entry<String, IPiece> entry : board.entrySet()){
            if (moves.contains(entry.getKey())){ // si dans ma liste de position, j'ai la clé
                if (entry.getValue() != null && entry.getValue().sameColor(piece.getColor())){ // si ma case n'est pas null et que la piece est de meme couleur
                    moves.remove(entry.getKey()); // ce mouvement n'est donc pas possible
                }
            }
        }

        return moves;
    }



}

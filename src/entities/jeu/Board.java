package src.entities.jeu;

import java.util.*;

public class Board {

    /**
     * Map<key = Case , valeur = IPiece>
     */
    private Map<Case, IPiece> board = new LinkedHashMap<>();


    public Board() { // initialiser un board vide
        for (int i = 0; i < Case.taille; i++) { // taille horizontale
            for (int j = 0; j < Case.taille; j++) { // taille verticale
                board.put(new Case(Case.index[i],j),null);
            }
        }
    }

    public Map<Case, IPiece> getBoard() {
        return board;
    } // return le board et son etat actuel


    public void setPiece(Case position, IPiece piece){
        board.put(position, piece);
    }
    //à changer en cas ou le mode de jeu demande le nbr de piece capturee compte
    public void removePiece(Case position){ setPiece(position, null); }

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

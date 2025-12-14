package src.entities.jeu;

import java.util.*;

public class Board {

    /**
     * Map<key = Case , valeur = IPiece>
     */
    private final Map<Case, IPiece> board = new LinkedHashMap<>();


    public Board() { // initialiser un board vide
        for (int i = 0; i < Case.taille; i++) { // taille horizontale
            for (int j = 1; j <= Case.taille; j++) { // taille verticale
                board.put(new Case(Case.getIndex()[i],j),null);
            }
        }
    }

    public Map<Case, IPiece> getBoard() {
        return board;
    } // return le board et son etat actuel

    public void setPiece(Case position, IPiece piece){
        board.put(position, piece);
    }

    public void removePiece(Case position){ setPiece(position, null); }

// les moves
    public List<Case> mouvPossible(IPiece piece){

        List<Case> movesPiece = piece.getMove(board);
        List<Case> movesPossible = new LinkedList<>();
        String couleurPiece = piece.getColor();

        for (Case c : movesPiece){
            if (board.get(c) == null || (board.get(c) != null && !board.get(c).sameColor(couleurPiece))){
                movesPossible.add(c);
            }
        }
        return movesPossible;
    }

    private List<Case> listMovesPieces(String color){ // utiliser seulement pour que le roi evite daller dans des zones qui pourrait etre jouer par lennemi
        List<Case> moves = new LinkedList<>();

        for (IPiece value : board.values()) {
            if(value.getColor().equals(color)){
                moves.addAll(this.mouvPossible(value));  //peut y avoir des doublons mais on sen fou
            }
        }

        return moves;
    }

    public List<Case> MovesRoi(IPiece roi){ //appeler seulement quand c'est un deplacement dune piece roi

        List<Case> movesPiece = this.mouvPossible(roi);
        List<Case> movesPiecesEnnemie = this.listMovesPieces(roi.getColorOppose());
        List<Case> movesPossible = new LinkedList<>();

        for(Case c1 : movesPiece){
            if(!movesPiecesEnnemie.contains(c1)){
                movesPossible.add(c1);
            }
        }
        return movesPossible;
    }
}

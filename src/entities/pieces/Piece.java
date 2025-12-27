package src.entities.pieces;

import src.entities.jeu.Case;
import src.entities.jeu.IPiece;

public abstract class Piece implements IPiece {

    private String nom;
    private Case position;
    private String color;

    public Piece(String nom, Case position, String color) {
        assert color.equals("white") || color.equals("black") ;
        assert nom.equals("rook") || nom.equals("king") ;

        this.nom = nom;
        this.position = position;
        this.color = color;
    }

    @Override
    public Case getPosition(){
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
    public String getColorOppose(){
        if(color.equals("white")){
            return "black";
        }
        return "white";
    }

    @Override
    public void setPosition(Case position){
        this.position = position;
    }

    @Override
    public boolean sameColor(String color){
        return this.color.equals(color);
    }

    @Override
    public char caractereFEN(){
        if (color.equals("white")){
            if (nom.equals("rook")){
                return 'r';
            }
            if (nom.equals("king")){
                return 'k';
            }
        }
        else if (color.equals("black")){
            if (nom.equals("king")){
                return 'K';
            }
            if (nom.equals("rook")){
                return 'R';
            }

        }

        return 0;
    }




}

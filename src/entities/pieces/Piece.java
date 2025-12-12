package src.entities.pieces;

import src.entities.jeu.Case;
import src.entities.jeu.IPiece;

public abstract class Piece implements IPiece {

    private String nom;
    private Case position;
    private String color;

    public Piece(String nom, Case position, String color) {
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
    public void setPosition(Case position){
        this.position = position;
    }

    @Override
    public boolean sameColor(String color){
        return this.color.equals(color);
    }


}

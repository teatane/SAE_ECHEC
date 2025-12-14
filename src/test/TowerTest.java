package src.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import src.entities.jeu.Board;
import src.entities.jeu.Case;
import src.entities.jeu.IPiece;
import src.entities.pieces.King;
import src.entities.pieces.Tower;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

class TowerTest {

    private Board board = new Board();

    @Test
    void test_deplacements_aleatoires(){
        Random rand = new Random();

        // 8 positions aléatoires
        for(int n = 0;n<8;n++){
            char x = Case.getIndex()[rand.nextInt(8)];
            int y = rand.nextInt(8)+1;

            Tower tour = new Tower(new Case(x,y),"blacn");

            //placer quelques pièces aléatoires pour tester le blocage
            for(int i = 0; i<5;i++){
                char px = Case.getIndex()[rand.nextInt(8)];
                int py = rand.nextInt(8)+1;
                IPiece piece = new King(new Case(px,py), i % 2 == 0 ? "blanc" :  "noir");
                board.setPiece(new Case(px,py),piece);
            }

            List<Case> coups = board.mouvPossible(tour);

            //vérifier que la Tour ne dépasse pas une pièce de même couleur
            for(Case c : coups){
                IPiece p = board.getBoard().get(c);
                Assertions.assertTrue(p==null || !p.sameColor("blanc"));
            }
        }
    }

}
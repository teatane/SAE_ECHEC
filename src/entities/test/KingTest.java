package src.entities.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import src.entities.jeu.Board;
import src.entities.jeu.Case;
import src.entities.pieces.King;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

class KingTest {
    private Board board = new Board();

    @Test
    void test_deplacements_bords(){
        char[] lettres = Case.getIndex();
        int[] lignesBords = {1,8};
        for(char lettre: lettres){
            for(int ligne: lignesBords){
                King roi = new King(new Case(lettre,ligne),"blanc");
                List<Case> coups = board.mouvPossible(roi);
                Assertions.assertTrue(coups.size() <=8);
            }
        }
    }

    @Test
    void test_deplacements_coins(){
        char[] lettres = {'A','H'};
        int[] chiffres = {1,8};
        for(char x : lettres){
            for(int y : chiffres){
                King roi = new King(new Case(x,y),"noir");
                List<Case> coups = board.mouvPossible(roi);
                assertTrue(coups.size() <=3);
            }
        }
    }

    @Test
    void test_deplacements_aleatoires(){
        Random rand = new Random();
        for(int i = 0; i < 8; i++){
            char x = Case.getIndex()[rand.nextInt(8)];
            int y = rand.nextInt(8)+1;
            King roi = new King(new Case(x,y),"blanc");
            List<Case> coups = board.mouvPossible(roi);
            assertTrue(coups.size() <=8);
        }
    }

}
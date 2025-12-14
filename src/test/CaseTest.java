package src.test;

import org.junit.Test;
import src.entities.jeu.Case;

import static org.junit.jupiter.api.Assertions.*;

public class CaseTest {
    @Test
    public void testCase() {
        Case case1 = new Case('A',1);
        Case case2 = new Case('B',2);
        Case case3 = new Case('A',1);

        assertEquals(case1.getX(), 'A');
        assertEquals(case1.getY(), 1);
        assertEquals(case2.getX(), 'B');
        assertEquals(case2.getY(), 2);

        assertTrue(case3.sameCase(case1));
        assertTrue(case1.sameCase(case3));
        assertFalse(case1.sameCase(case2));
        assertFalse(case1.sameCase(case2));

        char[] tmpIndex = {'A','B','C','D','E','F','G','H'};
        assertEquals(Case.getIndex(), tmpIndex);
    }

}
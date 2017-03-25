import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by franc on 06.03.2017.
 */
public class SudokuBoardTest {
    @Test
    public void areArraysDifferent()
    {
        SudokuBoard instance_1 = new SudokuBoard();
        SudokuBoard instance_2 = new SudokuBoard();
        SudokuSolver ss = new BacktrackingSudokuSolver();
        ss.solve(instance_1);
        ss.solve(instance_2);
        // Do podejrzenia wygenerowanych plansz sudoku
        int tab[][]=instance_1.getBoard();
        for(int i=0;i<tab.length;i++)
        {
            for(int j=0;j<tab.length;j++)
            {
                System.out.print(tab[i][j]+"    ");
            }
            System.out.print("\n");
        }
        System.out.print("\n\n\n");
        int tab2[][]=instance_2.getBoard();
        for(int i=0;i<tab2.length;i++)
        {
            for(int j=0;j<tab2.length;j++)
            {
                System.out.print(tab2[i][j]+"    ");
            }
            System.out.print("\n");
        }
        // Koniec kodu do podejrzenia wygenerowanych plansz sudoku
        assertTrue(!Arrays.equals(instance_1.getBoard(),instance_2.getBoard()));
    }
}
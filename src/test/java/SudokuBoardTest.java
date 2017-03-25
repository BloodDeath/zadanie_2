import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by franc on 06.03.2017.
 */
public class SudokuBoardTest {
    @Test
    public void areDifferent()
    {
        SudokuBoard instance_1 = new SudokuBoard();
        SudokuBoard instance_2 = new SudokuBoard();
        instance_1.fillBoard();
        instance_2.fillBoard();
        int tab[][]=instance_1.get();
        for(int i=0;i<tab.length;i++)
        {
            for(int j=0;j<tab.length;j++)
            {
                System.out.print(tab[i][j]+"    ");
            }
            System.out.print("\n");
        }
        System.out.print("\n\n\n");
        int tab2[][]=instance_2.get();
        for(int i=0;i<tab2.length;i++)
        {
            for(int j=0;j<tab2.length;j++)
            {
                System.out.print(tab2[i][j]+"    ");
            }
            System.out.print("\n");
        }
        assertTrue(!Arrays.equals(instance_1.get(),instance_2.get()));
    }

//    @Test
//    public void checkCols()
//    {
//        for (int i=0;i<9;i++)
//        {
//
//        }
//    }
//    @Test
//    public void test()
//    {
//        SudokuBoard instance= new SudokuBoard();
//        instance.fillBoard();
//        int tab[][]=instance.get();
//        for(int i=0;i<tab.length;i++)
//        {
//            for(int j=0;j<tab.length;j++)
//            {
//                System.out.print(tab[i][j]+"    ");
//            }
//            System.out.print("\n");
//        }
//        assertTrue(true);
//    }

}
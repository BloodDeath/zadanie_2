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
        assertTrue(Arrays.equals(instance_1.get(),instance_2.get()));
    }

    @Test
    public void checkCols()
    {
        for (int i=0;i<9;i++)
        {

        }
    }
}
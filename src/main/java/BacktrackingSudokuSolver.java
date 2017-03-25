import java.util.Random;

import static jdk.nashorn.internal.runtime.regexp.joni.constants.CCVALTYPE.SB;

/**
 * Created by franc on 25.03.2017.
 */
public class BacktrackingSudokuSolver extends SudokuSolver {
    SudokuBoard klasa;
    public void solve(SudokuBoard klasa)
    {
        klasa=klasa;
        fillBoard();
    }
    public void fillBoard()
    {
        int s[][]=new int[9][9];
        boolean assist_s[][]=new boolean[9][9];
        Random rand = new Random();
        int x,y;

        for(int i=0; i<17; i++)
        {
            x = rand.nextInt(9);
            y = rand.nextInt(9);
            if(s[x][y]==0)
            {
                int z= rand.nextInt(9)+1;
                if(klasa.isValid(z, x, y, s))
                {
                    s[x][y]=z;
                    assist_s[x][y]=true;
                }
                else i--;
            }
            else i--;
        }
        recurention(s);
        klasa.setBoard(s);
    }
    private boolean recurention(int[][] s)
    {
        int SIZE=9;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (s[i][j] != 0) {
                    continue;
                }
                for (int num = 1; num <= SIZE; num++) {
                    if (klasa.isValid(num, i, j, s)) {
                        s[i][j] = num;
                        if (recurention(s)) {
                            return true;
                        } else {
                            s[i][j] = 0;
                        }
                    }
                }
                return false;
            }
        }
        return true;
    }
}

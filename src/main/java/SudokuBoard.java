import com.sun.javaws.exceptions.ExitException;

import java.util.Random;

/**
 * Created by franc on 06.03.2017.
 */
public class SudokuBoard {
    private int board[][];
    private boolean assist_board[][];
    public void fillBoard()
    {
        board=new int[9][9];
        assist_board= new boolean[9][9];
        Random rand = new Random();
        int x,y;

        for(int i=0; i<17; i++)
        {
            x = rand.nextInt(9);
            y = rand.nextInt(9);
            if(board[x][y]==0)
            {
                int z= rand.nextInt(9)+1;
                if(smallSquareOk(z, x, y,board) && lineOk(z, y,board) && columnOk(z, x,board))
                {
                    board[x][y]=z;
                    assist_board[x][y]=true;
                }
                else i--;
            }
            else i--;
        }
        recurention(board);

    }
    private boolean isValid(int number,int x,int y, int[][]s)
    {
        return lineOk(number, y, s) && columnOk(number, x, s) && smallSquareOk(number, x, y, s);
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
                        if (isValid(num, i, j, s)) {
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
            board=s;
            return true;

    }
    private boolean smallSquareOk(int number,int x, int y, int[][] s)
    {
        for (int i = (x / 3) * 3; i<3+(x/3)*3; i++)
        {
            for(int j = (y / 3) * 3; j<3+(y/3)*3; j++)
            {
                if(s[i][j]==number )return false;
            }
        }
        return true;
    }
    private boolean lineOk(int number, int line,int[][]s )
    {
        for(int i=0;i<9;i++)
        {
            if(s[i][line]==number) return false;
        }
        return true;
    }
    private boolean columnOk(int number, int column,int[][] s)
    {
        for(int i=0;i<9;i++)
        {
            if(s[column][i]==number) return false;
        }
        return true;
    }
    public int[][] get()
{
    return board;
}
}
import java.util.Random;

/**
 * Created by franc on 06.03.2017.
 */
public class SudokuBoard {
    private int board[][];
    private boolean assist_board[][];
    SudokuBoard()
    {
        board=new int[9][9];
        assist_board= new boolean[9][9];
    }
    public boolean isValid(int number,int x,int y, int[][]s)
    {
        return lineOk(number, y, s) && columnOk(number, x, s) && smallSquareOk(number, x, y, s);
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
    public int[][] getBoard()
{
    return board;
}
    public int get(int x, int y) {return board[x][y];}
    public boolean setBoard(int [][]s)
    {
        boolean valid=true;
        for(int i=0;i<9;i++)
            for(int j=0;j<9;j++)
                if(!isValid(s[i][j],i,j,s)) valid=false;
        if(valid)board=s;
        return valid;
    }
    public boolean set(int x, int y, int value)
    {
        if(isValid(value,x,y,board))
        {
            board[x][y]=value;
            return true;
        }
        else return false;
    }
}
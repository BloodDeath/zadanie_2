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
            board[x][y]=rand.nextInt(9)+1;
            assist_board[x][y]=true;
        }
        else i--;
    }
    for (int i=0;i<9;i++)
    {
        for(int j=0;j<9;j++)
        {
            if(assist_board[i][j]);
            else {
                int z = 1;
                if (board[i][j]!=0) z=board[i][j];
                boolean not_good = true;
                while (not_good) {
                    if (smallSquareOk(z, i, j) && lineOk(z, j) && columnOk(z, i)) {
                        not_good = false;
                        board[i][j] = z;
                    } else {
                        if (z < 9) z++;
                        else {
                            //---------POWROT
                            boolean undone=true;
                            int newi=i, newj=j;
                                while(undone)
                                {
                                    if(newj>0)
                                    {
                                        if(assist_board[newi][newj]) newj--;
                                        else
                                        {
                                            j=newj;
                                            undone=false;
                                        }
                                    }
                                    else if(assist_board[newi][newj])
                                    {
                                        newj=8;
                                        newi--;
                                    }
                                    else
                                    {
                                        i=newi;
                                        j=newj;
                                        undone=false;
                                    }
                                }

                            //--------------
                        }
                    }
                }
            }
        }
    }
}

private boolean smallSquareOk(int number,int x, int y)
{
    for (int i=0+(x%3)*3;i<3+(x%3)*3;i++)
    {
        for(int j=0+(y%3)*3;j<3+(y%3)*3;j++)
        {
            if(board[i][j]==number) return false;
        }
    }
    return true;
}
private boolean lineOk(int number, int line)
{
    for(int i=0;i<9;i++)
    {
        if(board[i][line]==number) return false;
    }
    return true;
}
private boolean columnOk(int number, int column)
{
    for(int i=0;i<9;i++)
    {
        if(board[column][i]==number) return false;
    }
    return true;
}
public int[][] get()
{
    return board;
}
}

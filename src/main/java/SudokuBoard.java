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
    //recurention(0,0,true);
    recurention(board,0,0,0,true);
    petle_rec++;
//    for (int i=0;i<9;i++)
//    {
//        for(int j=0;j<9;j++)
//        {
//            if(assist_board[i][j]);
//            else {
//                int z = 1;
//                if (board[i][j]!=0) z=board[i][j];
//                boolean not_good = true;
//                while (not_good) {
//                    if (isValid(z,i,j,board)) {
//                        not_good = false;
//                        board[i][j] = z;
//                    } else {
//                        if (z < 9) z++;
//                        else {
//                            //---------POWROT
//                            boolean undone=true;
//                            int newi=i, newj=j;
//                                while(undone)
//                                {
//                                    if(newj>0)
//                                    {
//                                        if(assist_board[newi][newj]) newj--;
//                                        else
//                                        {
//                                            j=newj;
//                                            undone=false;
//                                        }
//                                    }
//                                    else
//                                    {
//                                        if(assist_board[newi][newj])
//                                        {
//                                            newj=8;
//                                            newi--;
//                                        }
//                                        else
//                                        {
//                                            j=8;
//                                            i=newi;
//                                            undone=false;
//                                        }
//                                    }
//                                    if(assist_board[newi][newj])  //newj==0
//                                    {
//                                        newj=8;
//                                        newi--;
//                                    }
//                                    else
//                                    {
//                                        i=newi;
//                                        j=newj;
//                                        undone=false;
//                                    }
//                                }
//
//                            //--------------
//                        }
//                    }
//                }
//            }
//        }
//    }

}
private int petle_rec=0;
private void recurention(int x,int y, boolean sense)
{
    petle_rec++;
    if(sense)
    {
        if(y<8) {
            if (assist_board[x][y]) recurention(x, y + 1, true);
            else {
                if (board[x][y]!=9)
                {
                    board[x][y]++;
                    if (isValid(board[x][y],x,y,board))
                        recurention(x, y + 1, true);
                    else {
                        recurention(x, y, true);
                    }
                }
                else
                {
                    board[x][y]=0;
                    if(y>0) recurention(x,y-1,false);
                   else if(x>0)
                    {
                        recurention(x-1,8,false);
                    }
                       //else throw new RuntimeException("Powrocilo do poczatku");
                }

            }
        }
        else if (y == 8 && x < 8)
        {
            if (assist_board[x][y]) recurention(x+1, 0, true);
            else
            {
                if(board[x][y]!=9)
                {
                    board[x][y]++;
                    {
                        if (isValid(board[x][y],x,y,board))
                            recurention(x+1, 0, true);
                        else {
                            recurention(x, y, true);
                        }
                    }
                }
                else
                {
                    board[x][y]=0;
                    if(y>0)recurention(x,y-1,false);
                    else throw new RuntimeException("Powrocilo do poczatku, ale to nie moze wystapic");
                }
            }
        }
    }
    else
    {
        if(y>0) {
            if (assist_board[x][y]) recurention(x, y -1, false);
            else {
                board[x][y]++;
                {
                    if (isValid(board[x][y],x,y,board))
                        recurention(x, y + 1, true);
                    else {
                        recurention(x, y, true);
                    }
                }

            }
        }
        else if (y == 8 && x < 8)
        {
            if (assist_board[x][y]) recurention(x+1, 0, true);
            else
            {
                board[x][y]++;
                {
                    if (isValid(board[x][y],x,y,board))
                        recurention(x+1, 0, true);
                    else {
                        recurention(x, y, true);
                    }
                }
            }
        }
    }
    //----------------


}
private boolean isValid(int number,int x,int y, int[][]s)
{
if(lineOk(number,y,s) && columnOk(number,x,s) && smallSquareOk(number,x,y,s)) return true;
    else return false;
}
//private boolean recurention(int[][] s)
//{
//    petle_rec++;
//    int SIZE=9;
//
//        for (int i = 0; i < SIZE; i++) {
//            for (int j = 0; j < SIZE; j++) {
//                if (s[i][j] != 0) {
//                    continue;
//                }
//                for (int num = 1; num <= SIZE; num++) {
//                    if (isValid(num, i, j, s)) {
//                        s[i][j] = num;
//                        if (recurention(s)) {
//                            return true;
//                        } else {
//                            s[i][j] = 0;
//                        }
//                    }
//                }
//                return false;
//            }
//        }
//        board=s;
//        return true;
//
//}


//--
private boolean recurention(int[][] s,int x, int y,int lastgoodnumber, boolean was_good) {
    petle_rec++;
    boolean done=false;
    int number=lastgoodnumber+1;
   if (!assist_board[x][y]) {
        while (!done) {

            if (isValid(number, x, y, board)) {
                board[x][y]=number;
                done=forward(x,y);

            } else {
               number++;
               if(number>9)
               {
                    done=backward(x,y);
               }
            }
        }
    }
    else {
        if(was_good) {
            forward(x,y);
        }
        else {
            backward(x,y);
        }
    }
    return true;
}
private boolean forward(int x, int y)
{
    if (y < 8){
        recurention(board, x, y + 1, 0, true);
        return false;
    }
    else if (x == 8 && y == 8) return true;
    else if (y == 8 && x < 8){
        recurention(board,x+1,0,0,true);
        return false;
    }
    System.err.print("In forward, unexcpeted x,y combination");
    return true;
}
private boolean backward(int x, int y)
{
    if (y > 0) {
        recurention(board, x, y - 1, board[x][y-1], false);
        return false;
    }

    else if (x>0 && y == 0) {
        recurention(board, x-1,8,board[x-1][8],false);
        return false;
    }
    else if (y==0 && x == 0){
        System.err.print("Wrocono do poczatku");
        return true;
    }
    System.err.print("In backward, unexcpeted x,y combination");
    return true;
}
private boolean smallSquareOk(int number,int x, int y, int[][] s)
{
    for (int i=0+(x%3)*3;i<3+(x%3)*3;i++)
    {
        for(int j=0+(y%3)*3;j<3+(y%3)*3;j++)
        {
           // if(board[i][j]==number) return false;
            if(s[i][j]==number )return false;
        }
    }
    return true;
}
private boolean lineOk(int number, int line,int[][]s )
{
    for(int i=0;i<9;i++)
    {
       // if(board[i][line]==number) return false;
        if(s[i][line]==number) return false;
    }
    return true;
}
private boolean columnOk(int number, int column,int[][] s)
{
    for(int i=0;i<9;i++)
    {
       // if(board[column][i]==number) return false;
        if(s[column][i]==number) return false;
    }
    return true;
}
public int[][] get()
{
    return board;
}
}

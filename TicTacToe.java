import java.util.*;
class TicTacToe
{
    Scanner sc = new Scanner(System.in);
    private static int EMPTY = 0;
    private static int CROSS = 1;
    private static int NOUGHT = 2;
    private int ROWS = 3;
    private int COLS = 3;
    private int matrix[][] = new int[ROWS][COLS];
    private static int ctr = CROSS;
    void input()
    {
        int row,col;
        System.out.println();
        if(ctr==CROSS)
        {
            System.out.println("It is CROSS's turn!!!");
        }
        else if(ctr==NOUGHT)
        {
            System.out.println("It is NOUGHT's turn!!!");
        }
        do
        {
            System.out.println("Enter row and column number!!!");
            row = sc.nextInt();
            col = sc.nextInt();
        }while(matrix[row-1][col-1]!=EMPTY);
        if(ctr == CROSS)
        {
            matrix[row-1][col-1] = CROSS;
            ctr = 3 - CROSS;
        }
        else if(ctr == NOUGHT && matrix[row-1][col-1]==EMPTY)
        {
            matrix[row-1][col-1] = NOUGHT;
            ctr = 3 - NOUGHT;
        }      
    }
    boolean hasWon()
    {
        if(matrix[0][0] == CROSS && matrix[0][1] == CROSS && matrix[0][2] == CROSS || matrix[0][0] == NOUGHT && matrix[0][1] == NOUGHT && matrix[0][2] == NOUGHT)
        {
            return true;
        }
        else if(matrix[0][0] == CROSS && matrix[1][0] == CROSS && matrix[2][0] == CROSS || matrix[0][0] == NOUGHT && matrix[1][0] == NOUGHT && matrix[2][0] == NOUGHT)
        {
            return true;
        }
        else if(matrix[0][0] == CROSS && matrix[1][1] == CROSS && matrix[2][2] == CROSS || matrix[0][0] == NOUGHT && matrix[1][1] == NOUGHT && matrix[2][2] == NOUGHT)
        {
            return true;
        }
        else if(matrix[1][0] == CROSS && matrix[1][1] == CROSS && matrix[1][2] == CROSS || matrix[1][0] == NOUGHT && matrix[1][1] == NOUGHT && matrix[1][2] == NOUGHT)
        {
            return true;
        }
        else if(matrix[0][1] == CROSS && matrix[1][1] == CROSS && matrix[2][1] == CROSS || matrix[0][1] == NOUGHT && matrix[1][1] == NOUGHT && matrix[2][1] == NOUGHT)
        {
            return true;
        }
        else if(matrix[2][0] == CROSS && matrix[2][1] == CROSS && matrix[2][2] == CROSS || matrix[2][0] == NOUGHT && matrix[2][1] == NOUGHT && matrix[2][2] == NOUGHT)
        {
            return true;
        }
        else if(matrix[0][2] == CROSS && matrix[1][2] == CROSS && matrix[2][2] == CROSS || matrix[0][2] == NOUGHT && matrix[1][2] == NOUGHT && matrix[2][2] == NOUGHT)
        {
            return true;
        }
        else if(matrix[0][2] == CROSS && matrix[1][1] == CROSS && matrix[2][0] == CROSS || matrix[0][2] == NOUGHT && matrix[1][1] == NOUGHT && matrix[2][0] == NOUGHT)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    boolean hasDrawn()
    {
        for(int i=0;i<ROWS;i++)
        {
            for(int j=0;j<COLS;j++)
            {
                if(matrix[i][j]==EMPTY)
                {
                    return false;
                }
            }
        }
        return true;
    }
    void printMatrix()
    {
        for(int i=0;i<ROWS;i++)
        {
            for(int j=0;j<COLS;j++)
            {
                display(matrix[i][j]);
                if(j<COLS-1)
                {
                    System.out.print("|");
                }
            }
            if(i<ROWS-1)
            {
                System.out.println();
                System.out.println("-----");
            }
        }
    }
    void display(int n)
    {
        if(n==EMPTY)
        {
            System.out.print(" ");
        }
        else if(n==CROSS)
        {
            System.out.print("X");
        }
        else if(n==NOUGHT)
        {
            System.out.print("O");
        }
    }
    public static void main(String args[])
    {
        TicTacToe ob = new TicTacToe();
        ob.printMatrix();
        while(ob.hasWon() == false && ob.hasDrawn() == false)
        {
            ob.input();
            ob.printMatrix();
        }
        String str = ((3-ctr)==1?"CROSS":"NOUGHT");
        if(ob.hasWon() == true)
        {
            System.out.println();
            System.out.println("Congratulations!!!" + " " + str + " " + "has WON!!!");
        }
        else if(ob.hasDrawn() == true)
        {
            System.out.println();
            System.out.println("The game ends in a DRAW!!!");
        }
    }
}
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '_';
        }
        }
        char player = 'X';
        boolean isOver = false;
        Scanner input = new Scanner(System.in);
        while(!isOver){
            display(board,player);
            System.out.println(player + " Enter Your Move At Cordinates: ");
            int row = input.nextInt() - 1;
            int col = input.nextInt() - 1 ;
            if(board[row][col]=='_'){
            board[row][col] = player;
            isOver = hasWon(board,player);
            if(isOver){
                System.out.println(player +" has won!!!!!");
            }
            if(player=='X'){
                player = 'O';
            }
            else{
                player = 'X';
            }
        }
            else{
                System.out.println("Invalid Move!!!!");
            }
    }

}
    private static boolean hasWon(char[][] board, char player) {
        for (int row = 0; row < 3; row++) {
            if(board[row][0]==player && board[row][1]==player && board[row][2]==player){
                return true;
            }
        } for (int col = 0; col < 3; col++) {
            if(board[0][col]==player && board[1][col]==player && board[2][col]==player){
                return true;
            }
        }
        if(board[0][0] == player && board[1][1] ==player && board[2][2]==player){
            return true;
        } if(board[0][2] == player && board[1][1] ==player && board[2][0]==player){
            return true;
        }
        return false;
    }

    private static void display(char[][] board, char player) {
        for (char[] ele:board){
            for (char item : ele){
                System.out.print(item);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}


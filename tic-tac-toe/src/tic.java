import java.util.Scanner;
import java.lang.Math;
public class tic {
    public static void main(String[] args) {
        int WoL = 0;
        Scanner scan = new Scanner(System.in);
        char[][] board= {
               {'_','|','_','|','_'}, {'_','|','_','|','_'}, {'_','|','_','|','_'}
       };
       printBoard(board);
       String s = "";
        while (WoL == 0){
            moves(board);
            if(isWin(board) == 1){
                System.out.println("You win!");
                System.out.println("Would you like to play again? (yes or no)");
                s = scan.nextLine();
            } else if(isWin(board) == 2){
                System.out.println("You lose!");
                System.out.println("Would you like to play again? (yes or no)");
                s = scan.nextLine();
            } else if(isWin(board)==3){
                System.out.println("It's a tie!");
                System.out.println("Would you like to play again? (yes or no)");
                s = scan.nextLine();
            }
            WoL = isWin(board);
            if(WoL ==0) {
                compMove(board);
            }
            if(s.contains("yes")){
                board[0][0] = '_';
                board[0][2] = '_';
                board[0][4] = '_';
                board[1][0] = '_';
                board[1][2] = '_';
                board[1][4] = '_';
                board[2][0] = '_';
                board[2][2] = '_';
                board[2][4] = '_';
                WoL = 0;
                printBoard(board);
                s ="";
            }


        }
    }

    public static void printBoard(char [][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int c = 0; c < board[0].length; c++) {
                System.out.print(board[row][c]);
            }
            System.out.println();
        }
        System.out.println("------\n");

    }

    public static void moves(char [][] board){
        Scanner scan = new Scanner(System.in);
       System.out.println("Type a number between 1-9 to place your X");
       int input = 0;
       try {
           input = scan.nextInt();
       }catch (Exception e){
           System.out.println(e);
       }
       boolean valid = isValid(input, board);

       while (!valid){
           System.out.println("Please input another move 1-9, the one you entered was not valid");
           try {
               input = scan.nextInt();
           }catch (Exception e){
               System.out.println(e);
           }
           valid = isValid(input, board);
       }

       boardUpdate(input,true,board);

    }


    public static boolean isValid(int input, char[][]board){
//         [0][0] , [0][2] , [0][4]
//         [1][0] , [1][2] , [1][4]
//         [2][0] , [2][2] , [2][4]

        if(input ==1 && board[0][0] == '_'){
            return true;
        } else if(input ==2 && board[0][2] == '_'){
            return true;
        } else if(input ==3 && board[0][4] == '_'){
            return true;
        } else if(input ==4 && board[1][0] == '_'){
            return true;
        } else if(input ==5 && board[1][2] == '_'){
            return true;
        } else if(input ==6 && board[1][4] == '_'){
            return true;
        } else if(input ==7 && board[2][0] == '_'){
            return true;
        } else if(input ==8 && board[2][2] == '_'){
            return true;
        } else if(input ==9 && board[2][4] == '_'){
            return true;
        }

        return false;
    }

    public  static  void compMove(char[][] board){
        int randMove = 1 + (int)(Math.random()*9);
        boolean valid = isValid(randMove, board);

        while(!valid){
            randMove = 1 + (int)(Math.random()*9);
            valid = isValid(randMove,board);
        }

        boardUpdate(randMove,false, board);
    }

    public static void boardUpdate(int input, boolean isPlayer, char[][] board){
        char k = 'O';
        if(isPlayer){
            k = 'X';
        }
        if(input ==1  ){
            board[0][0] = k;
            printBoard(board);
        } else if(input ==2){
            board[0][2] = k;
            printBoard(board);
        } else if(input ==3){
            board[0][4] = k;
            printBoard(board);
        } else if(input ==4){
            board[1][0] = k;
            printBoard(board);
        } else if(input ==5){
            board[1][2] = k;
            printBoard(board);
        } else if(input ==6){
            board[1][4] = k;
            printBoard(board);
        } else if(input ==7){
            board[2][0] = k;
            printBoard(board);
        } else if(input ==8){
            board[2][2] = k;
            printBoard(board);
        } else if(input ==9){
            board[2][4] = k;
            printBoard(board);
        }

    }
    public static int isWin(char[][]board){
        if(board[0][0] == 'X'&& board[0][2] == 'X' && board [0][4] == 'X' ){
            return 1;
        }
        if(board[0][0] == 'O'&& board[0][2] == 'O' && board [0][4] == 'O' ){
            return 2;
        }
        if(board[1][0] == 'X'&& board[1][2] == 'X' && board [1][4] == 'X' ){
            return 1;
        }
        if(board[1][0] == 'O'&& board[1][2] == 'O' && board [1][4] == 'O' ){
            return 2;
        }
        if(board[2][0] == 'X'&& board[2][2] == 'X' && board [2][4] == 'X' ){
            return 1;
        }
        if(board[2][0] == 'O'&& board[2][2] == 'O' && board [2][4] == 'O' ) {
            return 2;
        }



        if(board[0][0] == 'X'&& board[1][0] == 'X' && board [2][0] == 'X' ){
            return 1;
        }
        if(board[0][0] == 'O'&& board[1][0] == 'O' && board [2][0] == 'O' ){
            return 2;
        }

        if(board[0][2] == 'X'&& board[1][2] == 'X' && board [2][2] == 'X' ){
            return 1;
        }
        if(board[0][2] == 'O'&& board[1][2] == 'O' && board [2][2] == 'O' ){
            return 2;
        }

        if(board[0][4] == 'X'&& board[1][4] == 'X' && board [2][4] == 'X' ){
            return 1;
        }
        if(board[0][4] == 'O'&& board[1][4] == 'O' && board [2][4] == 'O' ){
            return 2;
        }


        if(board[0][0] == 'X'&& board[1][2] == 'X' && board [2][4] == 'X' ){
            return 1;
        }
        if(board[0][0] == 'O'&& board[1][2] == 'O' && board [2][4] == 'O' ){
            return 2;
        }

        if(board[2][0] == 'X'&& board[1][2] == 'X' && board [0][4] == 'X' ){
            return 1;
        }
        if(board[2][0] == 'O'&& board[1][2] == 'O' && board [0][4] == 'O' ){
            return 2;
        }

        if(board[0][0] != '_' && board[0][2] != '_' && board[0][4] != '_' && board[1][0] !='_'&& board[1][2] != '_' && board[1][4] != '_' && board[2][0] != ' ' && board[2][2] != ' ' && board[2][4] != ' '){
            return 3;
        }


        return 0;
    }

}

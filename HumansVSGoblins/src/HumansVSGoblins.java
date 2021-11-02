import java.util.Scanner;

public class HumansVSGoblins {
    public static void main(String[] args) {
        int WoL = 0;
        Scanner scan = new Scanner(System.in);
        char[][] map = {
                {'_','_','H'},
                {'_','_','_'},
                {'G','_','_'}
        };
        System.out.println("Welcome to Human VS Goblin!");
        printMap(map);

        while (WoL==0){
            WoL = moves(map);
            WoL = compMove(map);
        }
        if(WoL ==3){
            boolean over = false;
            System.out.println("You have encountered a Goblin, let the battle begin!\nYou both begin with 100 health FIGHT!");
            Goblin gob = new Goblin(100, ((10+(int)(Math.random()*20))));
            Human hum = new Human(100, ((10+(int)(Math.random()*20))));
            while (!over){
                int cond = gob.GoblinAttack(hum);
                int cond1 = hum.HumanAttack(gob);
                if(cond ==2){
                    over =true;
                    String msg = gob.toString();
                    System.out.println(msg);
                    break;
                }else if(cond1 ==1){
                    over =true;
                    String msg = hum.toString();
                    System.out.println(msg);
                }
            }
        }

    }
    public static class Goblin{
        int health =99;
        int hit = 10+(int)(Math.random()*20);
        public Goblin(int a, int b){
            this.health=a;
            this.hit =b;

        }
        public int GoblinAttack(Human hum){
            hum.health = hum.health - this.hit;
            if(hum.health>0) {
                System.out.println("You have: " + hum.health + "HP");
                System.out.println("~~~~~~~~~~~~~~~");
            }
            if(hum.health <=0){
                return 2;
            }
            return 0;
        }
        @Override
        public String toString(){
            return "The mighty Goblin has defeated you! With a devestating attack of " + hit + "dmg!";
        }
    }
    public static class Human{
        int health;
        int hit;
        public Human(int a, int b){
            this.health =a;
            this.hit =b;

            System.out.println("~~~~~~~~~~~~~~~");
        }
        public int HumanAttack(Goblin gob){
            gob.health = gob.health - this.hit;
            if(gob.health>0) {
                System.out.println("The Goblin has: " + gob.health + "HP");
                System.out.println("~~~~~~~~~~~~~~~");

            }
            if(gob.health <=0){
                return 1;
            }
            return 0;
        }
        @Override
        public String toString(){
            return "You have defeated the Mighty Goblin, with a devestating attack of " + hit + "dmg!";
        }
    }


    public static void printMap(char [][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int c = 0; c < board[0].length; c++) {
                System.out.print(board[row][c]);
            }
            System.out.println();
        }
        System.out.println("~~~~\n");

    }

    public static int moves(char [][] board){
        Scanner scan = new Scanner(System.in);
        System.out.println("Type a N/E/S/W to move the human");
        String input = "";
        try {
            input = scan.nextLine();
        }catch (Exception e){
            System.out.println(e);
        }
        int valid = isValid(input, true, board);
        while (valid ==0){
            System.out.println("Please input a different direction");
            try {
                input = scan.nextLine();
            }catch (Exception e){
                System.out.println(e);
            }
            valid = isValid(input, true,board);
        }
        if(valid == 3){
            return 3;
        }
        int ret = getPos(input, true,board);
        int prev = ret;
        if (input.equals("N")){
            ret = ret -3;
        }
        if(input.equals("E")){
            ret = ret+1;
        }
        if(input.equals("S")){
            ret = ret +3;
        }
        if(input.equals("W")){
            ret = ret-1;
        }
        mapUpdate(ret, prev,true,board);
        return 0;
    }
    public static void mapUpdate(int input, int prev, boolean isPlayer, char[][] board){
        char k = 'G';
        if(isPlayer){
            k = 'H';
            System.out.println("Human move!\n~~~~~~");
        }else{
            System.out.println("Goblin move!\n~~~~~~");
        }
        if(input ==1  ){
            board[0][0] = k;

        } else if(input ==2){
            board[0][1] = k;

        } else if(input ==3){
            board[0][2] = k;

        } else if(input ==4){
            board[1][0] = k;

        } else if(input ==5){
            board[1][1] = k;

        } else if(input ==6){
            board[1][2] = k;

        } else if(input ==7){
            board[2][0] = k;

        } else if(input ==8){
            board[2][1] = k;

        } else if(input ==9){
            board[2][2] = k;

        }

        if(prev ==1  ){
            board[0][0] = '_';
            printMap(board);
        } else if(prev ==2){
            board[0][1] = '_';
            printMap(board);
        } else if(prev ==3){
            board[0][2] = '_';
            printMap(board);
        } else if(prev ==4){
            board[1][0] = '_';
            printMap(board);
        } else if(prev ==5){
            board[1][1] = '_';
            printMap(board);
        } else if(prev ==6){
            board[1][2] = '_';
            printMap(board);
        } else if(prev ==7){
            board[2][0] = '_';
            printMap(board);
        } else if(prev ==8){
            board[2][1] = '_';
            printMap(board);
        } else if(prev ==9){
            board[2][2] = '_';
            printMap(board);
        }

    }

    public static int isValid(String input, boolean k, char[][]board){
//         [0][0] , [0][1] , [0][2]
//         [1][0] , [1][1] , [1][2]
//         [2][0] , [2][1] , [2][2]

            int ret = getPos(input,k,board);

            if (input.equals("N")){
                ret = ret -3;
            }
            if(input.equals("E")){
                ret = ret+1;
            }
            if(input.equals("S")){
                ret = ret +3;
            }
            if(input.equals("W")){
                ret = ret-1;
            }

            if(ret == 0){
                return 0;
            } else if(ret ==1 && board[0][0] == '_'){
                return 1;
            } else if(ret ==2 && board[0][1] == '_'){
                return 1;
            } else if(ret ==3 && board[0][2] == '_'){
                return 1;
            } else if(ret ==4 && board[1][0] == '_'){
                return 1;
            } else if(ret ==5 && board[1][1] == '_'){
                return 1;
            } else if(ret ==6 && board[1][2] == '_'){
                return 1;
            } else if(ret ==7 && board[2][0] == '_'){
                return 1;
            } else if(ret ==8 && board[2][1] == '_'){
                return 1;
            } else if(ret ==9 && board[2][2] == '_'){
                return 1;
            }
            if(k) {
                if (ret == 1 && board[0][0] == 'G') {
                    return 3;
                } else if (ret == 2 && board[0][1] == 'G') {
                    return 3;
                } else if (ret == 3 && board[0][2] == 'G') {
                    return 3;
                } else if (ret == 4 && board[1][0] == 'G') {
                    return 3;
                } else if (ret == 5 && board[1][1] == 'G') {
                    return 3;
                } else if (ret == 6 && board[1][2] == 'G') {
                    return 3;
                } else if (ret == 7 && board[2][0] == 'G') {
                    return 3;
                } else if (ret == 8 && board[2][1] == 'G') {
                    return 3;
                } else if (ret == 9 && board[2][2] == 'G') {
                    return 3;
                }
            } else{
                if (ret == 1 && board[0][0] == 'H') {
                    return 3;
                } else if (ret == 2 && board[0][1] == 'H') {
                    return 3;
                } else if (ret == 3 && board[0][2] == 'H') {
                    return 3;
                } else if (ret == 4 && board[1][0] == 'H') {
                    return 3;
                } else if (ret == 5 && board[1][1] == 'H') {
                    return 3;
                } else if (ret == 6 && board[1][2] == 'H') {
                    return 3;
                } else if (ret == 7 && board[2][0] == 'H') {
                    return 3;
                } else if (ret == 8 && board[2][1] == 'H') {
                    return 3;
                } else if (ret == 9 && board[2][2] == 'H') {
                    return 3;
                }
            }

        return 0;
    }

    public  static  int getPos(String input, Boolean k, char[][]board){
        int r = -1;
        int c =-1;
        if(k) {
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[0].length; col++) {
                    if (board[row][col] == 'H') {
                        r = row;
                        c = col;
                    }
                }
            }
        }else {
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[0].length; col++) {
                    if (board[row][col] == 'G') {
                        r = row;
                        c = col;
                    }
                }
            }
        }
        if(r == 0 && c == 0){
            return 1;
        }
        if(r == 0 && c == 1){
            return 2;
        }
        if(r == 0 && c == 2){
            return 3;
        }
        if(r == 1 && c == 0){
            return 4;
        }
        if(r == 1 && c == 1){
            return 5;
        }
        if(r == 1 && c == 2){
            return 6;
        }
        if(r == 2 && c == 0){
            return 7;
        }
        if(r == 2 && c == 1){
            return 8;
        }
        if(r == 2 && c == 2){
            return 9;
        }


        return 0;
    }

    public static int compMove(char[][] board){
        String[] k = {"N","S","E","W"};
        int randNum = 1+ (int)(Math.random()+2);
        String input = k[randNum];
        int valid = isValid(input, false, board);
        while (valid ==0){

            input = k[randNum];
            valid = isValid(input, false,board);
        }
        if(valid == 3){
            return 3;
        }
        int ret = getPos(input, false,board);
        int prev = ret;
        if (input.equals("N")){
            ret = ret -3;
        }
        if(input.equals("E")){
            ret = ret+1;
        }
        if(input.equals("S")){
            ret = ret +3;
        }
        if(input.equals("W")){
            ret = ret-1;
        }

        mapUpdate(ret, prev,false,board);

        return 0;
    }


}

public class Display {

    public Display(){

    }


    public void printMess(String m){
        System.out.println(m);
    }



    public void printBoard(Board board){
        System.out.print("   ");
        for(int i =0; i< board.getSizeX();i++){
            if(i<10){
                System.out.print(i+ "  ");
            } else{
                System.out.print(" ");
            }
        }
        System.out.println(" ");
        for(int r =0; r < board.getSizeX(); r++ ){
            if(r<10){
                System.out.print(r + " ");
            }else{
                System.out.print(" ");
            }
            for(int c = 0; c< board.getSizeY(); c++){
                switch (board.getPlot(r, c).getChar()) {
                    case '~' -> System.out.print(" ~" + " ");
                    case 'H' -> System.out.print(" X" + " ");
                    case 'S' -> System.out.print(" S" + " ");
                    case 'M' -> System.out.print(" M" + " ");
                    case 'E' -> System.out.println("_");
                }
            }
            System.out.println(" ");
        }
        System.out.println("-------------------------------------");
    }

}

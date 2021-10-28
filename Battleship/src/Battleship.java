public class Battleship {
    private final Display display;
    private final Game game = new Game();

    public Battleship(){
        display = new Display();
    }

    public void start(){

        mainMenu();
    }

    public void  mainMenu(){
        int choice;
        boolean e = false;
        Input input = new Input();
        while (!e){
            System.out.println("Please press 1 to begin the game");
            choice = input.getMenuOpt();
            if(choice == 1){
                display.printMess("Let the game begin!");
                game.gameLogic();
                break;
            }
        }
    }

    public static void main(String[] args){
        Battleship battleship = new Battleship();
        battleship.start();
    }

}

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<Ship> shipsPlayer = new ArrayList<>();
    private final List<Ship> shipsPlayer2 = new ArrayList<>();
    List<Board> boards;

    public void gameLogic(){
        Input board1 = new Input();
        boards = board1.getBoards();
        Board boardP1 = boards.get(0);
        Board boardP2 = boards.get(1);
        for(int i = 0; i<2; i++){
            Ship one = board1.createShip(0);
            while(!one.isValid(one, shipsPlayer, boardP1)){
                one = board1.createShip(0);
            }
            shipsPlayer.add(one);
        }
        //player 2
        for(int i = 0; i<2; i++){
            Ship two = board1.createShip(1);
            while(!two.isValid(two, shipsPlayer2, boardP2)){
                two = board1.createShip(1);
            }
            shipsPlayer2.add(two);
        }
        Player player1 = new Player(shipsPlayer, boardP2);
        Player player2 = new Player(shipsPlayer2,boardP1);

        boolean gameOn = true;
        Display display = new Display();
        System.out.println("Player 1 Board");
        display.printBoard(boardP1);

        System.out.println("Player 2 Board");
        display.printBoard(boardP2);
        int numShipsP1 = player1.numberOfPlotShips(shipsPlayer);
        int numShipsP2 = player2.numberOfPlotShips(shipsPlayer2);

        while (gameOn){
            int[] shotCoords;
            shotCoords = board1.shoot(0);
            if(player2.handleShot(shotCoords[0],shotCoords[1],0)){
                display.printBoard(player1.getBoard());
                numShipsP2--;
                if(numShipsP2 == 0){
                    display.printBoard(player2.getBoard());
                    System.out.println("Player 1 wins!");
                    break;
                }
            }else{
                display.printBoard(player2.getBoard());
            }
            if(numShipsP2 == 0){
                display.printBoard(player2.getBoard());
                System.out.println("Player 1 wins!");
                break;
            }
            //player 2
            shotCoords = board1.shoot(1);
            if(player1.handleShot(shotCoords[0],shotCoords[1], 1)){
                display.printBoard(player1.getBoard());
                numShipsP1--;
            }else{
                display.printBoard(player1.getBoard());
            }
            if(numShipsP1 == 0){
                display.printBoard(player1.getBoard());
                System.out.println("Player 2 wins!");
                break;
            }

        }
    }

}

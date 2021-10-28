import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {

    private final Scanner scan = new Scanner(System.in);
    private final List<Board> boards = new ArrayList<>();

    int choice;
    List<Integer> coordShip = new ArrayList<>();

    public List<Board>getBoards(){
        generateBoard();
        return boards;
    }

    public void generateBoard(){
        System.out.println("Select your board height: ");
        int x = scan.nextInt();
        System.out.println("Select your board width: ");
        int y = scan.nextInt();
        Board newBoard = new Board(x,y);
        Board newBoard1 = new Board(x,y);
        boards.add(newBoard);
        boards.add(newBoard1);

    }


    public int getMenuOpt(){
        choice = scan.nextInt();
        scan.nextLine();
        return choice;
    }

    private List<Integer> inputCoordsShipType(){
        this.coordShip = new ArrayList<>();
        System.out.println("Select the row for your ship: ");
        int row = scan.nextInt();
        System.out.println("Select the column for your ship: ");
        int col = scan.nextInt();
        System.out.println("Select your ship: \n1. DESTROYER\n2. SUBMARINE\n3. BATTLESHIP");
        int shipType = scan.nextInt();
        if (shipType > 3){
            System.out.println("Please input a correct ship type.");
            inputCoordsShipType();
        }
        coordShip.add(row);
        coordShip.add(col);
        coordShip.add(shipType);
        return coordShip;
    }

    public Ship createShip(int player){
        int gPlayer = player+1;
        Plot shipPart;
        Ship ship;
        System.out.println("Player "+ gPlayer + " please place your ship");
        coordShip = inputCoordsShipType();
        int row = coordShip.get(0);
        int col = coordShip.get(1);
        int shipType = coordShip.get(2);
        shipPart = new Plot(row,col,PlotStatus.SHIP);
        ship = new Ship(new ArrayList<>(), ShipType.values()[shipType-1]);
        boards.get(player).buildShip(shipPart,ship);
        return ship;
    }

    public int[] shoot(int player){
        int gamePlayer = player+1;
        System.out.println("Player "+ gamePlayer + " Choose where to fire");
        System.out.println("Row: ");
        int row = scan.nextInt();
        System.out.println("Column: ");
        int col = scan.nextInt();

        return new int[]{row,col};
    }

}

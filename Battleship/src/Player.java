import java.util.List;

public class Player {

    private final List<Ship> ships;
    private final Board board;
//    private final int remainingShips = 0;

    public Player(List<Ship> ships, Board board) {
        this.ships = ships;
        this.board = board;
    }

    public Board getBoard() {
        return board;
    }

    public int numberOfPlotShips(List<Ship> ships){
        int sumAll = 0;
        for(Ship ship: ships){
                sumAll = sumAll + ship.getShipType().label;
        }
        return sumAll;
    }

    public boolean handleShot(int x, int y, int player){
        for(Ship ship: ships){
            for(Plot plot: ship.getFields()){
                if(plot.getX() == x && plot.getY() == y && plot.getPlotStatus().equals(PlotStatus.SHIP)){
                    plot.setPlotStatus(PlotStatus.HIT);
                    board.getPlot(x,y).setPlotStatus(PlotStatus.HIT);
                    System.out.println("HIT!");
                    return true;
                }else if(plot.getX() ==x && plot.getY() == y && plot.getPlotStatus().equals(PlotStatus.HIT)){
                    plot.setPlotStatus(PlotStatus.HIT);
                    board.getPlot(x,y).setPlotStatus(PlotStatus.HIT);
                    System.out.println("Already hit that spot");
                    return false;
                }
            }
        }
        board.getPlot(x,y).setPlotStatus(PlotStatus.MISSED);
        System.out.println("You missed Player " + (player+1) +"!");
        return false;
    }

}

public class Board {
    private final int sizeX;
    private final int sizeY;
    Plot[][] matrix;

    public Board(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        fillBoard(sizeX,sizeY);
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public Plot getPlot(int x, int y){
        return matrix[x][y];
    }

    public void fillBoard(int x, int y){
        matrix = new Plot[sizeX][sizeY];
        for(int r = 0; r <x; r++){
            for (int c =0; c<y; c++){
                matrix[r][c] = new Plot(r,c,PlotStatus.WATER);
            }
        }
    }

    public void buildShip(Plot plot, Ship ship){
        switch (ship.getShipType().label){
            case 1:
                plot.setPlotStatus(PlotStatus.SHIP);
                ship.add(plot);
                break;
            case 2:
                plot.setPlotStatus(PlotStatus.SHIP);
                ship.add(plot);
                int x = plot.getX();
                int y = plot.getY();
                ship.add(new Plot(x, y+1, PlotStatus.SHIP));
                break;
            case 3:
                plot.setPlotStatus(PlotStatus.SHIP);
                ship.add(plot);
                 x = plot.getX();
                 y = plot.getY();
                ship.add(new Plot(x, y+1, PlotStatus.SHIP));
                ship.add(new Plot(x, y+2, PlotStatus.SHIP));
        }
    }

//    DESTROYER(1),
//    SUBMARINE(2),
//    BATTLESHIP(3);
}

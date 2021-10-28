public class Plot {
    private final int x;
    private final int y;
    private PlotStatus plotStatus;

    public  Plot(int x, int y, PlotStatus plotStatus){
        this.x =x;
        this.y = y;
        this.plotStatus = plotStatus;
    }

    public void setPlotStatus(PlotStatus plotStatus){
        this.plotStatus = plotStatus;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public PlotStatus getPlotStatus() {
        return plotStatus;
    }

    public  char getChar(){
        char res = ' ';
        switch (plotStatus){
            case EMPTY -> res = 'E';
            case HIT -> res = 'H';
            case SHIP -> res = 'S';
            case WATER -> res = '~';
            case MISSED -> res = 'M';
        }
        return res;
    }

}



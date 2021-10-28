import java.util.List;

public class Ship {

    private final List<Plot> NewShip;
    private final ShipType shipType;


    public Ship(List<Plot> newShip, ShipType shipType) {
        this.shipType = shipType;
        NewShip = newShip;
    }

    public List<Plot> getFields() {
        return NewShip;
    }

    public ShipType getShipType() {
        return shipType;
    }

    public void add(Plot plot){
        NewShip.add(plot);
    }

    public boolean isValid(Ship ship, List<Ship> ships, Board board){
        int count = 0;
        for(int i =0; i < ship.getFields().size(); i++) {
            if (ship.getFields().get(i).getY() > board.getSizeY() || ship.getFields().get(i).getX() > board.getSizeX()) {
                count++;
            }

            for (Ship value : ships) {
                for (int j = 0; j < value.getFields().size(); j++) {
                    if (ship.getFields().get(i).getX() == value.getFields().get(j).getX() &&
                            ship.getFields().get(i).getY() == value.getFields().get(j).getY()) {
                        count++;
                    }
                }
            }
        }
        if(count ==0){
            return true;
        }
        return false;
    }

}

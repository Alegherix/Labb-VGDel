import java.awt.*;

public class Semitruck extends TransportationVehicle {


    public Semitruck() {
        this(10);
    }

    public Semitruck(int cargoLimit) {
        this(cargoLimit, 70);
    }

    public Semitruck(int cargoLimit, double angleLimitOfCargo) {
        super(cargoLimit, angleLimitOfCargo, new Body(Color.RED, 2), new Engine(400),
                Direction.SOUTH, new Position(), "SemiTruck v2", Type.TRUCK);
    }


    public ITransportable unload() {
        return super.unload(getTransported().getLast(), decideCargoPositionWhenUnloading());
    }

    /**
     * Used to decide what position the cargo should have when unloading
     * @return Position that is at the back of the SemiTruck
     */
    private Position decideCargoPositionWhenUnloading(){
        double xPosition = 0;
        double yPos = 0;

        switch (getDirection()){
            case NORTH:
                xPosition = getPosition().getY() - 1;
                yPos = getPosition().getY();
                break;
            case SOUTH:
                xPosition = getPosition().getY() + 1;
                yPos = getPosition().getY();
                break;
            case EAST:
                yPos = getPosition().getX() - 1;
                xPosition = getPosition().getX();
                break;
            case WEST:
                yPos = getPosition().getX() + 1;
                xPosition = getPosition().getX();
                break;
        }
        return new Position(xPosition, yPos);
    }

}

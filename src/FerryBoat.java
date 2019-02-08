import java.awt.*;
import java.util.Deque;

public class FerryBoat implements ITransporter{

    private Vehicle.Type type;
    private Direction direction;
    private Engine engine;
    private Body body;
    private String modelname;
    private Position position;
    private CarCargo cargo;
    Transporter<ITransportable> transporter;

    public FerryBoat() {
    }



    public Vehicle unloadCargo(){
        if(cargo.stateIsDown()){
            Vehicle vehicle = cargo.getCars().removeFirst();
            vehicle.setPosition(decideCargoPositionWhenUnloading());
            return vehicle;
        }
        else{
            throw new IllegalStateException("You need to lower the cargo before trying to unload!");
        }
    }

    private Position decideCargoPositionWhenUnloading(){
        double xPosition = 0;
        double yPos = 0;

        switch (transporter.getDirection()){
            case NORTH:
                xPosition = transporter.getTransporterPosition().getY() + 1;
                yPos = transporter.getTransporterPosition().getY();
                break;
            case SOUTH:
                xPosition = transporter.getTransporterPosition().getY() - 1;
                yPos = transporter.getTransporterPosition().getY();
                break;
            case EAST:
                yPos = transporter.getTransporterPosition().getY() + 1;
                xPosition = transporter.getTransporterPosition().getY();
                break;
            case WEST:
                yPos = transporter.getTransporterPosition().getY() - 1;
                xPosition = transporter.getTransporterPosition().getY();
                break;
        }
        return new Position(xPosition, yPos);
    }

    @Override
    public boolean canBeLoaded() {
        return false;
    }

    @Override
    public boolean unLoadable() {
        return false;
    }

    @Override
    public void unLoad() {

    }

    @Override
    public void load() {

    }

    @Override
    public boolean isMoving() {
        return false;
    }

    @Override
    public Position getTransporterPosition() {
        return null;
    }

    @Override
    public Deque<ITransportable> getTransportables() {
        return null;
    }

    @Override
    public Direction getDirection() {
        return null;
    }
}

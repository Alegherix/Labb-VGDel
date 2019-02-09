import java.awt.*;

public class Scania extends Transporter{

    private Vehicle.Type type;
    private Direction direction;
    private Engine engine;
    private Body body;
    private String modelname;
    private Position position;
    private RegularCargo cargo;


    public Scania() {
        this(Color.red);
    }


    public Scania(Color color){
        body = new Body(color, 2);
        engine = new Engine(250);
        type = Vehicle.Type.TRUCK;
        direction = Direction.SOUTH;
        modelname = "Scania";
        position = ITransportable.position;
    }


    public RegularCargo getCargo() {
        return cargo;
    }


    public void raiseCargo(double amount){
        if(!isMoving()){
            cargo.raise(amount);
        }
        else{
            throw new IllegalStateException("You need to stop moving before raising the cargo");
        }
    }

    public void lowerCargo(double amount){
        if(!isMoving()){
            cargo.lower(amount);
        }
        else{
            throw new IllegalStateException("You need to stop moving before lowering the cargo");
        }
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
    public Direction getDirection() {
        return null;
    }
}

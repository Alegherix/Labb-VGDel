import java.awt.*;

public class Scania extends Vehicle{
    private Vehicle.Type type;
    private Direction direction;
    private Engine engine;
    private Body body;
    private String modelname;
    private Position position;
    private Cargo cargo;



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
        cargo = new Cargo();
    }



    public double getCargoAngle(){
        return cargo.getAngle().getAmount();
    }


    public void lowerCargo(double amount){
        if(!isMoving()){
            cargo.manuallyLower(amount);
        }
        else{
            throw new IllegalStateException("You need to stop moving before trying to manage the cargo");
        }
    }

    public void manuallyRaise(double amount){
        if(!isMoving()){
            cargo.manuallyRaise(amount);
        }
        else{
            throw new IllegalStateException("You need to stop moving before trying to manage the cargo");
        }
    }

    @Override
    public void move() {
        if(!cargo.getAngle().getState().equals(Angle.STATE.DOWN)){
            throw new IllegalStateException("You need to raise the cargo before trying to drive away");
        }
        super.move();
    }
}

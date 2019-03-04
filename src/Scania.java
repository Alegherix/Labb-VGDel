import java.awt.*;

public class Scania extends Vehicle{

    private Cargo cargo;

    public Scania() {
        this(Color.red);
    }

    public Scania(Position position){
        this(Color.black, 70, position);
    }

    public Scania(Color color){
       this(color, 70, new Position(0,0));
    }

    public Scania(Color color, double angleCap, Position position){
        super(new Body(color, 2), new Engine(250), position, Direction.SOUTH, "Scania", Type.TRUCK);
        cargo = new Cargo(angleCap);
    }

    /**
     * Returns the maximum degree of which the cargo can be turned for this Object
     * @return
     */
    public double getMaximumAngleCap(){
        return cargo.getAngleCap();
    }


    public double getCargoAngle(){
        return cargo.getAngle().getAmount();
    }

    public void raiseCargo(){
        if(!isMoving()){
            cargo.raise();
        }
    }

    public void lowerCargo(){
        if(!isMoving()){
            cargo.lower();
        }
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

    /**
     * Moves the Scania if the cargo isn't down
     */
    @Override
    public void move() {
        if(!cargo.getAngle().getState().equals(Angle.STATE.UP)){
            throw new IllegalStateException("You need to raise the cargo before trying to drive away");
        }
        super.move();
    }
}

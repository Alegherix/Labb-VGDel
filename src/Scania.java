import java.awt.*;

public class Scania extends Vehicle{

    private Cargo cargo;

    public Scania() {
        this(Color.red);
    }

    public Scania(Color color){
       this(color, 70);
    }

    public Scania(Color color, double angleCap){
        super(new Body(color, 2), new Engine(250), new Position(), Direction.SOUTH, "Scania", Type.TRUCK);
        cargo = new Cargo(angleCap);
    }

    public double getMaximumAngleCap(){
        return cargo.getAngleCap();
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

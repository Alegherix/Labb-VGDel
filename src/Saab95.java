import java.awt.*;

public class Saab95 extends Vehicle implements ITransportable{

    private boolean turboOn;
    //private final Vehicle saab95;

    public Saab95(){
        this(Color.black);
    }


    public Saab95(Color color){
        super(new Body(color, 2),
                new Engine(125),
                new Position(),
                Direction.SOUTH,
                "Saab95",
                Type.CAR);
        turboOn = false;
        getEngine().stopEngine();
    }

    /**
     * Sets the turbo of the car to on
     */
    public void enableTurbo(){
	    turboOn = true;
    }

    /**
     * Sets the turbo of the car off.
     */
    public void disableTurbo(){
	    turboOn = false;
    }


    /**
     * Returns the speed factor of the Saab95
     * @return the speed factor
     */
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        //return saab95.getEngine().enginePower * 0.01 * turbo;
        return getEngine().getEnginePower()* 0.01 * turbo;
    }

    public boolean turboOn() {
        return turboOn;
    }
}

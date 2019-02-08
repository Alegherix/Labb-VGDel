import java.awt.*;

public class Saab95 implements ITransportable{

    private boolean turboOn;
    private Vehicle.Type type;
    private Direction direction;
    private Engine engine;
    private Body body;
    private String modelname;
    private Position position;

    public Saab95(){
        this(Color.black);
    }

    public Saab95(Color color){
        body = new Body(color, 2);
        engine = new Engine(125);
        type = Vehicle.Type.CAR;
        direction = Direction.SOUTH;
        modelname = "Saab95";
        position = ITransportable.position;
    }

    /**
     * Sets the turbo of the car to on
     */
    public void setTurboOn(){
	    turboOn = true;
    }

    /**
     * Sets the turbo of the car off.
     */
    public void setTurboOff(){
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
        return engine.enginePower * 0.01 * turbo;
    }
}

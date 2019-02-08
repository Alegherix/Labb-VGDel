import java.awt.*;

public class Volvo240 extends Vehicle {

    public static final double trimFactor = 1.25;


    public Volvo240(){
        this(Color.black);
    }

    public Volvo240(Color color){
        super(new Body(color, 4),
                new Engine(100),
                new Position(),
                Direction.SOUTH,
                "Volvo240",
                Type.CAR);
        getEngine().stopEngine();
    }


    /**
     * Returns the speed factor of the Volvo240
     * @return the speed factor
     */
    @Override
    public double speedFactor(){
        return getEngine().getEnginePower() * 0.01 * trimFactor;
    }

}

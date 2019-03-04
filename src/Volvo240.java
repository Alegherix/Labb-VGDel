import java.awt.*;

public class Volvo240 extends Vehicle implements ITransportable{

    public static final double trimFactor = 1.25;

    public Volvo240(){
        this(Color.black, new Position());
    }

    public Volvo240(Position position){
        this(Color.black, position);
    }

    public Volvo240(Color color, Position position){
        super(new Body(color, 4),
                new Engine(100),
                position,
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

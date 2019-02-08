import java.awt.*;

public final class VehicleBuilder{

    private Body body;
    private Engine engine;
    private Position position;
    private Direction direction;
    private String modelName;
    private Vehicle.Type type;


    public VehicleBuilder constructBody(Color color, int doors){
        body = new Body(color, doors);
        return this;
    }

    public VehicleBuilder createEngine(int power){
        engine = new Engine(power);
        return this;
    }

    public VehicleBuilder vehicleType(Vehicle.Type type){
        this.type = type;
        return this;
    }

    public VehicleBuilder setModelName(String modelName) {
        this.modelName = modelName;
        return this;
    }

    public VehicleBuilder setPosition(Position position) {
        this.position = position;
        return this;
    }

    public VehicleBuilder setDirection(Direction direction) {
        this.direction = direction;
        return this;
    }

    /*
    public Vehicle buildVehicle(){
        return new Vehicle(body, engine, position, direction, modelName, type);
    }
    */

}
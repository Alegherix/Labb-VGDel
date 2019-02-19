import java.awt.*;

public abstract class Vehicle implements Movable {

    private Body body;
    private Engine engine;
    private Position position;
    private Direction direction;
    private String modelName;
    private Type type;

    enum Type{
        CAR, TRUCK, FERRY
    }


    public Vehicle(){
        this(new Body(Color.black,4), new Engine(100), new Position(), Direction.SOUTH, "", Type.CAR);
    }


    public Vehicle(Body body, Engine engine, Position position, Direction direction, String modelName, Type type) {
        this.body = body;
        this.engine = engine;
        this.position = position;
        this.direction = direction;
        this.modelName = modelName;
        this.type = type;
    }

    public Body getBody() {
        return body;
    }

    public Engine getEngine() {
        return engine;
    }

    public Type getType() {
        return type;
    }

    /**
     * Returns the direction of the Car
     * @return the direction
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * Returns the Position of the car
     * @return the position
     */
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    protected void incrementSpeed(double amount){
        engine.setCurrentSpeed(Math.min(engine.getCurrentSpeed() + speedFactor() * amount, engine. getEnginePower()));
    }

    /**
     * Decrease the speed with a given amount
     * @param amount to decrease speed by
     */

    private void decrementSpeed(double amount){
        engine.setCurrentSpeed(Math.max(engine.getCurrentSpeed() - speedFactor() * amount, 0));
    }

    public double speedFactor() {
        return getEngine().getEnginePower() * 0.01 * 1;
    }

    private boolean acceptedValueRange(double amount){
        if(amount <= 1.0 && amount >= 0.0){
            return true;
        }
        else{
            throw new IllegalArgumentException("Number must be in range of [0,1]");
        }
    }


    /**
     * Increase the speed of the car by given argument, if argument is in allowed range
     * @param amount to increase the speed by
     */
    public void gas(double amount){
        if(acceptedValueRange(amount)){
            incrementSpeed(Math.abs(amount));
        }
    }

    /**
     * Lowers the cars speed by given argument, if argument is in allowed range
     * @param amount to lower the speed by
     */
    public void brake(double amount){
        if(acceptedValueRange(amount)){
            decrementSpeed(Math.abs(amount));
        }
    }

    public boolean isMoving(){
        return getEngine().getCurrentSpeed()>0;
    }

    /**
     * Move the Vehicle based on it's current speed
     */
    @Override
    public void move() {
        switch (direction){
            case SOUTH:
                position.setY(position.getY() + engine.getCurrentSpeed());
                break;
            case NORTH:
                position.setY(position.getY() - engine.getCurrentSpeed());
                break;
            case WEST:
                position.setX(position.getX() - engine.getCurrentSpeed());
                break;
            case EAST:
                position.setX(position.getX() + engine.getCurrentSpeed());
        }
    }

    /**
     * Turns the car in an 90° angle towards the lefthand side
     */
    @Override
    public void turnLeft() {
        switch (direction){
            case EAST:
                direction = Direction.NORTH;
                break;
            case NORTH:
                direction = Direction.WEST;
                break;
            case WEST:
                direction = Direction.SOUTH;
                break;
            case SOUTH:
                direction = Direction.EAST;
        }
    }

    /**
     * Turns the car in an 90° angle towards the righthand side
     */
    @Override
    public void turnRight() {
        switch (direction){
            case EAST:
                direction = Direction.SOUTH;
                break;
            case SOUTH:
                direction = Direction.WEST;
                break;
            case WEST:
                direction = Direction.NORTH;
                break;
            case NORTH:
                direction = Direction.EAST;
        }
    }


    public void switchDirection() {
        switch (direction){
            case EAST:
                direction = Direction.WEST;
                break;
            case SOUTH:
                direction = Direction.NORTH;
                break;
            case WEST:
                direction = Direction.EAST;
                break;
            case NORTH:
                direction = Direction.SOUTH;
        }
    }
}

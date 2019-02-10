import java.awt.*;

public class SemiTruck extends Vehicle{


    private CarCargo cargo;

    public SemiTruck(){
        this(Color.red);
    }


    public SemiTruck(Color color){
        super(new Body(color, 2),
                new Engine(450),
                new Position(),
                Direction.SOUTH,
                "Volvo",
                Type.TRUCK
        );
        cargo = new CarCargo();
        getEngine().stopEngine();
    }

    private boolean canLoadCargo(Vehicle vehicle){
        return withinValidLoadingRange(vehicle) &&
                cargo.loadable(vehicle);
    }

    public CarCargo getCargo() {
        return cargo;
    }

    // Kan behöva fixas
    private boolean withinValidLoadingRange(Vehicle vehicle){
        if(Math.abs(vehicle.getPosition().getX() - getPosition().getX())<=2 &&
            Math.abs(vehicle.getPosition().getY() - getPosition().getY())<=2){
            return true;
        }
        else{
            throw new IllegalArgumentException("The car your trying to load is without of range for loading");
        }
    }

    /**
     * Unloads the car from the cargo and updates it's position accordingly
     * @return Car that is unloaded
     */
    public Vehicle unloadCargo(){
        if(cargo.stateIsDown()){
            Vehicle vehicle = cargo.getCars().removeLast();
            vehicle.setPosition(decideCargoPositionWhenUnloading());
            return vehicle;
        }
        else{
            throw new IllegalStateException("You need to lower the cargo before trying to unload!");
        }
    }

    public void loadCargo(Vehicle vehicle){
        if(canLoadCargo(vehicle)){
            cargo.getCars().addLast(vehicle);
        }
    }


    public void raiseCargo(){
        cargo.raise();
    }

    /**
     * Drives the SemiTruck and updates the position of the cargo to that of the truck
     */
    @Override
    public void move() {
        if(cargo.stateIsDown()){
            throw new IllegalStateException("You need to raise the cargo before driving");
        }
        else{
            super.move();
            cargo.updateCargoPosition(getPosition());
        }
    }

    /**
     * Used to decide what position the cargo should have when unloading
     * @return Position of cargo
     */
    private Position decideCargoPositionWhenUnloading(){
        double xPosition = 0;
        double yPos = 0;

        switch (getDirection()){
            case NORTH:
                xPosition = getPosition().getY() - 1;
                yPos = getPosition().getY();
                break;
            case SOUTH:
                xPosition = getPosition().getY() + 1;
                yPos = getPosition().getY();
                break;
            case EAST:
                yPos = getPosition().getX() - 1;
                xPosition = getPosition().getX();
                break;
            case WEST:
                yPos = getPosition().getX() + 1;
                xPosition = getPosition().getX();
                break;
        }
        return new Position(xPosition, yPos);
    }
}

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


public class CarCargo implements ICargo{

    enum CargoState{
        UP, DOWN
    }

    public final int LIMIT = 10;
    private Deque<Vehicle> cars;
    private CargoState cargoState;

    public CarCargo() {
        cars = new LinkedList<>();
        cargoState = CargoState.UP;
    }

    public void updateCargoPosition(Position position){
        for(Vehicle car : cars){
            car.setPosition(position);
        }
    }

    public boolean loadable(Vehicle vehicle){
        return withinRange() && loadingProperly(vehicle) && shouldBeDown()  ;
    }


    public boolean withinRange(){
        if(cars.size() < LIMIT){
            return true;
        }
        else{
            throw new IllegalStateException("The cargo is already fully stacked");
        }
    }

    public boolean loadingProperly(Vehicle vehicle){
        if(vehicle.getType().equals(Vehicle.Type.CAR)){
            return true;
        }
        else{
            throw new IllegalArgumentException("You can only load cars onto this Cargo");
        }
    }

    public boolean shouldBeDown(){
        if(!stateIsDown()){
            throw new IllegalStateException("You need to lower the cargo before trying to load");
        }
        else{
            return true;
        }
    }

    public boolean stateIsDown(){
        return cargoState.equals(CargoState.DOWN);
    }

    public Deque<Vehicle> getCars() {
        return cars;
    }

    @Override
    public void lower() {
        cargoState = CargoState.DOWN;
    }

    @Override
    public void raise() {
        cargoState = CargoState.UP;
    }

}

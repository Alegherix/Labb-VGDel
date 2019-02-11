import java.util.ArrayList;
import java.util.List;

public class BodyShop <T extends Vehicle> {

    private T t;
    private int limit;
    private List<T> vehicles;

    public BodyShop() {
        this(10);
    }

    public BodyShop(final int limit) {
        this.limit = limit;
        vehicles = new ArrayList<>();
    }

    /**
     * Used for adding Vehicle of type T onto the list of Vehicles held by the BodyShop.
     * @param t
     */

    public void addVehicleToShop(T t){
        if(this.t == null){
            this.t = t;
        }
        else if(vehicles.size() == limit){
            System.out.println("The Bodyshop is already full, please withdraw a "
                    + t.getClass().getName() + " before trying to add more");
        }
        else{
            vehicles.add(t);
        }
    }

    T removeFromBodyShop() {
        return (vehicles.size() > 0) ? vehicles.remove(0) : null;
    }

}

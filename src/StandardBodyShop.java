import java.awt.*;

public class StandardBodyShop {

    /**
     * This is used for creating a body shop with works with all different kind of Cars
     */

    private BodyShop<Vehicle> bodyShop;


    public StandardBodyShop() {
        this(10);
    }

    public StandardBodyShop(final int i){
        bodyShop = new BodyShop<>(i);
    }

    public void addVehicleToShop(Vehicle vehicle){
        bodyShop.addVehicleToShop(vehicle);
    }

    public Vehicle removeFromBodyShop() {
        return bodyShop.removeFromBodyShop();
    }

}

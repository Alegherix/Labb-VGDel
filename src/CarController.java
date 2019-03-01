import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    VehicleModel model;


    public CarController(CarView frame, VehicleModel model) {
        this.frame = frame;
        this.model = model;
    }

    public List<Vehicle> getWorkingVehicles(){
        return model.getVehicleList();
    }

    public void saabConsumer2(Consumer<Saab95> saab95Consumer){
        model.getSaab95s().forEach(saab95Consumer);
    }

    public void scaniaConsumer(Consumer<Scania> scaniaConsumer){
        model.getScanias().forEach(scaniaConsumer);
    }

    void vehicleConsumer(Consumer<Vehicle> action){
        model.getVehicleList().forEach(action);
    }
}

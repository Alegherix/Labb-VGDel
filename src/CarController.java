import java.awt.image.BufferedImage;
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

    // A list of cars, modify if needed
    Map<Vehicle, BufferedImage> vehicleMap;

    public VehicleModel getModel() {
        return model;
    }

    public void saabConsumer2(Consumer<Saab95> saab95Consumer){
        model.getSaab95s().forEach(saab95Consumer);
    }


    /*
    public void saabConsumer(Consumer<Saab95> action){
        vehicleMap.keySet()
                .stream()
                .filter(vehicle -> vehicle instanceof Saab95)
                .map(vehicle -> (Saab95)vehicle)
                .forEach(action);
    }


    public void scaniaConsumer(Consumer<Scania> action){
         vehicleMap.keySet()
                 .stream()
                 .filter(vehicle -> vehicle instanceof Scania)
                 .map(vehicle -> (Scania)vehicle)
                 .forEach(action);
    }

    void vehicleConsumer(Consumer<Vehicle> action){
        vehicleMap.keySet().forEach(action);
    }
    */
}

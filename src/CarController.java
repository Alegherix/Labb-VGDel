import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;

    // A list of cars, modify if needed
    Map<Vehicle, BufferedImage> vehicleMap;

    public Map<Vehicle, BufferedImage> getVehicleMap() {
        return vehicleMap;
    }

    /**
     * Used to test a round of 3 Vehicles Interacting.
     */

    public void enableTestRound(){
        Saab95 saab95 = new Saab95();
        Volvo240 volvo240 = new Volvo240();
        Scania scania = new Scania();

        volvo240.setPosition(0,100);
        scania.setPosition(0,200);

        addCars(saab95);
        addCars(volvo240);
        addCars(scania);
    }

    public void addCars(Vehicle vehicle){
        if(vehicleMap == null){
            vehicleMap = new HashMap<>();

        }
        vehicleMap.put(vehicle, vehicle.getImage());
    }

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

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for(Vehicle v : vehicleMap.keySet()){
                v.switchDirectionIfNecessary();
                v.move();
                frame.drawPanel.repaint();
            }
        }
    }

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.enableTestRound();

        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }


}

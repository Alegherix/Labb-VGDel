import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

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
    List<Vehicle> cars = new ArrayList<>();


    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        Scania scania = new Scania();
        scania.getPosition().setY(200);

        Saab95 saab95 = new Saab95();
        saab95.setPosition(0,100);


        cc.cars.add(new Volvo240());
        cc.cars.add(saab95);
        cc.cars.add(scania);

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        for(Vehicle v : cc.cars){
            System.out.println(v.getPosition());
        }

        // Start the timer
        cc.timer.start();
    }

    public List<Vehicle> getVehicles(){
        return cars;
    }

    /**
     * Used for managing the Engine of the vehicles via a Consumer Action
     * @param action action for the cars to perform
     */
    void engineHandling(Consumer<Vehicle> action){
        cars.forEach(action);
    }


    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle vehicle : cars) {
                vehicle.switchDirectionIfNecessary();
                vehicle.move();

                // Uppdaterar Positionen, viktigt att fixa behöver ej Point
                int x = (int) Math.round(vehicle.getPosition().getX());
                int y = (int) Math.round(vehicle.getPosition().getY());
                frame.drawPanel.moveit(x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
                System.out.println(vehicle + "And position is " + vehicle.getPosition());
            }
        }
    }




}

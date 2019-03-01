import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.function.Consumer;

public class VehicleModel implements IObservable{

    private final int delay = 50;

    private List<IObserver> observers;
    private List<Vehicle> vehicleList;
    private List<Saab95> saab95s;
    private List<Scania> scanias;
    private final Timer timer = new Timer(delay, new TimerListener());

    public VehicleModel() {
        observers = new ArrayList<>();
        vehicleList = new ArrayList<>();
        saab95s = new ArrayList<>();
        scanias = new ArrayList<>();
    }

    public Timer getTimer() {
        return timer;
    }

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public List<Saab95> getSaab95s() {
        return saab95s;
    }

    public List<Scania> getScanias() {
        return scanias;
    }

    /**
     * Used for adding Vehicles to the Model
     * @param vehicle Vehicle to addObserver
     */
    public void addVehicle(Vehicle vehicle){
        vehicleList.add(vehicle);

        if(vehicle.getClass().equals(Saab95.class)){
            saab95s.add((Saab95)vehicle);
        }
        else if(vehicle.getClass().equals(Scania.class)){
            scanias.add((Scania)vehicle);
        }
    }

    /**
     * Used to remove a vehicle from the Model
     * @param vehicle
     */
    public void removeVehicle(Vehicle vehicle){
        vehicleList.remove(vehicle);

        if(vehicle.getClass().equals(Saab95.class)){
            saab95s.remove(vehicle);
        }
        else if(vehicle.getClass().equals(Scania.class)){
            scanias.remove(vehicle);
        }
    }



    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for(Vehicle v : vehicleList){
                v.switchDirectionIfNecessary();
                v.move();
                notifyUpdate();
            }
        }
    }

    @Override
    public void addObserver(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void remove(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyUpdate() {
        observers.forEach(IObserver::update);
    }
}

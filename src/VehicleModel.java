import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.function.Consumer;

public class VehicleModel implements IObservable{

    private final int delay = 50;

    List<IObserver> observers;
    List<Vehicle> vehicleList;
    List<Saab95> saab95s;
    List<Volvo240> volvo240s;
    List<Scania> scanias;
    Map<Vehicle, BufferedImage> vehicleMap;
    private Timer timer = new Timer(delay, new TimerListener());

    public VehicleModel() {
        observers = new ArrayList<>();
        vehicleList = new ArrayList<>();
        saab95s = new ArrayList<>();
        volvo240s = new ArrayList<>();
        scanias = new ArrayList<>();
        vehicleMap = new HashMap<>();
    }

    public void addVehicle(Vehicle vehicle){
        // Used for adding vehicle to separate lists
        // So that no need
        vehicleList.add(vehicle);

        if(vehicle.getClass().equals(Saab95.class)){
            saab95s.add((Saab95)vehicle);
        }
        else if(vehicle.getClass().equals(Volvo240.class)){
            volvo240s.add((Volvo240)vehicle);
        }
        else if(vehicle.getClass().equals(Scania.class)){
            scanias.add((Scania)vehicle);
        }
    }

    public void removeVehicle(Consumer<List> listConsumer, Vehicle vehicle){
        vehicleList.remove(vehicle);

        if(vehicle.getClass().equals(Saab95.class)){
            saab95s.remove(vehicle);
        }
        else if(vehicle.getClass().equals(Volvo240.class)){
            volvo240s.remove(vehicle);
        }
        else if(vehicle.getClass().equals(Scania.class)){
            scanias.remove(vehicle);
        }

    }



    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for(Vehicle v : vehicleMap.keySet()){
                v.switchDirectionIfNecessary();
                v.move();
                notifyUpdate();
            }
        }
    }

    @Override
    public void add(IObserver observer) {
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

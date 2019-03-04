import javax.swing.*;
import java.util.List;
import java.util.function.Consumer;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // The view that represents this instance View of the MVC pattern
    CarView view;
    VehicleModel model;

    public CarController(CarView view, VehicleModel model) {
        this.view = view;
        this.model = model;
        enableAllButtons();
    }

    public void setView(CarView view) {
        this.view = view;
        enableAllButtons();
    }

    public void setModel(VehicleModel model) {
        this.model = model;
    }

    private void bindFunctionalityToVehicle(JButton button, Consumer<Vehicle> vehicleConsumer){
        button.addActionListener(e -> model.getVehicleList().forEach(vehicleConsumer));
    }

    private void bindFunctionalityToSaab(JButton button, Consumer<Saab95> saab95Consumer){
        button.addActionListener(e -> model.getSaab95s().forEach(saab95Consumer));
    }

    private void bindFuncionalityToScania(JButton button, Consumer<Scania> scaniaConsumer){
        button.addActionListener(e -> model.getScanias().forEach(scaniaConsumer));
    }

    private void enableVehicleButtons(){
        bindFunctionalityToVehicle(view.getStartButton(), vehicle -> vehicle.getEngine().startEngine());
        bindFunctionalityToVehicle(view.getStopButton(), vehicle -> vehicle.getEngine().stopEngine());
        bindFunctionalityToVehicle(view.getBrakeButton(), vehicle -> vehicle.brake(view.getGasAmount()));
        bindFunctionalityToVehicle(view.getGasButton(), vehicle -> vehicle.gas(view.getGasAmount()));
    }

    private void enableScaniaButtons(){
        bindFuncionalityToScania(view.getLiftBedButton(), Scania::raiseCargo);
        bindFuncionalityToScania(view.getLowerBedButton(), Scania::lowerCargo);
    }

    private void enableSaabButtons(){
        bindFunctionalityToSaab(view.getTurboOnButton(), Saab95::enableTurbo);
        bindFunctionalityToSaab(view.getTurboOffButton(), Saab95::disableTurbo);
    }

    private void enableGenerationButtons(){
        view.getAddCarButton().addActionListener(e -> model.generateVehicle());
        view.getRemoveCarButton().addActionListener(e -> model.removeRandomVehicle());
    }

    private void enableAllButtons(){
        enableVehicleButtons();
        enableScaniaButtons();
        enableSaabButtons();
        enableGenerationButtons();
    }

}

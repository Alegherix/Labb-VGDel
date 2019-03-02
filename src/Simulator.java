public class Simulator {
    public static void main(String[] args) {
        // Create the required components to run
        VehicleModel vehicleModel = new VehicleModel();
        CarController carController = new CarController();
        CarView carView = new CarView("Simulator 2.0");

        carController.setModel(vehicleModel);
        carController.setView(carView);

        //Creates test Vehicles
        Saab95 saab95 = new Saab95();
        Volvo240 volvo240 = new Volvo240();
        volvo240.setPosition(200,0);

        //Adds testVehicles to modell
        vehicleModel.addVehicle(saab95);
        vehicleModel.addVehicle(volvo240);

        //Adds the View as an Observer of the modell
        vehicleModel.addObserver(carView);

        carView.initializeMap(carController.getWorkingVehicles());


        vehicleModel.getTimer().start();
    }
}

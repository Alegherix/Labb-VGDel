public class Simulator {
    public static void main(String[] args) {
        // Create the required components to run
        VehicleModel vehicleModel = new VehicleModel();
        CarView carView = new CarView("Simulator 2.0");
        CarController carController = new CarController(carView, vehicleModel);

        //Adds testVehicles to model
        vehicleModel.addVehicle(VehicleFactory.createVolvo(new Position(0,0)));
        vehicleModel.addVehicle(VehicleFactory.createSaab(new Position(100,0)));

        //Adds the View as an Observer of the modell
        vehicleModel.addObserver(carView);

        vehicleModel.getTimer().start();
    }
}

public class Simulator {
    public static void main(String[] args) {
        // Create the required components to run
        VehicleModel vehicleModel = new VehicleModel();
        CarView carView = new CarView("Carsim 2.0");

        //Creates test Vehicles
        Saab95 saab95 = new Saab95();
        Volvo240 volvo240 = new Volvo240();
        volvo240.setPosition(0,200);

        //Adds testVehicles to modell
        vehicleModel.addVehicle(saab95);
        vehicleModel.addVehicle(volvo240);

        //Adds the View as an Observer of the modell
        vehicleModel.addObserver(carView);

        carView.initializeMap(vehicleModel.getVehicleList());

        vehicleModel.getTimer().start();
    }
}

public class Simulator {
    public static void main(String[] args) {
        VehicleModel vehicleModel = new VehicleModel();
        CarController controller = new CarController();
        Saab95 saab95 = new Saab95();
        Volvo240 volvo240 = new Volvo240();

        vehicleModel.addVehicle(saab95);
        vehicleModel.addVehicle(volvo240);

        vehicleModel.add(controller.frame);
        controller.frame = new CarView("CarSim 1.0", controller);
        vehicleModel.timer.start();
    }
}

public class SemiTruckWithExtension extends TransportationVehicle {


    public SemiTruckWithExtension(int cargoLimit) {
        super(cargoLimit);
    }

    public SemiTruckWithExtension(int cargoLimit, double angleLimitOfCargo) {
        super(cargoLimit, angleLimitOfCargo);
    }

    @Override
    public ITransportable unload() {
        return (canUnloadCargo())? getTransported().removeFirst() : null;
    }



}

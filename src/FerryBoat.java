public class FerryBoat extends TransportationVehicle{


    @Override
    public ITransportable unload() {
        return (canUnloadCargo())? getTransported().removeFirst() : null;
    }

}

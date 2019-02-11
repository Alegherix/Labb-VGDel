import java.awt.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.function.Predicate;

public abstract class TransportationVehicle extends Vehicle implements ITransporter<ITransportable>, ITransportable{

    private int cargoLimit;
    private Deque<ITransportable> transportationList;
    private Cargo cargo;
    private int loadingDistanceLimit;


    public TransportationVehicle() {
        this(10);
    }

    public TransportationVehicle(int cargoLimit) {
        this(cargoLimit, 70);
    }

    public TransportationVehicle(int cargoLimit, double angleLimitOfCargo) {
        this(cargoLimit, angleLimitOfCargo,
                new Body(Color.BLACK, 4), new Engine(400),
                Direction.SOUTH, new Position(), "", Type.TRUCK);
    }

    public TransportationVehicle(int cargoLimit, double angleLimitOfCargo, Body body, Engine engine, Direction direction,
        Position position, String modelName, Type type) {
        super(body, engine, position, direction, modelName, type);
        loadingDistanceLimit = 2;
        this.cargoLimit = cargoLimit;
        transportationList = new LinkedList<>();
        cargo = new Cargo(angleLimitOfCargo);
    }

    /**
     * Checks to make sure we can unload the cargo
     * @return
     */
  private boolean canUnloadCargo(){
        return cargoIsLowered() && tryingToManageCargoSafely();
  }

    /**
     * Unloads the Carried Transportables
     * @param iTransportable the object to be transported
     * @param position to put the transported onto
     * @return
     */
    @Override
    public ITransportable unload(ITransportable iTransportable, Position position) {
        if(canUnloadCargo()){
            iTransportable.setPosition(position);
            return iTransportable;
        }
        else{
            return null;
        }
    }

    /**
     * Loads the Transportable onto the Cargo
     * @param iTransportable
     */
    @Override
    public void load(ITransportable iTransportable) {
        if(withinLoadingCapacity() && cargoIsLowered() && tryingToManageCargoSafely()
        && withinValidLoadingrange(iTransportable) && !tryingToLoadItself(iTransportable)){
            transportationList.add(iTransportable);
        }
    }

    private boolean withinLoadingCapacity(){
        if(transportationList.size() < cargoLimit){
            return true;
        }
        else{
            throw new IllegalStateException("The cargo is already fully stacked");
        }
    }

    private boolean cargoIsLowered(){
        if(!cargo.isDown()){
            throw new IllegalStateException("You need to lower the cargo before trying to load");
        }
        else{
            return true;
        }
    }

    private boolean tryingToManageCargoSafely(){
        if(!isMoving()){
            return true;
        }
        else{
            throw new IllegalStateException("Plesae stop moving before attempting to manage the Cargo");
        }
    }

    private boolean tryingToLoadItself(ITransportable iTransportable){
        if(!this.equals(iTransportable)){
            return false;
        }
        else{
            throw new IllegalArgumentException("You can't load this " + iTransportable.getClass().getName() + " onto itself");
        }
    }

    @Override
    public Position getPosition() {
        return super.getPosition();
    }


    @Override
    public Deque<ITransportable> getTransported() {
        return transportationList;
    }

    @Override
    public boolean withinValidLoadingrange(ITransportable iTransportable){
        if(Math.abs(iTransportable.getPosition().getX() - getPosition().getX())<= loadingDistanceLimit &&
                Math.abs(iTransportable.getPosition().getY() - getPosition().getY())<=loadingDistanceLimit){
            return true;
        }
        else{
            throw new IllegalArgumentException("The car your trying to load is without of range for loading");
        }
    }

    public void lowerCargo(){
        if(tryingToManageCargoSafely()){
            cargo.lower();
        }
    }

    public void raiseCargo(){
        if(tryingToManageCargoSafely()){
            cargo.raise();
        }

    }

    /**
     * Drives the Tramsporter and updates the position of the cargo to that of the truck
     */
    @Override
    public void move() {
        if(cargo.isDown()){
            throw new IllegalStateException("You need to raise the cargo before driving");
        }
        else{
            super.move();
            transportationList.forEach(transported -> transported.setPosition(getPosition()));
        }
    }

}

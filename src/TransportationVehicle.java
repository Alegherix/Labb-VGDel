import java.util.Deque;
import java.util.LinkedList;
import java.util.function.Predicate;

public abstract class TransportationVehicle extends Vehicle implements ITransporter<ITransportable>{

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
        loadingDistanceLimit = 2;
        this.cargoLimit = cargoLimit;
        transportationList = new LinkedList<>();
        cargo = new Cargo(angleLimitOfCargo);

    }

  public boolean canUnloadCargo(){
        return !isMoving() && cargo.isDown();
  }

    /**
     *
     * @param iTransportable
     */
    @Override
    public void load(ITransportable iTransportable) {
        if(canAddToCargo() && !managingCargoWhileMoving()){
            transportationList.add(iTransportable);
        }

        /*
        if(iTransportable.equals(this)){
            throw new IllegalArgumentException("You can't load this " + iTransportable.getClass().getName() + " onto itself");
        }
        else if(!cargo.isDown()){
            throw new IllegalStateException("Cargo needs to be down to be loaded");
        }
        else if(!withinValidLoadingrange(iTransportable)){
            throw new IllegalStateException("The " + iTransportable.getClass().getName() + "needs to be within proper loading range");
        }
        else if(isMoving()){
            throw new IllegalStateException("You need to stop moving before trying to load");
        }
        else if(isFull()){
            throw new IllegalArgumentException("The cargo is already fully loaded");
        }
        else{
            transportationList.add(iTransportable);
        }
        */
    }

    public boolean canAddToCargo(){
        if(transportationList.size() < cargoLimit){
            return true;
        }
        else{
            throw new IllegalStateException("The cargo is already at max capacity");
        }
    }


    private boolean managingCargoWithoutBeingDown(){
        if(cargo.isDown()){
           return true;
        }
        else{
            throw new IllegalStateException("The cargo needs to be Down before trying to work with it");
        }
    }

    private boolean managingCargoWhileDriving(){
        if(isMoving()){
            return true;
        }
        else{
            throw new IllegalStateException("You cannot manage the cargo while driving");
        }
    }

    private boolean managingCargoWhileMoving(){
        if(isMoving()){
            return true;
        }
        else{
            throw new IllegalStateException("You need to stop before trying to manage the cargo");
        }
    }

    private boolean tryingToLoadItself(ITransportable iTransportable){
        if(!this.equals(iTransportable)){
            return true;
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
    public boolean isFull() {
        return transportationList.size() >= cargoLimit;
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
        if(!managingCargoWhileMoving()){
            cargo.lower();
        }

    }

    public void raiseCargo(){
        if(!managingCargoWhileMoving()){
            cargo.raise();
        }
    }

}

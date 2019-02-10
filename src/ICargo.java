public interface ICargo{

    void lower();

    void raise();

    default void lowerCargo(Vehicle vehicle){
        if(!vehicle.isMoving()){
            this.lower();
        }
        else{
            throw new IllegalStateException("You need to stop moving before trying to lower the Cargo");
        }
    }

}

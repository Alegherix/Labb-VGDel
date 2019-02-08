public class Engine {

    double enginePower;
    double currentSpeed;


    public Engine(double enginePower) {
        this.enginePower = enginePower;
    }

    /**
     * Returns the current speed of the car
     * @return the current speed
     */



    public double getEnginePower() {
        return enginePower;
    }

    /**
     * Returns the color of the car
     * @return the color of the car
     */
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    /**
     * Starts the engine of the car
     */
    public void startEngine(){
        currentSpeed = 0.1;
    }

    /**
     * Kills the engine of the car
     */
    public void stopEngine(){
        currentSpeed = 0;
    }



}

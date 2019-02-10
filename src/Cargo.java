public class Cargo implements ICargo {

    private Angle angle;
    private double angleCap;

    public Cargo() {
        this(70);
    }

    public Cargo(double angleCap){
        this.angleCap = angleCap;
        angle = new Angle();
    }


    @Override
    public void lower() {
        angle.setState(Angle.STATE.DOWN);
    }

    @Override
    public void raise() {
        angle.setState(Angle.STATE.UP);
    }


    public void manuallyRaise(double amount){
        if(getAngle().getState().getDegree() + amount >= angleCap){
            angle.setState(angleCap);
        }
        else{
            angle.setState(amount);
        }
    }

    public void manuallyLower(double amount){
        if(getAngle().getState().getDegree() - amount <= 0){
            angle.setState(0);
        }
        else{
            angle.setState(amount);
        }
    }

    public boolean isDown(){
        return angle.getState().equals(Angle.STATE.DOWN);
    }

    public Angle getAngle() {
        return angle;
    }
}
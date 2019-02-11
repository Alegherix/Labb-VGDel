public class Angle {

    /**
     * An enum for enabling reuse of the Cargo angle by using both state and value
     */
    enum STATE{

        UP(70), DOWN(0);

        private double degree;

        public double getDegree(){
            return degree;
        }

        STATE(double degree){
            this.degree = degree;

        }
    }

    private STATE state;
    private double amount;

    /**
     * A Class for
     */
    public Angle() {
        this(STATE.UP.getDegree());
    }

    public Angle(double amount){
        this.state = STATE.UP;
        this.amount = amount;

    }

    public STATE getState() {
        return state;
    }

    public void setState(STATE state) {
        this.state = state;
    }


    public void setState(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}

public class Angle {

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

    public Angle() {
        this.state = STATE.UP;
        amount = STATE.UP.getDegree();
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

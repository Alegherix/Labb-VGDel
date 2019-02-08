import java.awt.*;

public class Body {

    private Color color;
    private int nrDoors;

    public Body(Color color, int nrDoors) {
        this.color = color;
        this.nrDoors = nrDoors;
    }

    public Color getColor() {
        return color;
    }


    public int getNrDoors() {
        return nrDoors;
    }

}

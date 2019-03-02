import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SpeedView extends JLabel{

    List<Vehicle> vehicleList;



    void enableText(){
        for(Vehicle v : vehicleList){
            setText(v + ": " + v.getEngine().getCurrentSpeed());
        }
    }
}

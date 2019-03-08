import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Observer;

public class SpeedView extends JLabel{

    List<Vehicle> vehicleList;

    SpeedView(List<Vehicle> vehicles){
        vehicleList = vehicles;
    }

    void updateList(List<Vehicle> vehicles){
        vehicleList = vehicles;
    }

    void updateView(){
        StringBuilder sb = new StringBuilder();
        vehicleList.forEach(v -> sb.append(v)
                        .append(" : ")
                        .append(v.getEngine().getCurrentSpeed())
                        .append("  |  "));
        setText(sb.toString());
    }
}

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;
import java.util.*;
import java.util.List;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    private Map<Vehicle, BufferedImage> vehicleMap;

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, List<Vehicle> vehicles) {
        updateMap(vehicles);
        setDoubleBuffered(true);
        setPreferredSize(new Dimension(x, y));
        setBackground(Color.green);
    }

    public void updateMap(List<Vehicle> vehicles){
        if(vehicleMap == null){
            vehicleMap = new HashMap<>();
        }
        else{
            vehicleMap.clear();
            for(Vehicle v : vehicles){
                vehicleMap.put(v, getImage(v));
            }
        }
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        vehicleMap.forEach((k,v) -> g.drawImage(v, (int)k.getPosition().getX(), (int)k.getPosition().getY(), null));
    }

    public BufferedImage getImage(Vehicle vehicle) {
        try {
            return ImageIO.read(DrawPanel.class.getResourceAsStream("pics/" + vehicle.getClass().getName() +".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.util.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    private Map<Vehicle, BufferedImage> vehicleMap;

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, Map<Vehicle, BufferedImage> vehicleMap) {
        this.vehicleMap = vehicleMap;
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        vehicleMap.forEach((k,v) -> g.drawImage(k.getImage(), (int)k.getPosition().getX(), (int)k.getPosition().getY(), null));
    }
}

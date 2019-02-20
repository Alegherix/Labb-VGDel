import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.*;
import java.util.List;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize
    BufferedImage volvoImage;
    BufferedImage saabImage;
    BufferedImage scaniaImage;
    // To keep track of a singel cars position
    Point centerPoint = new Point();

    List<Vehicle> vehicles;

    public void initializeVehicles(List<Vehicle> initializationList){
        vehicles = initializationList;
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.vehicles = vehicles;
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);

        try {
            volvoImage = getImage("pics/Volvo240.jpg");
            saabImage = getImage("pics/Saab95.jpg");
            scaniaImage = getImage("pics/Scania.jpg");
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    // TODO: Make this genereal for all cars
    void moveit(int x, int y){
        /*
        for(Vehicle v : vehicles){
            v.getPosition().setX(x);
            v.getPosition().setY(y);
        }
        */
        centerPoint.y = y;
    }

    private BufferedImage getImage(String s) throws IOException {
        return ImageIO.read(DrawPanel.class.getResourceAsStream(s));
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //for(Vehicle v : vehicles){
        //    g.drawImage(volvoImage, (int)v.getPosition().getX(), (int)v.getPosition().getY(), null);
        //}
        g.drawImage(volvoImage, centerPoint.x, centerPoint.y, null); // see javadoc for more info on the parameters
        g.drawImage(saabImage, centerPoint.x, centerPoint.y + 100, null);
        g.drawImage(scaniaImage, centerPoint.x, centerPoint.y + 200, null);
    }
}

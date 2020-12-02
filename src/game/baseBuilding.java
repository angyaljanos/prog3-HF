package game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class baseBuilding extends JPanel {
    protected BufferedImage image;
    protected String buildingName;
    protected int numberOfWorkers;
    protected long coolDownMs;

    public baseBuilding(String path) throws IOException {
        image = ImageIO.read(new File(path));
        addMouseListener(new propertyWindowOnHover(this));

        panelSettings();
    }
    public baseBuilding() throws IOException {
        image = ImageIO.read(new File("../../resources/blank.jpg"));
        addMouseListener(new propertyWindowOnHover(this));

        panelSettings();
    }

    private void panelSettings(){
        setPreferredSize(new Dimension(180,180));


        setBackground(Color.lightGray);
    }

    public String getName(){
        return buildingName;
    }

    public long getCoolDownMs(){
        return coolDownMs;
    }

    public int getQuantity(){
        return 1 + (numberOfWorkers/5);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }

    protected class propertyWindowOnHover implements MouseListener {
        buildingPropertyWindow propertyWindow;

        public propertyWindowOnHover(baseBuilding building){
            propertyWindow = new buildingPropertyWindow(building);
        }
        //unused methods
        @Override
        public void mouseClicked(MouseEvent mouseEvent) {

        }

        @Override
        public void mousePressed(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseReleased(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseEntered(MouseEvent mouseEvent) {
            propertyWindow.showProperties();
        }

        @Override
        public void mouseExited(MouseEvent mouseEvent) {
            propertyWindow.dispose();
        }
    }
}
//https://stackoverflow.com/questions/299495/how-to-add-an-image-to-a-jpanel

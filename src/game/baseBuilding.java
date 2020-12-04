package game;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class baseBuilding extends JPanel {
    protected BufferedImage image;
    protected String buildingName = "Field";
    protected int numberOfWorkers;
    protected long coolDownMs;
    protected long cost;

    public baseBuilding(String path) throws IOException {
        image = ImageIO.read(new File(path));

        otherSettings();
    }
    public baseBuilding() throws IOException {
        image = ImageIO.read(Objects.requireNonNull(baseBuilding.class.getClassLoader().getResourceAsStream("blank.png")));

        otherSettings();
    }

    private void otherSettings(){
        setPreferredSize(new Dimension(180,180));
        setBorder(new LineBorder(Color.black));
        setBackground(Color.lightGray);

        addMouseListener(new propertyWindowOnHover(this));

        cost = 3;
    }

    public String getBuildingName(){
        return buildingName;
    }

    public long getCoolDownMs(){
        return coolDownMs;
    }

    public int getQuantity(){
        return 0;
    }

    protected void addWorker(){
        if(Player.gold >= cost) {
            numberOfWorkers++;
            coolDownMs = 3000 / numberOfWorkers;

            Player.gold -= cost;
            cost *= 2;
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }

    private static class propertyWindowOnHover implements MouseListener {
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

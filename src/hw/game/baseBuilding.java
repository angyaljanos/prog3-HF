package hw.game;

import com.google.gson.annotations.Expose;
import hw.MainFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class baseBuilding extends JPanel implements Runnable{
    public static boolean isWindowOpen = false;

    protected BufferedImage image;
    @Expose
    protected int numberOfWorkers;
    protected long coolDownMs;
    @Expose
    protected long cost;
    @Expose
    protected String name = "Field";
    protected Player owner;
    protected MainFrame mainFrame;
    protected Thread thread = new Thread(this);
    protected boolean running = true;

    public baseBuilding(String path, Player player, MainFrame mainFrame) throws IOException {
        image = ImageIO.read(Objects.requireNonNull(baseBuilding.class.getClassLoader().getResourceAsStream(path)));
        owner = player;

        this.mainFrame = mainFrame;
        settings();
    }
    public baseBuilding(Player player,MainFrame mainFrame) throws IOException {
        image = ImageIO.read(Objects.requireNonNull(baseBuilding.class.getClassLoader().getResourceAsStream("blank.png")));
        owner = player;

        this.mainFrame = mainFrame;
        settings();
    }

    protected void settings(){
        setPreferredSize(new Dimension(180,180));
        setBorder(new LineBorder(Color.black));
        setBackground(Color.lightGray);

        addMouseListener(new propertyWindowOnHover(this));
        thread.start();
    }

    public String getBuildingName(){
        return name;
    }

    public long getCoolDownMs(){
        return coolDownMs;
    }

    public int getQuantity(){
        return 0;
    }

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    public void setNumberOfWorkers(int numberOfWorkers) {
        this.numberOfWorkers = numberOfWorkers;
    }

    public int getNumberOfWorkers() {
        return numberOfWorkers;
    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }

    public void addWorker(){
        if(owner.getGold() >= cost) {
            numberOfWorkers++;
            coolDownMs = 3000 / numberOfWorkers;

            owner.decraseGold(cost);
            cost *= 2;

            ingameMenuSlide.refresh(owner);
        }
    }

    protected baseBuilding getBuilding(){return this;}

    public void start(){
        thread.start();
    }

    public void stop(){
        running = false;
    }

    public Player getOwner() {
        return owner;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }

    @Override
    public void run() {

    }

    private class propertyWindowOnHover implements MouseListener {
        buildingPropertyWindow propertyWindow;

        public propertyWindowOnHover(baseBuilding building){
            propertyWindow = new buildingPropertyWindow(building);
        }

        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
            if(!isWindowOpen)
                (new buildingShopFrame(getBuilding())).showShop();

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

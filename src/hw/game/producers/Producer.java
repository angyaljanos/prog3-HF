package hw.game.producers;

import hw.game.Player;
import hw.game.baseBuilding;
import hw.game.buildingPropertyWindow;
import hw.MainFrame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public abstract class   Producer extends baseBuilding {

    public Producer(String path, Player player, MainFrame mainFrame) throws IOException {
        super(path, player, mainFrame);
        addMouseListener(new mouseHandler(this));
        coolDownMs = 3000;
        numberOfWorkers = 1;
    }

    public void produce(String productName) throws InterruptedException {
        while(running) {
            Integer currentQuantity = (Integer) owner.inventory.get(productName);
            if (currentQuantity > Player.capacityPerItem)
                Thread.currentThread().wait();
            else {
                int newQuantity = currentQuantity + getQuantity();
                    if (newQuantity > Player.capacityPerItem)
                        newQuantity = Player.capacityPerItem;

                owner.inventory.put(productName, newQuantity);
                Thread.sleep(coolDownMs);
            }
        }
    }
    protected abstract String getBaseName();

    @Override
    public String getBuildingName(){

        return getBaseName() + "Lv."+numberOfWorkers;
    }

    @Override
    public int getQuantity(){
        return 1 + (numberOfWorkers/5);
    }

    @Override
    protected void settings(){
    }

    protected class mouseHandler implements MouseListener {
        buildingPropertyWindow hoverWindow;
        producerPropertyWindow interactWindow;

        public mouseHandler(baseBuilding building){
            hoverWindow = new buildingPropertyWindow(building);
            interactWindow = new producerPropertyWindow(building);
        }

        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
            interactWindow.showProperties();
        }

        @Override
        public void mousePressed(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseReleased(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseEntered(MouseEvent mouseEvent) {
            hoverWindow.showProperties();
        }

        @Override
        public void mouseExited(MouseEvent mouseEvent) {
            hoverWindow.dispose();
        }
    }
}

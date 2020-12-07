package game.producers;

import game.Player;
import game.baseBuilding;
import game.buildingPropertyWindow;
import hw.MainFrame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public abstract class Producer extends baseBuilding {

    public Producer(String path, Player player, MainFrame mainFrame) throws IOException {
        super(path, player, mainFrame);
        addMouseListener(new mouseHandler(this));
    }

    public void produce(String productName) throws InterruptedException {
        while(true) {
            Integer currentQuantity = (Integer) owner.getInventory().get(productName);
            System.out.println(owner.getInventory().get(productName));
            if (currentQuantity > Player.capacityPerItem)
                Thread.currentThread().wait();
            else {
                int newQuantity = currentQuantity + getProd();
                    if (newQuantity > Player.capacityPerItem)
                        newQuantity = Player.capacityPerItem;

                owner.getInventory().put(productName, newQuantity);
            }
        }
    }
    public String getBuildingName(){

        return super.getBuildingName() + "Lv."+numberOfWorkers;
    }

    public int getProd(){
        return 1 + (numberOfWorkers/5);
    }

    protected class mouseHandler implements MouseListener {
        buildingPropertyWindow propertyWindow;

        public mouseHandler(baseBuilding building){
            propertyWindow = new buildingPropertyWindow(building);
        }

        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
            addWorker();
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

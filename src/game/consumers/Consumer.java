package game.consumers;

import game.Game;
import game.Player;
import game.baseBuilding;
import game.buildingPropertyWindow;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public abstract class Consumer extends baseBuilding {
    protected String targetProduct = "";

    public Consumer(String path,Player player) throws IOException {
        super(path, player);
        addMouseListener(new mouseHandler(this));
    }

    public void setTargetProduct(String targetProduct) {
        this.targetProduct = targetProduct;
    }

    public String getBuildingName(){

        return super.getBuildingName() + "Lv."+numberOfWorkers;
    }

    public void run() {
        try {
            sell();
            notifyAll();
            Thread.sleep(coolDownMs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void sell() throws InterruptedException {
        Integer currentQuantity = owner.getInventory().get(targetProduct);
        Integer newQuantity = currentQuantity - 1 - (numberOfWorkers/5);
        if(currentQuantity <= 0)
            Thread.currentThread().wait();
        else {
            owner.getInventory().put(targetProduct, newQuantity > 0 ? newQuantity : 0);
            owner.incrementGold((long)newQuantity * (long)Game.prices.get(targetProduct));
        }
    }
    @Override
    public int getQuantity(){
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

package game.consumers;

import game.*;
import hw.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public abstract class Consumer extends baseBuilding {
    protected String targetProduct = "None";

    public Consumer(String path,Player player,MainFrame mainFrame) throws IOException {
        super(path, player, mainFrame);
        addMouseListener(new mouseHandler(this));
        coolDownMs = 4500;
    }

    @Override
    protected void settings(){
    }

    public void setTargetProduct(String targetProduct) {
        this.targetProduct = targetProduct;
    }

    protected abstract String getBaseName();

    @Override
    public String getBuildingName(){

        return getBaseName() + "Lv."+numberOfWorkers;
    }

    @Override
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
        if(owner.inventory.containsKey(targetProduct)) {
            Integer currentQuantity = owner.inventory.get(targetProduct);
            int newQuantity = currentQuantity - 1 - (numberOfWorkers / 5);
            if (currentQuantity <= 0)
                thread.wait();
            else {
                owner.inventory.put(targetProduct, Math.max(newQuantity, 0));
                owner.incrementGold((long) newQuantity * (long) Game.prices.get(targetProduct));
            }
            ingameMenuSlide.refresh(owner);
        }
    }
    @Override
    public int getQuantity(){
        return 1 + (numberOfWorkers/5);
    }

    protected class mouseHandler implements MouseListener {
        buildingPropertyWindow hoverWindow;
        consumerPropertyWindow interactWindow;

        public mouseHandler(baseBuilding building){
            hoverWindow = new buildingPropertyWindow(building);
            interactWindow = new consumerPropertyWindow(getBuilding());
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

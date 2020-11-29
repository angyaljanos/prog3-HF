package game.consumers;

public class sellerMarket extends Consumer{
    public sellerMarket(){
        numberOfWorkers = 1;
        coolDownMs = 3000;
        this.targetProduct = "";
    }

    @Override
    public void addWorker() {
        super.addWorker();
    }

    @Override
    public void run(){
        super.run();
    }
}

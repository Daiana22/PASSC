package EventBus;

public class Main {
    public static void main(String[] args){
        EventBus event = new EventBus();
        AbstractWorker w1 = new WorkerCutSeat(event);
        AbstractWorker w2 = new WorkerAssembleBackrest(event);
        AbstractWorker w3 = new WorkerAssembleFeet(event);
        AbstractWorker w4 = new WorkerAssembleStabilizerBar(event);
        AbstractWorker w5 = new WorkerPackage(event);

        event.publish("start");
    }
}

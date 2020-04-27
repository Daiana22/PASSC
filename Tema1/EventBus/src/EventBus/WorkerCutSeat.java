package EventBus;

public class WorkerCutSeat extends AbstractWorker {
    public WorkerCutSeat(EventBus event) {
        this.event = event;
        this.subscribe("start");
    }

    public void notify(String message) {
        System.out.println("cut seat");
        this.publish("cut seat");
    }
}
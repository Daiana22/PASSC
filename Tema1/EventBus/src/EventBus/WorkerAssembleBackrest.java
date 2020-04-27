package EventBus;

public class WorkerAssembleBackrest extends AbstractWorker {
    public WorkerAssembleBackrest(EventBus event) {
        this.event = event;
        this.subscribe("cut seat");
    }

    public void notify(String message) {
        System.out.println("backrest assembled");
        this.publish("backrest assembled");
    }
}

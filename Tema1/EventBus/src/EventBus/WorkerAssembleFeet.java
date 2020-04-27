package EventBus;

public class WorkerAssembleFeet extends AbstractWorker {
    public WorkerAssembleFeet(EventBus event) {
        this.event = event;
        this.subscribe("cut seat");
    }

    public void notify(String message) {
        System.out.println("feet assembled");
        this.publish("feet assembled");
    }
}

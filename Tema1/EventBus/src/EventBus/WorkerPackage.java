package EventBus;

public class WorkerPackage extends AbstractWorker {
    public WorkerPackage(EventBus event) {
        this.event = event;
        this.subscribe("stabilizer bar assembled");
    }

    public void notify(String message) {
        if (message.equals("stabilizer bar assembled")) {
            System.out.println("package complete");
            this.publish("package complete");
        }
    }
}
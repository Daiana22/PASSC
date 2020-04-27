package EventBus;

public class WorkerAssembleStabilizerBar extends AbstractWorker {
    public WorkerAssembleStabilizerBar(EventBus event) {
        this.event = event;
        this.subscribe("feet assembled");
    }

    public void notify(String message) {
        System.out.println("stabilizer bar assembled");
        this.publish("stabilizer bar assembled");
    }
}

package EventBus;

public abstract class AbstractWorker {
    protected EventBus event;
    public void publish(String message){
        event.publish(message);
    }
    public void subscribe(String message){
        event.subscribe(message, this);
    }
    public abstract void notify(String message);
}

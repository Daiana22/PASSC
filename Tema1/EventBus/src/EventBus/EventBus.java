package EventBus;

import java.util.*;

public class EventBus {
    Map<String, ArrayList<AbstractWorker>> subscribers= new HashMap<String, ArrayList<AbstractWorker>>();

    public void publish(String message) {
        int i;
        ArrayList<AbstractWorker> subscribersMessage = subscribers.get(message);

        if (subscribersMessage != null) {
            for (i = 0; i < subscribersMessage.size(); i++) {
                subscribersMessage.get(i).notify(message);
            }
        }
    }

    public void subscribe(String message, AbstractWorker worker) {
        if (subscribers.containsKey(message)) {
            ArrayList<AbstractWorker> subscribersMessage = subscribers.get(message);
            subscribersMessage.add(worker);
            subscribers.put(message, subscribersMessage);
        }
        else {
            ArrayList<AbstractWorker> subscribersMessage = new ArrayList<AbstractWorker>();
            subscribersMessage.add(worker);
            subscribers.put(message, subscribersMessage);
        }
    }
}


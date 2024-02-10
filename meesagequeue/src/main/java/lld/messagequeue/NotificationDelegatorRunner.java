package lld.messagequeue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotificationDelegatorRunner implements NotificationDelegator {

    private final Map<String, List<Consumer>> topicWithConsumers = new HashMap<>();

    @Override
    public boolean delegateNotify(String topic, String message) {
        try {
            this.topicWithConsumers.get(topic).forEach((consumer) -> {
                consumer.onMessageReceived(message);
            });
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    synchronized public void addObserver(String topic, Consumer consumer) {
        if (!topicWithConsumers.containsKey(topic)) {
            this.topicWithConsumers.put(topic, new ArrayList<>());
        }
        this.topicWithConsumers.get(topic).add(consumer);
    }

    @Override
    public void removeObserver(String topic, Consumer consumer) {
        if (topicWithConsumers.containsKey(topic)) {
            this.topicWithConsumers.get(topic).remove(consumer);
        }
    }
}

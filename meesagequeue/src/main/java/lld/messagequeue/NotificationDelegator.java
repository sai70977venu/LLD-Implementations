package lld.messagequeue;

public interface NotificationDelegator {

    boolean delegateNotify(String topic, String payload);

    void addObserver(String topic, Consumer consumer);

    void removeObserver(String topic, Consumer consumer);

}

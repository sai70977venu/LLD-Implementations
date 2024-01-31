package lld.messagequeue;

import lld.messagequeue.datastructure.Queue;
import lld.messagequeue.datastructure.QueuePayload;

public class MessageQueueFacade implements QueueNotifiers {

    private final Queue queueModel;

    private final NotificationDelegator notificationDelegator;

    public MessageQueueFacade(Queue queueModel, NotificationDelegator notificationDelegator) {
        this.queueModel = queueModel;
        this.notificationDelegator = notificationDelegator;
    }

    public void publish(QueuePayload queuePayload) {
        this.beforeReceive();
        this.queueModel.push(queuePayload);
        this.afterReceive();
    }

    public void remove() {
        this.queueModel.remove();
    }

    @Override
    public void beforeReceive() {
        System.out.println("Before Receive");
    }

    @Override
    public void afterReceive() {
        QueuePayload queuePayload = this.queueModel.peek();
        boolean success = this.notificationDelegator.delegateNotify(
                queuePayload.getTopicName(),
                queuePayload.getPayload());
        if (success) {
            this.remove();
        }
    }

    public void subscribe(String topic, Consumer consumer) {
        this.notificationDelegator.addObserver(topic, consumer);
    }

    public void unsubscribe(String topic, Consumer consumer) {
        this.notificationDelegator.removeObserver(topic, consumer);
    }

}

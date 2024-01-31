package lld.messagequeue;

import lld.messagequeue.datastructure.Queue;
import lld.messagequeue.datastructure.QueuePayload;
import lld.messagequeue.datastructure.impl.QueueImplementation;

public class Main {
    public static void main(String[] args) {
        Queue queue = new QueueImplementation();
        NotificationDelegator notificationDelegator = new NotificationDelegatorRunner();
        MessageQueueFacade messageQueueFacade = new MessageQueueFacade(queue, notificationDelegator);
        Thread[] consumers = new Thread[10];
        for(int i = 0; i < 10; i++) {
            consumers[i] = new ConsumerImpl("t"+i, messageQueueFacade);
            consumers[i].start();
        }
        for(int i = 0; i < 10; i++) {
            try {
                consumers[i].join();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        QueuePayload queuePayload = new QueuePayload();
        queuePayload.setId("Message 1");
        queuePayload.setTopicName("/chat");
        queuePayload.setPayload("HelloWorld");
        messageQueueFacade.publish(queuePayload);
    }
}
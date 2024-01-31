package lld.messagequeue;

public class ConsumerImpl extends Thread implements Consumer {

    String name;
    MessageQueueFacade messageQueueFacade;

    public ConsumerImpl(String uuid, MessageQueueFacade messageQueueFacade) {
        this.messageQueueFacade = messageQueueFacade;
        this.name = "consumer:" + uuid;
    }

    @Override
    public void run() {
        this.messageQueueFacade.subscribe("/chat", this);
    }

    @Override
    public void onMessageReceived(String payload) {
        System.out.println("Thread Name: " + this.name + " Received Payload: " + payload);
    }
}

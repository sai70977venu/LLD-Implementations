package lld.messagequeue;

public interface Consumer {
    
    void onMessageReceived(String payload);

}

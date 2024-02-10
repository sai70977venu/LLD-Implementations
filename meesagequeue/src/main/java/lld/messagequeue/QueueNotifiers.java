package lld.messagequeue;

public interface QueueNotifiers {

    void beforeReceive();

    void afterReceive();

}

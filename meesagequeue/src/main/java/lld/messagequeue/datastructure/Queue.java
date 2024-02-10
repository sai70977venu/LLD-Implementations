package lld.messagequeue.datastructure;

import java.util.List;

public interface Queue {

    void push(QueuePayload payload);

    void remove();

    QueuePayload peek();

    List<QueuePayload> getQueue();

}

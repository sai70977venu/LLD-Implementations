package lld.messagequeue.datastructure.impl;

import lld.messagequeue.datastructure.Queue;
import lld.messagequeue.datastructure.QueuePayload;

import java.util.ArrayList;
import java.util.List;

public class QueueImplementation implements Queue {

    List<QueuePayload> queue = new ArrayList<>();
    @Override
    public void push(QueuePayload payload) {
        queue.add(payload);
    }

    @Override
    public void remove() {
        if (queue.size() > 0) {
            queue.remove(0);
        }
    }

    @Override
    public QueuePayload peek() {
        return this.queue.get(0);
    }

    @Override
    public List<QueuePayload> getQueue() {
        return queue;
    }
}

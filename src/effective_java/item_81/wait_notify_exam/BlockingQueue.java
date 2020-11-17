package effective_java.item_81.wait_notify_exam;

import java.util.NoSuchElementException;

public class BlockingQueue {
    private int size;
    private Node head, tail;
    private final int capacity;

    public BlockingQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }
        this.capacity = capacity;
    }

    private static class Node {
        private String value;
        private Node next;
    }

    public synchronized boolean isFull() {
        return size == capacity;
    }

    public synchronized boolean isEmpty() {
        return head == null;
    }

    public synchronized void enqueue(String item) {
        try {
            while (isFull()) {
                wait();
            }
        } catch (InterruptedException ex) {}

        Node oldTail = tail;
        tail = new Node();
        tail.value = item;
        tail.next = null;
        if (isEmpty()) {
            head = tail;
        } else {
            oldTail.next = tail;
        }
        size++;

        notifyAll();
    }

    public synchronized String deque() {
        try {
            while (isEmpty()) {
                wait();
            }
        } catch (InterruptedException ex) {}


        String value = head.value;
        head = head.next;
        size--;
        if (isEmpty()) {
            tail = null;
        }

        notifyAll();
        return value;
    }

    @Override
    public String toString() {
        Node idxNode = head;
        StringBuilder sb = new StringBuilder();

        while (idxNode != null) {
            sb.append(idxNode.value);
            if (idxNode.next != null)
                sb.append(" -> ");

            idxNode = idxNode.next;
        }

        return sb.toString();
    }
}

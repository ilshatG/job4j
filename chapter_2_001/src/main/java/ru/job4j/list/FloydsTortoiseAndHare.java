package ru.job4j.list;

public class FloydsTortoiseAndHare {
    boolean hasCycle(Node first) {
        Node slow = first;
        Node fast = first;
        boolean result = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                result = true;
                break;
            }
        }
        return result;
    }
}

class Node<T> {
    T value;
    Node<T> next;
    Node(T value) {
        this.value = value;
    }
}
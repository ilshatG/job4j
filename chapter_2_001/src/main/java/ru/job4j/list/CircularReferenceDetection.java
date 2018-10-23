package ru.job4j.list;

public class CircularReferenceDetection {
    private Node<Node> firstPassed;
    Node<Node> currentPassed;

    /**
     * При каждом проходе добавляем ссыку на пройденный узел в отдельные связанные узлы в которых храним ссылки на пройденные.
     * При каждом проходе узла проверяем нет ли ссылки на него в узлах для хранения ссылок на уже пройденные узлы.
     * Если есть, то имеет место циклическая ссылка.
    */
    public boolean hasCycle(Node first) {
        firstPassed = new Node<Node>(first);
        currentPassed = firstPassed;
        boolean result = false;
        Node current = first.next;
        while (current != null) {
            if (checkForCircularReference(current)) {
                result = true;
                break;
            }
            currentPassed.next = new Node<Node>(current);
            currentPassed = currentPassed.next;
            current = current.next;
        }
        return result;
    }

    private  boolean checkForCircularReference(Node node) {
        Node<Node> passed = firstPassed;
        boolean result = false;
        while (passed != null) {
            if (passed.value == node) {
                result = true;
                break;
            }
            passed = passed.next;
        }
        return result;
    }

}


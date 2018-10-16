package ru.job4j.search;

import java.util.LinkedList;
import java.util.stream.Collectors;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * @param task задача
     */
    public void put(Task task) {
            tasks.add(task);
            tasks = tasks.stream().sorted((o1, o2) -> o1.getPriority() - o2.getPriority())
                .collect(Collectors.toCollection(LinkedList::new));
    }

    public Task take() {
        return this.tasks.poll();
    }

    public LinkedList<Task> getList() {
        return this.tasks;
    }
}
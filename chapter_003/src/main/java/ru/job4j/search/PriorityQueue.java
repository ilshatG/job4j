package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        if (tasks.size() == 0) {
            tasks.add(0, task);
        } else {
            int index = 0;
            for (Task element : tasks) {
                if (element.getPriority() >= task.getPriority()) {
                    tasks.add(index, task);
                    break;
                }
                index++;
            }
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}
package ru.job4j.list;

import java.util.NoSuchElementException;

public class SimpleArrayList<T> {
    private int size;
    private Node<T> first;

    /**
     * Метод вставляет в начало списка данные.
     */
    public void add(T data) {
        Node<T> newLink = new Node<T>(data);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
    }

    /**
     * Реализовать метод удаления первого элемент в списке.
     */
    public T delete() {
        this.first = this.first.next;
        size--;
        return first != null ? first.data : null;
    }

    /**
     * Метод получения элемента по индексу.
     */
    public T get(int index) {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        Node<T> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.data;
    }

    /**
     * Метод получения размера коллекции.
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Класс предназначен для хранения данных.
     */
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }
}

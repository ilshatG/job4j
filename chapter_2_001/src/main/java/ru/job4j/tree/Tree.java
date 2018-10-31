package ru.job4j.tree;

import java.util.*;

public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    private Node<E> root;
    private int count = 0;
    private int modCount = 0;
    @Override
    public boolean add(E parent, E child) {
        boolean result = false;
        if (root == null) {
            root = new Node(parent);
        }
        Optional<Node> father = findBy(parent);
        if (father.isPresent()) {
            if (!father.get().leavesContains(child)) {
                father.get().add(new Node(child));
                result = true;
                count++;
                modCount++;
            }
        }
        return result;
    }

    @Override
    public Optional<Node> findBy(E value) {
        Optional<Node> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    @Override
    public Iterator<Node<E>> iterator() {
        return new Iterator<Node<E>>() {
            private int expectedModCount = modCount;
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index <= count;
            }

            @Override
            public Node<E> next() {

                if (index > count) {
                    throw new NoSuchElementException();
                }
                Optional<Node> rsl = Optional.empty();
                Queue<Node<E>> data = new LinkedList<>();
                data.offer(root);
                int i = 0;
                while (!data.isEmpty()) {
                    Node<E> el = data.poll();
                    if (i == index) {
                        rsl = Optional.of(el);
                        break;
                    }
                    i++;
                    for (Node<E> child : el.leaves()) {
                        data.offer(child);
                    }
                }
                index++;
                return rsl.get();
            }

            private void checkModification() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
            }
        };
    }
}

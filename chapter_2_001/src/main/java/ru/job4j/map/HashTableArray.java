package ru.job4j.map;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class HashTableArray<K, V> implements Iterable<Node<K, V>> {
    private int size = 16;
    private double loadfactor = 0.75;
    private int increase = 16;
    private int count = 0;
    private Node<K, V>[] table = new Node[size];

   public boolean insert(K key, V value) {
       boolean result = false;
       Node<K, V> link = table[index(key)];
       if (link == null) {
           table[index(key)] = new Node(key, value);
           count++;
           return true;
       }
       if (link.getKey().equals(key)) {
           return false;
       }
       if (size * loadfactor <= count) {
           resize();
       }
       return result;
   }

   public boolean delete(K key) {
       boolean result = false;
       Node<K, V> link = table[index(key)];
       if (link != null && link.getKey().equals(key)) {
           table[index(key)] = null;
           result = true;
       } else {
           result = false;
       }
       return result;
   }

    public V get(K key) {
        V result = null;
        Node<K, V> link = table[index(key)];
        if (link != null && link.getKey().equals(key)) {
            result = link.getValue();
        }
        return result;
    }

    private int index(K key) {
       int result;
       result = (key == null) ? 0 : (key.hashCode() >>> 16) & (size - 1);
       return result;
   }

   private void resize() {
       size = size + increase;
       Node<K, V>[] resized = new Node[size];

       for (int i = 0; i < table.length; i++) {
           if (table[i] != null) {
               resized[index(table[i].getKey())] = table[i];
           }
       }
       table = resized;
       return;
   }


    @Override
    public Iterator<Node<K, V>> iterator() {
        return new Iterator<Node<K, V>>() {
            private int iterations = 0;
            private int index = 0;
            @Override
            public boolean hasNext() {
                return iterations < count;
            }

            @Override
            public Node<K, V> next() {
                Node result = null;
                while (index < table.length) {
                    result = table[index++];
                    if (result != null) {
                        iterations++;
                        break;
                    }
                }
                if (index >= table.length) {
                    throw new NoSuchElementException();
                }
                return result;
            }
        };
    }
}

class Node<K, V> {
    private int hashCode;
    private K key;
    private V value;

    public Node(K key, V value) {
        this.hashCode = key.hashCode();
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
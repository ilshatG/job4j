package ru.job4j.map;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import static org.junit.Assert.*;

public class HashTableArrayTest {
    HashTableArray<User, String> characters = new HashTableArray<>();
    User popandopulo = new User("Попандопуло из Одессы");
    User gricenyuk = new User("Пан атоман Грициан Таврический");
    User artilerist = new User("Бац-бац и мимо!");

    @Before
    public void init() {
        characters.insert(popandopulo, "Попандопуло");
        characters.insert(gricenyuk, "Таврический");
        characters.insert(artilerist, "Пуговкин");
    }

    @Test
    public void whenGetThenSequantianalValues() {
        assertThat(characters.get(gricenyuk), is("Таврический"));
        assertThat(characters.get(popandopulo), is("Попандопуло"));
        assertThat(characters.get(artilerist), is("Пуговкин"));
    }

    @Test
    public void whenDeleteThenGetReturnNull() {
        characters.delete(gricenyuk);
        assertThat(characters.get(gricenyuk), is((User) null));
    }

    @Test
    public void whenInsertExistingKeyReturnFalse() {
        assertThat(characters.insert(new User("Бац-бац и мимо!"), "Еще один артилерист Пуговкин"), is(false));
    }

    @Test
    public void hasNextNextSequentialInvocation() {
        Iterator<Node<User, String>> it = characters.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next().getKey().getName(), is("Попандопуло из Одессы"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next().getKey().getName(), is("Бац-бац и мимо!"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next().getKey().getName(), is("Пан атоман Грициан Таврический"));
        assertThat(it.hasNext(), is(false));
    }

    @Test(expected = NoSuchElementException.class)
    public void shoulThrowNoSuchElementException() {
        Iterator<Node<User, String>> it = characters.iterator();
        it.next();
        it.next();
        it.next();
        it.next();
    }
}

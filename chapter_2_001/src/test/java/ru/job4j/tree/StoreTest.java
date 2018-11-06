package ru.job4j.tree;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class StoreTest {
    List<Store.User> previous = new ArrayList<>();
    List<Store.User> current = new ArrayList<>();
    Store store = new Store();

    @Before
    public void init() {
        previous.add(new Store.User(1, "Juls"));
        previous.add(new Store.User(2, "Vincent Vega"));
        previous.add(new Store.User(3, "Marsellas Walles"));
        previous.add(new Store.User(4, "Mia Walles"));
        previous.add(new Store.User(5, "Walf"));
    }

    @Test
    public void whenEqualListsThen0() {
        current = previous;
        assertThat(store.diff(previous, current), is(new Info()));
    }

    @Test
    public void whenAddDeleteAndChangeGetAppropriateResult() {
        current.addAll(previous);
        current.add(new Store.User(6, "Butch"));
        current.set(2, new Store.User(2, "John Travolta"));
        current.remove(1);
        assertThat(store.diff(previous, current), is(new Info(1, 1, 1)));
    }
}

package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {
    @Test
    public void whenAdd3unsordedThen3Sorted() {
        List<User> users = new ArrayList<>();
        users.add(new User("Kate", 26));
        users.add(new User("Donald", 19));
        users.add(new User("Alex", 24));
        StringBuilder expect = new StringBuilder().append("[User{id=0, name='Donald', city='null'}, ");
        expect.append("User{id=0, name='Alex', city='null'}, ");
        expect.append("User{id=0, name='Kate', city='null'}]");
        assertThat(new SortUser().sort(users).toString(), is(expect.toString()));
    }
}
package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserConvertTest {
    @Test
    public void when3itemsThen3sortedItems() {
        List list = new ArrayList();
        list.add(new User(1, "Markel", "Anapa"));
        list.add(new User(0, "Seraphim", "Samara"));
        list.add(new User(71, "Maxim", "Philadelphia"));
        StringBuilder expect = new StringBuilder();
        expect.append("{");
        expect.append("0=User{id=0, name='Seraphim', city='Samara'}, ");
        expect.append("1=User{id=1, name='Markel', city='Anapa'}, ");
        expect.append("71=User{id=71, name='Maxim', city='Philadelphia'}");
        expect.append("}");
        assertThat(new UserConvert().process(list).toString(), is(expect.toString()));
    }
}
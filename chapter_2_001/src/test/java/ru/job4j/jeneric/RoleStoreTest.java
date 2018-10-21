package ru.job4j.jeneric;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class RoleStoreTest {
    RoleStore values;
    final static String ID_1 = "otets-feodor65";
    final static String ID_2 = "good-man455";
    final static String ID_3 = "maria-magdalena17";
    final static String ID_4 = "bad-motherfucker771";
    final static String ID_REPLACE = "replaced_id";

    @Before
    public void init() {
        values = new RoleStore();
        values.add(new Role(ID_1));
        values.add(new Role(ID_2));
        values.add(new Role(ID_3));
        values.add(new Role(ID_4));
    }

    @Test
    public void whenSearchingByIdReturnItsObject() {
        assertThat(values.findById(ID_1).getId(), is(ID_1));
        assertThat(values.findById(ID_2).getId(), is(ID_2));
    }

    @Test
    public void whenDeleteByIdThenCantFindIt() {
        assertThat(values.findById(ID_4).getId(), is(ID_4));
        assertThat(values.delete(ID_4), is(true));
        assertThat(values.delete(ID_4), is(false));
        assertThat(values.findById(ID_4), is((Base) null));
    }

    @Test
    public void whenReplaceSequential() {
        assertThat(values.replace(ID_4, new Role(ID_REPLACE)), is(true));
        assertThat(values.replace(ID_4, new Role(ID_REPLACE)), is(false));
        assertThat(values.findById(ID_4), is((Base) null));
    }
}
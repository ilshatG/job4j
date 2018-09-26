package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 *
 * @author Ilshat Gaifutdinov (mailto:ilshatrashidovich@ramble.ru)
 * @version $Id$
 * @since 0.1
 */
public class ValidateInputTest {
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    private final PrintStream out = System.out;

    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
    }

    @After
    public void loadSys() {
        System.setOut(this.out);
    }

    @Test
    public void whenInvalidRange() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[] {"invalid", "6"})
        );
        input.ask("Enter", new int[] {6});
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Неверные данные. Повторите ввод.%n")
                )
        );
    }

    @Test
    public void whenInvalidMenuNumber() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[] {"7", "6"})
        );
        input.ask("7", new int[] {6});
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Введите корректный пункт меню.%n")
                )
        );
    }

}
package ru.job4j.loop;

import org.junit.Test;
import java.util.StringJoiner;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author Petr Arsentev (mailto:parsentev@yandex.ru)
 * @author Ilshat Gaifutdinov (mailto:ilshatrashidovich@rambler.ru)
 * @since 0.1
 */
public class PaintTest {
    @Test
    public void whenPyramid4() {
        Paint paint = new Paint();
        String result = paint.pyramid(4);
        assertThat(result,
                is(
                        new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                                .add("   ^   ")
                                .add("  ^^^  ")
                                .add(" ^^^^^ ")
                                .add("^^^^^^^")
                                .toString()
                )
        );
    }

    @Test
    public void whenPyramid5() {
        Paint paint = new Paint();
        String result = paint.pyramid(5);
        assertThat(result,
                is(
                        new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                                .add("    ^    ")
                                .add("   ^^^   ")
                                .add("  ^^^^^  ")
                                .add(" ^^^^^^^ ")
                                .add("^^^^^^^^^")
                                .toString()
                )
        );
    }

}

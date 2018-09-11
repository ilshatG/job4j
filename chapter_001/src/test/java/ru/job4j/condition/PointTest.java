package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

public class PointTest {

    @Test
    public void whenFirstPoint0And0SecondPoint3And4Then5() {
        Point firstPoint = new Point(0, 0);
        Point secondPoint = new Point(3, 4);
        double result = secondPoint.distanceTo(firstPoint);
        assertThat(result, closeTo(5.0, 0.1));
    }

    @Test
    public void whenReverseCalculatingFirstPoint0And0SecondPoint3And4Then5() {
        Point firstPoint = new Point(0, 0);
        Point secondPoint = new Point(3, 4);
        double result = firstPoint.distanceTo(secondPoint);
        assertThat(result, closeTo(5.0, 0.1));
    }

    @Test
    public void whenFirstPoint0And0SecondPoint3And0Then3() {
        Point firstPoint = new Point(0, 0);
        Point secondPoint = new Point(3, 0);
        double result = secondPoint.distanceTo(firstPoint);
        assertThat(result, closeTo(3.0, 0.1));
    }


}
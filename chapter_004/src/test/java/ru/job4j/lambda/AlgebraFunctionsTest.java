package ru.job4j.lambda;

import org.junit.Test;


import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.MatcherAssert.assertThat;

public class AlgebraFunctionsTest {
    List result;
    AlgebraFunctions algebra = new AlgebraFunctions();

    @Test
    public void whenLinearFunctionThen4values() {
        result = algebra.diapason(0, 3, x->2 * x);
        assertThat(result, is(Arrays.asList(0D, 2D, 4D, 6D)));
    }

    @Test
    public void whenQuadraticFunctionThen4values() {
        result = algebra.diapason(0, 3, x->x * x);
        assertThat(result, is(Arrays.asList(0D, 1D, 4D, 9D)));
    }

    @Test
    public void whenLogarithmicFunctionThen4values() {
        result = algebra.diapason(1, 4, x -> (double) Math.round(Math.log(x) * 10) / 10);
        assertThat(result, is(Arrays.asList(0D, 0.7D, 1.1D, 1.4D)));
    }

}
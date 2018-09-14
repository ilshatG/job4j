package ru.job4j.calculator;

/**
 * Calculator.
 * Объект данного классна создается для выполнения арифметических операций.
 * @author Ilshat Gaifutdinov
 * @version 0.1
 * @since 0.1
 */
public class Calculator {

    private double result;
    /**
     * Арифметически складывает два значения.
     * @param first первый параметр.
     * @param second второй параметр.
     * @author Ilshat Gaifutdinov
     * @since 0.1
     */

    public void add(double first, double second) {
        this.result = first + second;
    }
    /**
     * Арифметически вычитает из первого значения второе.
     * @param first первый параметр.
     * @param second второй параметр.
     * @author Ilshat Gaifutdinov
     * @since 0.1
     */

    public void subtract(double first, double second) {
        this.result = first - second;
    }
    /**
     * Производит арифметическую оперецию деления.
     * @param first первый параметр.
     * @param second второй параметр.
     * @author Ilshat Gaifutdinov
     * @since 0.1
     */

    public void div(double first, double second) {
        this.result = first / second;
    }
    /**
     * Производит арифметическую оперецию умножения.
     * @param first первый параметр.
     * @param second второй параметр.
     * @author Ilshat Gaifutdinov
     * @since 0.1
     */

    public void multiple(double first, double second) {
        this.result = first * second;
    }
    /**
     * @return результат послендней выполненной арифметической операции посредством вызова
     * одного из соответствующих методов данного объекта
     */
    public double getResult() {
        return this.result;
    }

}

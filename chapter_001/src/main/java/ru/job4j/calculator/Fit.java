package ru.job4j.calculator;

/**
 * Программа расчета идеального веса.
 */
public class Fit {
    //Коэффициент массы тела
    private final double weightRatio = 1.15D;

    /**
     * Идеальный вес для мужщины.
     * @param height Рост.
     * @return идеальный вес.
     */
    public double manWeight(double height) {
        return (height - 100) * weightRatio;
    }

    /**
     * Идеальный вес для женщины.
     * @param height Рост.
     * @return идеальный вес.
     */
    public double womanWeight(double height) {
        return (height - 110) * weightRatio;
    }
}

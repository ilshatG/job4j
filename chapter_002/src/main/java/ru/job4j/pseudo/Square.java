package ru.job4j.pseudo;

/**
 * @author Ilshat Gaifutdinov
 * @version 0.1
 * @since 0.1
 */
public class Square implements Shape {
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("+++++++");
        pic.append(System.lineSeparator());
        pic.append("+     +");
        pic.append(System.lineSeparator());
        pic.append("+     +");
        pic.append(System.lineSeparator());
        pic.append("+++++++");
        return pic.toString();
    }
}
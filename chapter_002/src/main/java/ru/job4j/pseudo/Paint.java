package ru.job4j.pseudo;

/**
 * @author Ilshat Gaifutdinov
 * @version 0.1
 * @since 0.1
 */
public class Paint {
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }

    public static void main(String[] args) {
        Paint picture = new Paint();
        picture.draw(new Triangle());
        picture.draw(new Square());
    }
}

package ru.job4j.threads.pingpong;
/*
import javafx.scene.shape.Rectangle;

public class RectangleMove implements Runnable {
    private Rectangle bounds;
    private final Rectangle rect;

    public RectangleMove(Rectangle rect) {
        this.rect = rect;
    }

    public RectangleMove(Rectangle rect, Rectangle bounds) {
        this.bounds = bounds;
        this.rect = rect;
    }

    @Override
    public void run() {
        double dx = 1;
        double dy = 0.3;
        double x = this.rect.getX();
        double y = this.rect.getY();
        while (!Thread.currentThread().isInterrupted()) {
            x = x + dx;
            y = y + dy;
            this.rect.setX(x);
            this.rect.setY(y);
            if (isBumped()) {
                if ((this.rect.getX() > bounds.getWidth()) || (this.rect.getX() < 0)) {
                    dx = dx * -1;
                } else {
                    dy = dy * -1;
                }
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private boolean isBumped() {
        return (this.rect.getX() > bounds.getWidth()) || (this.rect.getX() < 0) || (this.rect.getY() > bounds.getHeight()) || (this.rect.getY() < 0);
    }
}*/
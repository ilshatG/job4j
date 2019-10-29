package ru.job4j.threads.bomberman;


public class BomberMan {
    private final Board board = new Board(5, 6);
    private final Hero hero = new Hero(board);
    private final Visual vision = new Visual(board);

    public static void main(String[] args) throws InterruptedException{

        BomberMan bomberMan = new BomberMan();

        Thread heroThread = new Thread(() -> {
            bomberMan.hero.setToRandomCell();
            while(true) {
                bomberMan.hero.move(Directions.random());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread visualizeThread = new Thread(() -> {
            while (true) {
                bomberMan.vision.visualize();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        heroThread.start();
        visualizeThread.start();
    }
}

package ru.job4j.threads.bomberman;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


import java.util.concurrent.atomic.AtomicInteger;


public class Visual extends JFrame {
    private final JFrame screen = new JFrame();
    private final java.util.List<JPanel> boxes = new ArrayList<>();
    private final Board board;

    public Visual (Board board) {
        this.board = board;
        JPanel mainPanel = new JPanel(new BorderLayout());
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setSize(new Dimension(1000, 500));
        screen.setTitle("Bomberman");
        mainPanel.setLayout(new GridLayout(board.getHeight(), board.getWidth()));
        screen.add(mainPanel);
        for(int i = 0; i < board.stream().count(); i++) {
            JPanel panel = new JPanel();
            panel.setPreferredSize(new Dimension(100, 100));
            panel.setBorder(BorderFactory.createLineBorder(Color.gray));
            mainPanel.add(panel);
            boxes.add(panel);
        }
        visualize();
        screen.pack();
        screen.setVisible(true);

    }

    public void visualize() {
        final AtomicInteger i = new AtomicInteger(0);
        board.stream().forEach((x) -> {
            if(x.isLocked()) {
                boxes.get(i.getAndIncrement()).setBackground(Color.yellow);
            } else {
                boxes.get(i.getAndIncrement()).setBackground(Color.lightGray);
            }
        });
    }

}
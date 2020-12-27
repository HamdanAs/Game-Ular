package com.hamdan.display;

import javax.swing.*;
import java.awt.*;

public class Display {

    private JFrame frame;
    private Canvas canvas;

    private int width, height;
    private String title;

    private static Display instance = new Display();

    private Display() {

    }

    public void show(){
        frame = new JFrame();
        frame.setTitle(getTitle());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(getWidth(), getHeight()));
        canvas.setFocusable(false);

        frame.add(canvas);
        frame.pack();

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // GETTERS AND SETTERS

    public static Display getInstance(){
        return instance;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    public JFrame getFrame() {
        return frame;
    }

    public Canvas getCanvas() {
        return canvas;
    }
}

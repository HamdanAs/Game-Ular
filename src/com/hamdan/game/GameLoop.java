package com.hamdan.game;

import com.hamdan.display.Display;
import com.hamdan.map.Map;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class GameLoop implements Runnable{
    private boolean running = false;

    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;
    Display d = Display.getInstance();

    private void init(){
        d.setTitle("Ular");
        d.setWidth(640);
        d.setHeight(360);
        d.show();
    }

    public void tick(){

    }

    public void render(){
        bs = d.getCanvas().getBufferStrategy();
        if(bs == null){
            d.getCanvas().createBufferStrategy(3);
            return;
        }

        g = bs.getDrawGraphics();
        g.clearRect(0, 0, d.getWidth(), d.getHeight());

        //Draw Here!

        Map.setBackgroundColor(d.getCanvas(), Color.green);
        Map.drawMap(g);

        //End Draw!

        bs.show();
        g.dispose();
    }

    @Override
    public void run() {

        init();

        int fps = 25;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while(running){
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if (delta >= 1){
                tick();
                render();
                ticks++;
                delta--;
            }

            if (timer >= 1000000000){
                System.out.println("Ticks and Frames : " + ticks);
                ticks = 0;
                timer = 0;
            }
        }
    }

    public synchronized void start(){
        if (running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop(){
        if (!running)
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

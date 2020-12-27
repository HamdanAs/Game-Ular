package com.hamdan.map;

import com.hamdan.display.Display;

import java.awt.*;

public class Map {

    public static void drawMap(Graphics g){
        int blockWidth = 20, blockHeight = 20;

        Display d = Display.getInstance();
        g.setColor(Color.black);
        for(int i = 0; i <= d.getWidth(); i += blockWidth){
            for(int j = 0; j <= d.getHeight(); j += blockHeight) {
                if (i == 0) {
                    g.fillRect(i, j, blockWidth, blockHeight);
                } else if (i == d.getWidth() - blockWidth) {
                    g.fillRect(i, j, blockWidth, blockHeight);
                } else if(j == 0) {
                    g.fillRect(i, j, blockWidth, blockHeight);
                } else if(j == d.getHeight() - blockHeight){
                    g.fillRect(i, j, blockWidth, blockHeight);
                } else {
                    continue;
                }
            }
        }
    }

    public static void setBackgroundColor(Canvas canvas, Color c){
        canvas.setBackground(c);
    }

}

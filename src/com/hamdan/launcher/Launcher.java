package com.hamdan.launcher;

import com.hamdan.display.Display;
import com.hamdan.game.GameLoop;

public class Launcher {
    public static void main(String[] args) {
        GameLoop game = new GameLoop();
        game.start();
    }
}

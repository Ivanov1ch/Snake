/*
// File:             Game.java
// Created:          2018/06/18
// Author:           danIv (Daniel Ivanovich)
// Description:      Creates a new Window and runs it.
*/

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Game {
    public static void main(String[] args) {
        final Color[] GRID_COLORS = {Color.gray, Color.BLACK, Color.BLACK}; //BG, Lines, Border
        ImageIcon image = null;
        Window window = null;

        while(true) {
            try {
                URL url = new URL("https://techviral.net/wp-content/uploads/2017/02/Now-You-Can-Play-The-Nokia-3310s-Iconic-Snake-Game-On-Facebook-Messenger.png");
                if(image == null)
                    image = new ImageIcon(ImageIO.read(url));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Object[] options = {"Play Game", "How to Play", "Quit"};

            int choice = -9999;

            if(window == null)
                choice = JOptionPane.showOptionDialog(null, "", "", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, image, options, options[0]);

            if (choice == JOptionPane.YES_OPTION) {
                window = new Window(GRID_COLORS);
                window.start();
            } else if (choice == JOptionPane.NO_OPTION) {
                howToPlay();
            } else if(choice != -9999) {
                System.exit(0);
            }
        }
    }

    public static void howToPlay(){
        JOptionPane.showMessageDialog(null, "The objective of Snake is to grow as large as you can.\nEating food will make you grow.\n\nMove around with the Arrow Keys or WASD\nPress Space to Pause\nPress Escape to exit\n\nIf you overlap yourself or go out of bounds, you lose!", "How to play Snake", JOptionPane.QUESTION_MESSAGE);
    }
}

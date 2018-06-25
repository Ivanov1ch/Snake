/*
// File:             Window.java
// Created:          2018/06/18
// Author:           danIv (Daniel Ivanovich)
// Description:      The class for the JFrame. It initializes the GamePanel.
*/

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    private GamePanel panel;

    public Window(Color[] gridColors, Color snakeColor){
        setTitle("Snake");
        setSize(700, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container pane = getContentPane();
        panel = new GamePanel(this, gridColors, snakeColor);
        pane.add(panel);

        setUndecorated(false);
        setResizable(false);
    }

    public void start(){
        pack();
        setVisible(true);
    }

    public void stop(){
        setVisible(false);
        panel.stopMusic();
    }

    public GamePanel getPanel(){
        return panel;
    }
}

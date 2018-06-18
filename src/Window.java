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

    public Window(){
        setTitle("Pong");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container pane = getContentPane();
        panel = new GamePanel(this);
        pane.add(panel);

        setUndecorated(false);
        setResizable(false);
    }

    public void start(){
        pack();
        setVisible(true);
    }

    public GamePanel getPanel(){
        return panel;
    }
}

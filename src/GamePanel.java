/*
// File:             GamePanel.java
// Created:          2018/06/18
// Author:           danIv (Daniel Ivanovich)
// Description:      The panel that runs the game and deals with keyboard input.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;

public class GamePanel extends JPanel {
    private Timer timer;
    private Window window;
    private int width, height;
    private final int REFRESH_RATE = 375;
    private Color[] gridColors;
    private Grid grid;
    private Snake snake;
    private FoodController foodController;
    private GameOverRectangle gameOverRectangle = null;
    private boolean gameOver = false;

    public GamePanel(Window window, Color[] gridColors) {
        this.window = window;
        this.height = window.getHeight();
        this.width = window.getWidth();

        this.gridColors = gridColors;
        setBackground(gridColors[0]);

        setPreferredSize(new Dimension(width, height));
        setFocusable(true);

        timer = new javax.swing.Timer(REFRESH_RATE, new AnimationListener());
        timer.start();
        addKeyListener(new UserKeyboardListener());

        grid = new Grid(window, this.gridColors);
        snake = new Snake(5, grid);

        foodController = new FoodController(window, grid);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        grid.drawGrid(g);
        snake.draw(g);
        foodController.drawFood(g);
        grid.drawOverlappingGridLines(g);
        if (gameOverRectangle != null)
            gameOverRectangle.draw(g);
    }

    public class AnimationListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            snake.move();

            if (snake.isGameOver())
                gameOver();

            foodController.collectFood(snake);

            if (foodController.amountOfFoodOnGrid() <= 1)
                foodController.spawnFood(snake);

            repaint();
        }
    }


    public class UserKeyboardListener implements KeyListener {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                System.exit(0);
            } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                if (!gameOver) {
                    if (timer.isRunning()) {
                        timer.stop();
                    } else
                        timer.restart();
                } else {
                    if (gameOverRectangle != null && gameOverRectangle.isRevealed()) {
                        resetSnake();
                    }
                }
            } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                snake.setDirection(90);
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                snake.setDirection(270);
            } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                snake.setDirection(180);
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                snake.setDirection(0);
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }

        @Override
        public void keyTyped(KeyEvent e) {
        }
    }

    private void gameOver() {
        timer.stop();
        gameOverRectangle = new GameOverRectangle(window);
        gameOverRectangle.reveal();
        gameOver = true;
    }

    private void resetSnake() {
        timer = null; //Destroy the old Timer
        timer = new javax.swing.Timer(REFRESH_RATE, new AnimationListener());
        timer.start();

        grid = null;  //Destroy the old Grid
        grid = new Grid(window, this.gridColors);

        snake = null; //Destroy the old snake (with garbage collection)
        snake = new Snake(5, grid);

        foodController = null; //Destroy the old FoodController
        foodController = new FoodController(window, grid);

        gameOver = false;

        gameOverRectangle = null;
        gameOverRectangle = new GameOverRectangle(window);
    }
}

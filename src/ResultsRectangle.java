/*
// File:             ResultsRectangle.java
// Created:          2018/06/19
// Author:           danIv (Daniel Ivanovich)
// Description:      The rectangle with text that appears when the game ends, displaying if the user won or lost, and their score.
*/

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class ResultsRectangle {
    private int opacity;
    private Window game;
    private boolean isRevealed = false, gameOver;
    private Snake snake;

    public ResultsRectangle(Window game, Snake snake, boolean gameOver) {
        this.opacity = 0;
        this.game = game;
        this.gameOver = gameOver;
        this.snake = snake;
    }

    public void draw(Graphics g) {
        Color oldColor = g.getColor();

        g.setColor(new Color(255, 255, 255, opacity));
        g.fillRect(0, 0, game.getWidth(), game.getHeight());

        g.setColor(new Color(255, 0, 0, opacity));

        Font oldFont = g.getFont();

        //Load the custom font (from http://www.java2s.com/Tutorials/Java/Graphics_How_to/Font/Load_font_from_ttf_file.htm)
        String fName = "Fonts/PressStart2P.ttf";
        InputStream is = ResultsRectangle.class.getResourceAsStream(fName);

        Font newFont = null;

        try {
            newFont = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch(FontFormatException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

        //Change font size
        if(newFont != null)
            g.setFont(new Font(newFont.getName(), Font.PLAIN, 32));
        else
            g.setFont(new Font(oldFont.getName(), Font.PLAIN, 32));


        if (gameOver)
            drawCenteredString(g, "GAME OVER!", 0, game.getWidth(), 100, 200);
        else
            drawCenteredString(g, "You Win!", 0, game.getWidth(), 100, 200);

        //Change font size
        if(newFont != null)
            g.setFont(new Font(newFont.getName(), Font.PLAIN, 26));
        else
            g.setFont(new Font(oldFont.getName(), Font.PLAIN, 26));

        drawCenteredString(g, "Your score was: " + snake.getLength(), 0, game.getWidth(), 350, 150);

        drawCenteredString(g, "Press Space to Continue...", 0, game.getWidth(), 550, 150);


        g.setFont(oldFont);

        g.setColor(oldColor);
    }


    //Code inspired by https://stackoverflow.com/questions/27706197/how-can-i-center-graphics-drawstring-in-java
    public void drawCenteredString(Graphics g, String text, int topRightX, int width, int topRightY, int height) {
        // Get the FontMetrics
        FontMetrics metrics = g.getFontMetrics(g.getFont());
        // Determine the X coordinate for the text
        int x = topRightX + (width - metrics.stringWidth(text)) / 2;
        // Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
        int y = topRightY + ((height - metrics.getHeight()) / 2) + metrics.getAscent();
        // Draw the String
        g.drawString(text, x, y);
    }


    public void reveal() {
        this.opacity = 255;
        this.isRevealed = true;
    }

    public boolean isRevealed() {
        return isRevealed;
    }
}

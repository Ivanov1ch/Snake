/*
// File:             GameOverRectangle.java
// Created:          2018/06/19
// Author:           danIv (Daniel Ivanovich)
// Description:      The rectangle with text that fades in when the game ends.
*/

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class GameOverRectangle {
    private int opacity;
    private Window game;
    private boolean isRevealed = false;

    public GameOverRectangle(Window game){
        this.opacity = 0;
        this.game = game;
    }

    public void draw(Graphics g){
        Color oldColor = g.getColor();

        g.setColor(new Color(255, 255, 255, opacity));
        g.fillRect(0, 0, game.getWidth(), game.getHeight());

        g.setColor(Color.red);

        Font oldFont = g.getFont();

        g.setFont(new Font(oldFont.getName(), Font.PLAIN, 32));

        g.drawString("GAME OVER!", 250, 260);

        g.setFont(new Font(oldFont.getName(), Font.PLAIN, 26));

        g.drawString("Press Space To Continue...", 250, 400);


        g.setFont(oldFont);

        g.setColor(oldColor);
    }

    public void reveal(){
        this.opacity = 255;
        this.isRevealed =  true;
    }

    public boolean isRevealed(){
        return isRevealed;
    }
}

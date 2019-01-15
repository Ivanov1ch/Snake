/*
// File:             AudioManager.java
// Created:          2018/06/21
// Author:           danIv (Daniel Ivanovich)
// Description:      This class manages the playing of all music and sound effects.
*/

import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;

public class AudioManager {

    //Code written based on tutorial (https://www.ntu.edu.sg/home/ehchua/programming/java/J8c_PlayingSound.html)

    private Clip backgroundMusic = null;
    private Clip gameOverMusic = null;
    private Clip victoryMusic = null;

    public void playFoodCollectedSound(){
        try {
            // Open an audio input stream.
            URL url = this.getClass().getClassLoader().getResource("Audio/Chomp.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            // Get a sound clip resource.
            Clip clip = AudioSystem.getClip();
            // Open audio clip and load samples from the audio input stream.
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void startBackgroundMusic(){
        try {
            // Open an audio input stream.
            URL url = this.getClass().getClassLoader().getResource("Audio/Background Music.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            // Get a sound clip resource.
            backgroundMusic = AudioSystem.getClip();
            // Open audio clip and load samples from the audio input stream.
            backgroundMusic.open(audioIn);
            backgroundMusic.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void stopBackgroundMusic(){
        if (backgroundMusic != null && backgroundMusic.isRunning()) backgroundMusic.stop();
    }

    public void startGameOverMusic(){
        try {
            // Open an audio input stream.
            URL url = this.getClass().getClassLoader().getResource("Audio/Game Over.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            // Get a sound clip resource.
            gameOverMusic = AudioSystem.getClip();
            // Open audio clip and load samples from the audio input stream.
            gameOverMusic.open(audioIn);
            gameOverMusic.start();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void stopGameOverMusic(){
        if (gameOverMusic != null && gameOverMusic.isRunning()) gameOverMusic.stop();
    }

    public void startVictoryMusic(){
        try {
            // Open an audio input stream.
            URL url = this.getClass().getClassLoader().getResource("Audio/Victory.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            // Get a sound clip resource.
            victoryMusic = AudioSystem.getClip();
            // Open audio clip and load samples from the audio input stream.
            victoryMusic.open(audioIn);
            victoryMusic.start();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void stopVictorymusic(){
        if (victoryMusic != null && victoryMusic.isRunning()) victoryMusic.stop();
    }
}

/*
This is a simple music player class
 */
package music.player.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 *
 * @author ISSA-PC
 */
public class MusicPlayer {

    // Var Init
    private static FileInputStream fileInputStream;
    private static BufferedInputStream bufferdInputStream;
    private static Player player;
    private static long pausedLocation;
    private static long songLength;
    private static String fileLocation;
    private static Thread thread;
    private static String songName;

    public static void playSong(String path) { // Play a song

        if (player == null) { // in case the player is not playing 
            try {

                fileLocation = path;
                fileInputStream = new FileInputStream(path);
                songName = new File(path).getName(); // Get File Name
                bufferdInputStream = new BufferedInputStream(fileInputStream);
                player = new Player(bufferdInputStream);
                songLength = fileInputStream.available();

                thread = new Thread(() -> { // Play Song
                    try {
                        player.play();
                    } catch (JavaLayerException ex) {
                        Logger.getLogger(MusicPlayer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
                thread.start(); // start thread

            } catch (FileNotFoundException | JavaLayerException ex) {
                Logger.getLogger(MusicPlayer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(MusicPlayer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public static void stopSong() { // stop song

        if (player != null) { // if the player is playing
            player.close();
            player = null;
            thread = null;
        }

    }

    public static void pausedSong() { // Pause player

        try {
            pausedLocation = fileInputStream.available();
            player.close();
            thread = null;
            player = null;
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "The song is already paused !");
        }
    }

    public static void resumeSong() { // resume song after pause
        if (player == null) { // if the player is not playing
            try {

                fileInputStream = new FileInputStream(fileLocation);
                bufferdInputStream = new BufferedInputStream(fileInputStream);
                player = new Player(bufferdInputStream);
                fileInputStream.skip(songLength - pausedLocation); // calculate the paused location --> Total length - time left till song end

                new Thread(() -> { // start song
                    try {
                        player.play();
                    } catch (JavaLayerException ex) {
                        Logger.getLogger(MusicPlayer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }).start(); // start thread

            } catch (FileNotFoundException | JavaLayerException ex) {
                Logger.getLogger(MusicPlayer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(MusicPlayer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public static String getSongName() {
        return songName;
    }

    public static boolean getPlayerState() {

        if (player == null) {
            return false;
        } else {
            return true;
        }
    }
}

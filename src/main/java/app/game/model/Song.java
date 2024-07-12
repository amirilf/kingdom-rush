package app.game.model;

import javafx.application.Platform;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.net.URL;

public class Song extends Thread {

    private static MediaPlayer mediaPlayer;
    private static boolean mute = false;
    private URL mediaUrl;

    public Song(String filePath) {
        this.mediaUrl = getClass().getResource(filePath);
    }

    public static void setMute(boolean mute) {
        Song.mute = mute;
        if (mediaPlayer != null) {
            Platform.runLater(() -> mediaPlayer.setMute(Song.mute));
        }
    }

    public static boolean isMute() {
        return mute;
    }

    @Override
    public void run() {

        if (mediaUrl == null) {
            System.err.println("Media file not found: " + mediaUrl);
            return;
        }

        Media media = new Media(mediaUrl.toString());
        mediaPlayer = new MediaPlayer(media);

        // Apply initial mute setting
        Platform.runLater(() -> mediaPlayer.setMute(mute));

        mediaPlayer.play();

        mediaPlayer.setOnEndOfMedia(() -> {
            mediaPlayer.seek(mediaPlayer.getStartTime());
            mediaPlayer.play();
        });

        // Listen for changes to the mute field
        new Thread(() -> {
            while (true) {
                if (mute != mediaPlayer.isMute()) {
                    Platform.runLater(() -> mediaPlayer.setMute(mute));
                }
                try {
                    Thread.sleep(100); // Adjust sleep time as needed
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

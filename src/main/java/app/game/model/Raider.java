package app.game.model;

import java.util.Random;

import javafx.animation.PathTransition;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Path;
import javafx.util.Duration;

public class Raider extends Thread {

    // IMAGES
    private static Image imageDead;
    private ImageView imageView;

    // PATH
    private Path path;
    private PathTransition transition; // will be created in move method!

    private int health;
    private boolean isAlive;
    private int speed;
    private int loot;
    private int damage;

    public Raider(Image image, Path path, int health, int speed, int loot) {
        this.imageView = new ImageView(image);
        this.imageView.setFitHeight(50);
        this.imageView.setFitWidth(50);
        this.path = path;
        this.health = health;
        this.isAlive = true;
        this.speed = speed;
        this.loot = loot;
    }

    static {
        // load the "dead" image once for all heros
        imageDead = new Image(Raider.class.getResourceAsStream("/app/game/media/test/2.png"));
    }

    // METHODS
    @Override
    public void run() {
        move();
    }

    public void move() {

        transition = new PathTransition();
        transition.setDuration(Duration.seconds(10)); // depends on the speed!
        transition.setPath(path);
        transition.setNode(imageView);
        transition.setCycleCount(1); // just one cycle for each raider
        transition.play();

        transition.setOnFinished(event -> {
            if (isAlive) {
                System.out.println("It's alive!");
                // it's reached to the end point and should reduce the heart!
                // depends on the damage!
            }
        });

        while (isAlive && health > 0) {
            try {
                Thread.sleep(1000); // checking period time!
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            health -= new Random().nextInt(0, 10); // just random damage!
            if (health <= 0) {
                die();
            }
        }
    }

    public void die() {
        isAlive = false;
        Platform.runLater(() -> {
            System.out.println("It's dead!");
            // should change the raider image to dead and then remove from anchor!
            imageView.setImage(imageDead); // must be animation to be dead like a red cross
            transition.stop();
        });
    }

    // GETTER SETTER

    public static Image getImageDead() {
        return imageDead;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public Path getPath() {
        return path;
    }

    public PathTransition getTransition() {
        return transition;
    }

    public int getHealth() {
        return health;
    }

    public boolean getIsAlive() {
        return isAlive;
    }

    public int getDamage() {
        return damage;
    }

    public int getLoot() {
        return loot;
    }

    public int getSpeed() {
        return speed;
    }

    public static void setImageDead(Image imageDead) {
        Raider.imageDead = imageDead;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public void setTransition(PathTransition transition) {
        this.transition = transition;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setLoot(int loot) {
        this.loot = loot;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

}

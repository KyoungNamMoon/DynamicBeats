package testClass.dynamic_beat_1;

import dynamic_beat_1.Track;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Objects;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
public class DynamicBeat extends JFrame {
    //IntroBackground
    private Image screenImage;
    private Graphics screenGraphic;
    private Image introBackground = new ImageIcon(Objects.requireNonNull(Main.class.getResource("../image/background/gameGround"))).getImage();

    public DynamicBeat() {
        setTitle("Dynamic Beat");
        setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);



        Music introMusic = new Music("star.mp3", true);
        introMusic.start();
        //add 3 track



    }

    public void paint(Graphics g) {
        screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        screenGraphic = screenImage.getGraphics();
        screenDraw(screenGraphic);
        g.drawImage(screenImage, 0, 0, null);
    }
    public void screenDraw(Graphics g) {
        g.drawImage(introBackground, 0, 0, null);
        this.repaint();
    }

}

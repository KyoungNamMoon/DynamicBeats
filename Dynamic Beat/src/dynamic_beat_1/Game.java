package dynamic_beat_1;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Game extends Thread {
    private Image gameInfoImage = new ImageIcon(Main.class.getResource("../image/game/gameInfo.png")).getImage();
    private Image gameLine = new ImageIcon(Main.class.getResource("../image/game/gameLine.png")).getImage();
    private Image separateLine = new ImageIcon(Main.class.getResource("../image/game/separateLine.png")).getImage();
    private Image noteRouteSImage = new ImageIcon(Main.class.getResource("../image/game/line.png")).getImage();
    private Image noteRouteDImage = new ImageIcon(Main.class.getResource("../image/game/line.png")).getImage();
    private Image noteRouteFImage = new ImageIcon(Main.class.getResource("../image/game/line.png")).getImage();
    private Image noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../image/game/line.png")).getImage();
    private Image noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../image/game/line.png")).getImage();
    private Image noteRouteJImage = new ImageIcon(Main.class.getResource("../image/game/line.png")).getImage();
    private Image noteRouteKImage = new ImageIcon(Main.class.getResource("../image/game/line.png")).getImage();
    private Image noteRouteLImage = new ImageIcon(Main.class.getResource("../image/game/line.png")).getImage();


    private String titleName;
    private String difficulty;
    private String musicTitle;
    private Music gameMusic;

    ArrayList<Note> noteList = new ArrayList<Note>();


    public Game(String titleName, String difficulty, String musicTitle)
    {
        this.titleName = titleName;
        this.difficulty = difficulty;
        this.musicTitle = musicTitle;
        gameMusic = new Music(this.musicTitle, false);

    }



    public void screenDraw(Graphics2D g) {
        g.drawImage(noteRouteSImage, 228, 30, null);
        g.drawImage(noteRouteDImage, 332, 30, null);
        g.drawImage(noteRouteFImage, 436, 30, null);
        g.drawImage(noteRouteSpace1Image, 540, 30, null);
        g.drawImage(noteRouteSpace2Image, 640, 30, null);
        g.drawImage(noteRouteJImage, 744, 30, null);
        g.drawImage(noteRouteKImage, 848, 30, null);
        g.drawImage(noteRouteLImage, 952, 30, null);


        g.drawImage(separateLine, 224, 30, null);
        g.drawImage(separateLine, 328, 30, null);
        g.drawImage(separateLine, 432, 30, null);
        g.drawImage(separateLine, 536, 30, null);
        g.drawImage(separateLine, 740, 30, null);
        g.drawImage(separateLine, 844, 30, null);
        g.drawImage(separateLine, 948, 30, null);
        g.drawImage(separateLine, 1052, 30, null);
        g.drawImage(gameInfoImage, 0, 660, null);
        g.drawImage(gameLine, 0, 580, null);
        for(int i = 0; i < noteList.size(); i++)
        {
            Note note = noteList.get(i);
            note.screenDraw(g);
        }
        g.setColor(Color.WHITE);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.drawString(titleName, 20, 702);
        g.drawString(difficulty,1190, 702);
        g.setFont(new Font("Arial", Font.PLAIN, 26));
        g.setColor(Color.DARK_GRAY);
        g.drawString("S",270,609);
        g.drawString("D",374,609);
        g.drawString("F",478,609);
        g.drawString("Space Bar",580,609);
        g.drawString("J",784,609);
        g.drawString("K",889,609);
        g.drawString("L",993,609);
        g.setColor(Color.LIGHT_GRAY);
        g.setFont(new Font("Elephant", Font.BOLD, 30));
        g.drawString("000000", 565,702);



    }
    public void pressS()
    {
        noteRouteSImage = new ImageIcon(Main.class.getResource("../image/game/keyTouched.png")).getImage();
        new Music("drum1.mp3", false).start();
    }
    public void releasedS()
    {
        noteRouteSImage = new ImageIcon(Main.class.getResource("../image/game/line.png")).getImage();
    }
    public void pressD()
    {
        noteRouteDImage = new ImageIcon(Main.class.getResource("../image/game/keyTouched.png")).getImage();
        new Music("drum1.mp3", false).start();

    }
    public void releasedD()
    {
        noteRouteDImage = new ImageIcon(Main.class.getResource("../image/game/line.png")).getImage();
    }
    public void pressF()
    {
        noteRouteFImage = new ImageIcon(Main.class.getResource("../image/game/keyTouched.png")).getImage();
        new Music("drum1.mp3", false).start();

    }
    public void releasedF()
    {
        noteRouteFImage = new ImageIcon(Main.class.getResource("../image/game/line.png")).getImage();
    }
    public void pressSpace()
    {
        noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../image/game/keyTouched.png")).getImage();
        noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../image/game/keyTouched.png")).getImage();
        new Music("drum2.mp3", false).start();

    }
    public void releasedSpace()
    {
        noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../image/game/line.png")).getImage();
        noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../image/game/line.png")).getImage();

    }
    public void pressJ()
    {
        noteRouteJImage = new ImageIcon(Main.class.getResource("../image/game/keyTouched.png")).getImage();
        new Music("drum1.mp3", false).start();
    }
    public void releasedJ()
    {
        noteRouteJImage = new ImageIcon(Main.class.getResource("../image/game/line.png")).getImage();
    }
    public void pressK()
    {
        noteRouteKImage = new ImageIcon(Main.class.getResource("../image/game/keyTouched.png")).getImage();
        new Music("drum1.mp3", false).start();
    }
    public void releasedK()
    {
        noteRouteKImage = new ImageIcon(Main.class.getResource("../image/game/line.png")).getImage();
    }
    public void pressL()
    {
        noteRouteLImage = new ImageIcon(Main.class.getResource("../image/game/keyTouched.png")).getImage();
        new Music("drum1.mp3", false).start();
    }
    public void releasedL()
    {
        noteRouteLImage = new ImageIcon(Main.class.getResource("../image/game/line.png")).getImage();
    }

    @Override
    public void run()
    {
        dropNotes();

    }
    public void close()
    {
        gameMusic.close();
        this.interrupt();
    }

    public void dropNotes()
    {
        Beat[] beat = null;
        if(titleName.equals("yourname"))
        {
            int startTime = 4460 - Main.REACH_TIME;
            int gap = 125;
            beat = new Beat[] {
                    new Beat(startTime + gap * 1, "S"),
                    new Beat(startTime + gap * 3, "D"),
                    new Beat(startTime + gap * 5, "F"),
                    new Beat(startTime + gap * 7, "S"),
                    new Beat(startTime + gap * 9, "D"),
                    new Beat(startTime + gap * 11, "F"),
                    new Beat(startTime + gap * 13, "S"),
                    new Beat(startTime + gap * 15, "D"),
                    new Beat(startTime + gap * 18, "F"),
                    new Beat(startTime + gap * 20, "S"),
                    new Beat(startTime + gap * 22, "D"),
                    new Beat(startTime + gap * 24, "F"),
                    new Beat(startTime + gap * 26, "S"),
                    new Beat(startTime + gap * 28, "D"),
                    new Beat(startTime + gap * 30, "F"),
                    new Beat(startTime + gap * 32, "S"),
                    new Beat(startTime + gap * 35, "D"),
                    new Beat(startTime + gap * 37, "F"),
                    new Beat(startTime + gap * 39, "S"),
                    new Beat(startTime + gap * 41, "D"),
                    new Beat(startTime + gap * 43, "F"),
                    new Beat(startTime + gap * 50, "Space"),
                    new Beat(startTime + gap * 50, "Space"),



            };
        }
        else if (titleName.equals("goodNight"))
        {
            int startTime = 1000 - Main.REACH_TIME;
            beat = new Beat[] {
                    new Beat(startTime, "Space"),
            };
        }
        else if (titleName.equals("confess"))
        {
            int startTime = 1000 - Main.REACH_TIME;
            beat = new Beat[] {
                    new Beat(startTime, "Space"),
            };
        }
        int i = 0;
        gameMusic.start();
        while(i < beat.length && !isInterrupted())
        {
            boolean dropped = false;
            if(beat[i].getTime() <= gameMusic.getTime()) {
                Note note = new Note(beat[i].getNoteName());
                note.start();
                noteList.add(note);
                i++;
            }
            if (!dropped)
            {
                try {
                    Thread.sleep(5);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        }

    }

}

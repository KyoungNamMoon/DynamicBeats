package dynamic_beat_1;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.*;

public class DynamicBeat extends JFrame {
    //IntroBackground
    private Image introBackground= new ImageIcon(Main.class.getResource("../image/background/1.png")).getImage();
    private Image screenImage;
    private Graphics screenGrphic;

    private JLabel menubar = new JLabel(new ImageIcon(dynamic_beat_1.Main.class.getResource("../image/background/menu.png")));
    private int mouseX, mouseY;

    //exitButton
    private ImageIcon exitButtonImage = new ImageIcon(dynamic_beat_1.Main.class.getResource("../image/button/exit.png"));
    private JButton exitButton = new JButton(exitButtonImage);

    //back Button
    private ImageIcon backButton = new ImageIcon(dynamic_beat_1.Main.class.getResource("../image/button/backButton.png"));
    private JButton back = new JButton(backButton);

a
    //start and quit Button
    private ImageIcon startButtonEnter = new ImageIcon(dynamic_beat_1.Main.class.getResource("../image/button/start.png"));
    private ImageIcon quitButtonEnter = new ImageIcon(dynamic_beat_1.Main.class.getResource("../image/button/quit.png"));
    private JButton startButton = new JButton(startButtonEnter);
    private JButton quitButton = new JButton(quitButtonEnter);

    //left and right button
    private ImageIcon leftButton = new ImageIcon(dynamic_beat_1.Main.class.getResource("../image/button/left.png"));
    private ImageIcon rightButton = new ImageIcon(dynamic_beat_1.Main.class.getResource("../image/button/right.png"));
    private JButton lButton = new JButton(leftButton);
    private JButton rButton = new JButton(rightButton);

    //easy hard button
    private ImageIcon easyButton = new ImageIcon(dynamic_beat_1.Main.class.getResource("../image/button/easyButton.png"));
    private ImageIcon hardButton = new ImageIcon(dynamic_beat_1.Main.class.getResource("../image/button/hardButton.png"));
    private JButton easy = new JButton(easyButton);
    private JButton hard = new JButton(hardButton);
    //Music 관련
    ArrayList<dynamic_beat_1.Track> trackList = new ArrayList<Track>();
    private boolean isMainScreen = false;
    private Music selectedMusic;
    private Image gameImage; //big
    private Image selectedImage; //small
    private int number = 0;
    Music introMusic;

    //game Info
    private boolean isGameScreen = false;

    public static Game game;

    public DynamicBeat()
    {
        trackList.add(new dynamic_beat_1.Track("yourname.png", "track1.png","yourname.mp3", "yourname"));
        trackList.add(new dynamic_beat_1.Track("goodNight.png", "track2.png","goodNight.mp3", "goodNight"));
        trackList.add(new Track("confess.png", "track3.png","confess.mp3","confess"));

        setUndecorated(true);
        setTitle("Dynamic Beat");
        setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setBackground(new Color(0, 0, 0,0));
        setLayout(null);

        addKeyListener(new KeyListener());

        isMainScreen = true;
        introMusic = new Music("star.mp3", true);
        introMusic.start();


        //exit button
        exitButton.setBounds(1250, 0, 30, 30);
        exitButton.setBorderPainted(false);
        exitButton.setContentAreaFilled(false);
        exitButton.setFocusPainted(false);
        exitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                exitButton.setIcon(exitButtonImage);
                exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                exitButton.setIcon(exitButtonImage);
                exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                System.exit(0);
            }
        });
        add(exitButton);


        //start button
        startButton.setBounds(40, 250, 400, 100);
        startButton.setBorderPainted(false);
        startButton.setContentAreaFilled(false);
        startButton.setFocusPainted(false);
        startButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                startButton.setIcon(startButtonEnter);
                startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                startButton.setIcon(startButtonEnter);
                startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e) {
                enterMain();

            }
        });
        add(startButton);

        //quit button
        quitButton.setBounds(40, 400, 400, 100);
        quitButton.setBorderPainted(false);
        quitButton.setContentAreaFilled(false);
        quitButton.setFocusPainted(false);
        quitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                quitButton.setIcon(quitButtonEnter);
                quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                quitButton.setIcon(quitButtonEnter);
                quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                System.exit(0);
            }
        });
        add(quitButton);

        menubar.setBounds(0, 0, 1280, 30);
        menubar.addMouseListener((new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
            }
        }));
        menubar.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int x = e.getXOnScreen();
                int y = e.getYOnScreen();
                setLocation(x - mouseX, y - mouseY);
            }
        });
        add(menubar);

        //left Button
        lButton.setVisible(false);
        lButton.setBounds(100, 400, 60, 60);
        lButton.setBorderPainted(false);
        lButton.setContentAreaFilled(false);
        lButton.setFocusPainted(false);
        lButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                lButton.setIcon(leftButton);
                lButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                lButton.setIcon(leftButton);
                lButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e) {
                selectedLeft();
            }
        });
        add(lButton);

        //right Button
        rButton.setVisible(false);
        rButton.setBounds(1080, 400, 60, 60);
        rButton.setBorderPainted(false);
        rButton.setContentAreaFilled(false);
        rButton.setFocusPainted(false);
        rButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                rButton.setIcon(rightButton);
                rButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                rButton.setIcon(rightButton);
                rButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e) {
                selectedRight();
            }
        });
        add(rButton);
        //easy Button
        easy.setVisible(false);
        easy.setBounds(375, 580, 250, 67);
        easy.setBorderPainted(false);
        easy.setContentAreaFilled(false);
        easy.setFocusPainted(false);
        easy.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                easy.setIcon(easyButton);
                easy.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                easy.setIcon(easyButton);
                easy.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e) {
                gameStart(number, "Easy");

            }
        });
        add(easy);

        //hard Button
        hard.setVisible(false);
        hard.setBounds(655, 580, 250, 67);
        hard.setBorderPainted(false);
        hard.setContentAreaFilled(false);
        hard.setFocusPainted(false);
        hard.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                hard.setIcon(hardButton);
                hard.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                hard.setIcon(hardButton);
                hard.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e) {
                gameStart(number, "Hard");

            }
        });
        add(hard);

        back.setBounds(20, 50, 60, 60);
        back.setBorderPainted(false);
        back.setContentAreaFilled(false);
        back.setFocusPainted(false);
        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                back.setIcon(backButton);
                back.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                back.setIcon(backButton);
                back.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e) {
                backMain();


            }
        });
        add(back);



    }
    public void paint(Graphics g)
    {
        screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        screenGrphic = screenImage.getGraphics();
        screenDraw((Graphics2D)screenGrphic);
        g.drawImage(screenImage,0 , 0, null);
    }

    public void screenDraw(Graphics2D g)
    {
        g.drawImage(introBackground, 0, 0, null);
        if(isMainScreen)
        {
            g.drawImage(selectedImage, 340, 220, null);
        }
        if(isGameScreen)
        {
            game.screenDraw(g);
        }
        paintComponents(g);
        try {
            Thread.sleep(5);

        } catch (Exception e) {
            e.printStackTrace();
        }
        this.repaint();
    }

    public void selectedTrack(int number)
    {
        if(selectedMusic != null)
        {
            selectedMusic.close();
        }
        selectedImage = new ImageIcon(Main.class.getResource("../image/background/" + trackList.get(number).getStartImage())).getImage();;
        selectedMusic = new Music(trackList.get(number).getGameMusic(), true);
        selectedMusic.start();

    }
    public void selectedLeft()
    {
        if(number == 0)
        {
            number = trackList.size() - 1;
        }
        else {
            number--;
        }
        selectedTrack(number);
    }
    public void selectedRight()
    {
        if(number == trackList.size() -1)
        {
            number = 0;
        }
        else {
            number++;
        }
        selectedTrack(number);
    }

    public void gameStart(int nowSelected, String difficulty)
    {
        if(selectedMusic != null)
        {
            selectedMusic.close();
        }
        isMainScreen = false;
        lButton.setVisible(false);
        rButton.setVisible(false);
        easy.setVisible(false);
        hard.setVisible(false);
        back.setVisible(true);
        introBackground = new ImageIcon(Main.class.getResource("../image/" + trackList.get(nowSelected).getGameImage())).getImage();
        isGameScreen = true;
        game = new Game(trackList.get(number).getTitleName(), difficulty, trackList.get(number).getGameMusic());
        game.start();
        setFocusable(true);
    }

    public void backMain()
    {
        isMainScreen = true;
        easy.setVisible(true);
        hard.setVisible(true);
        rButton.setVisible(true);
        lButton.setVisible(true);
        introBackground = new ImageIcon(Main.class.getResource("../image/background/1.png")).getImage();
        back.setVisible(false);
        selectedTrack(number);
        isGameScreen = false;
        game.close();
    }

    public void enterMain()
    {
        startButton.setVisible(false);
        quitButton.setVisible(false);
        isMainScreen = true;
        lButton.setVisible(true);
        rButton.setVisible(true);
        easy.setVisible(true);
        hard.setVisible(true);
        introMusic.close();
        selectedTrack(0);
    }




}

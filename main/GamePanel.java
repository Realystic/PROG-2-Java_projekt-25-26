package main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;


public class GamePanel extends JPanel implements Runnable {
    // nastavitve okna
    public int screenWidth = 1440;
    public int screenHeight = 860;
    final int ORIGINAL_TILE_SIZE = 16;
    final int SCALE = 3;
    public int tileSize = ORIGINAL_TILE_SIZE * SCALE;

    KeyHandler keyH = new KeyHandler(); //poslušalec tipkovnice
    Thread gameThread; // pomaga z pretakanjem igre

    // osnovna lokacija igralca in njegova hitrost
    Player player = new Player(this, keyH);

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    
    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start(); // zažene funkcijo run()
    }

    
    @Override
    public void run() {

        while(gameThread != null) {
            // 1. posodobimo stanje predmetov v igri (igralec, pošasti, itd.)
            update();

            //2. narišemo s posodobljeno informacijo
            repaint();

            try {
                Thread.sleep(50/3); // ne dela brez try catch metode (ne vem zakaj) (60 FPS)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
        }

    }

    public void update() {
        player.update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        player.draw(g2);

        g2.dispose();
    }
}

package main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;
import tile.TileManager;


public class GamePanel extends JPanel implements Runnable {
    // nastavitve okna
    final int ORIGINAL_TILE_SIZE = 16;
    final int SCALE = 3;
    public final int tileInRow = 22;
    public final int tileInCol = 32;
    public final int tileSize = ORIGINAL_TILE_SIZE * SCALE;
    public final int screenWidth = tileSize * tileInCol;
    public final int screenHeight = tileSize * tileInRow;

    KeyHandler keyH = new KeyHandler(this);
    Thread gameThread; // runs the game
    TileManager tileM = new TileManager(this);
    public CollisionChecker cChecker = new CollisionChecker(this);
    public Player player = new Player(this, keyH);

    //Game state
    public int gameState;
    public final int titleState = 0;
    public final int pauseState = 1;
    public final int playState = 2;
    

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void setupGame() {
        gameState = playState;
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
        
        if (gameState == playState) {
        player.update();
        } else if (gameState == pauseState) {
            //nothing for now
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;
        
        tileM.draw(g2);
        player.draw(g2);

        g2.dispose();
    }
}

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;


public class GamePanel extends JPanel implements Runnable {
    // nastavitve okna
    final int screenWidth = 1440;
    final int screenHeight = 860;

    KeyHandler KeyH = new KeyHandler(); //poslušalec tipkovnice
    Thread gameThread; // pomaga z pretakanjem igre

    // osnovna lokacija igralca in njegova hitrost
    Player player = new Player(screenWidth/2, screenHeight/2);

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.CYAN);
        this.setDoubleBuffered(true);
        this.addKeyListener(KeyH);
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
                Thread.sleep(50/3); // ne dela brez try catch metode (ne vem zakaj)
            } catch (InterruptedException e) {
            }
            
        }

    }

    public void update() {

        if (KeyH.upPressed) {
            player.UpMove();
        }
        if (KeyH.downPressed) {
            player.DownMove();
        }
        if (KeyH.leftPressed) {
            player.LeftMove();
        }
        if (KeyH.rightPressed) {
            player.RightMove();
        }

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        g2.setColor(Color.RED);

        g2.fillRect(player.x, player.y, 48,48);

        g2.dispose();
    }
}

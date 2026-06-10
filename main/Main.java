package main;
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        //narisemo okno
        JFrame okno = new JFrame();
        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        okno.setResizable(false);
        okno.setTitle("Java Igra");

        GamePanel gamePanel = new GamePanel();
        okno.add(gamePanel);

        okno.pack(); //nastavi velikost okna (in druge nastavitve) glede na kaj potrebuje JPanel, ki je bil dodan prej

        okno.setLocationRelativeTo(null);
        okno.setVisible(true);

        gamePanel.startGameThread();
    }
}

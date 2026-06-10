import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Glavni_menu extends JFrame	{
	// Glavni meni (Main Menu) igre
	/* Potrebuje se frame, panela, (action listener (ali mouse listener če nočemo gumba))
	 * Naslov
	 * klik za start
	 * gumb	za izhod
	 * (Minecraft main menu animacijo) (naslov se povečava in manjša z majhno naključno rotacijo (v obe smeri))
	 */
	private final String NASLOV = "Java Igra";
	
	public Glavni_menu() {
		
		JPanel panel = new JPanel() {
			@Override
			public void paint(Graphics g) {
				super.paint(g);
				
				//	3.	KORAK:	izris	menuja
				/*for (Stone stone : stones) {
					//kamen
					g.setColor(Color.GRAY);
					g.fillOval(stone.x - RADIUS, stone.y - RADIUS, 2*RADIUS, 2*RADIUS);
					
					//val
					g.setColor(Color.WHITE);
					g.drawOval(stone.x - stone.radius, stone.y - stone.radius, 2*stone.radius, 2*stone.radius);
				}*/
			}
		};
		panel.setBackground(new	Color(174, 198, 207));
		panel.setFocusable(true);
		add(panel);
	}
	public static void main(String[] args) {
		Glavni_menu GUI = new Glavni_menu();
		GUI.setVisible(true);
		/*while (true) {
			//4.	KORAK:	animacija	širjenja	valov	(NAMIG:	stone.radius++)
			for (Stone stone : GUI.stones) {
				stone.radius++;
			}
			GUI.repaint();
			Thread.sleep(25);
		}*/
	}
	
	
	
	public void Show() {
		
	}
}

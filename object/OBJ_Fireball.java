package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Projectile;
import main.GamePanel;

public class OBJ_Fireball  extends Projectile{
    
    GamePanel gp;

    public OBJ_Fireball(GamePanel gp) {
        super(gp);
        this.gp = gp;
        getImage();
    }

    public void getImage() {
        try {

        up1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("./src/projectiles/fireball_up_1.png"));
        down1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("./src/projectiles/fireball_down_1.png"));
        right1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("./src/projectiles/fireball_right_1.png"));
        left1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("./src/projectiles/fireball_left_1.png"));
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

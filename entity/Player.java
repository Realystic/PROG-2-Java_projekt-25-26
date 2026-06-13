package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.KeyHandler;
import main.GamePanel;

public class Player extends Entity {

    GamePanel gp;
    
    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        this.solidArea = new Rectangle(8,16,32,32);
        this.collisionOnX = true;
        this.collisionOnY = true;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        // na sredini okna začne
        x = gp.screenWidth/2 - (gp.tileSize/2);
        y = gp.screenHeight/2 - (gp.tileSize/2);
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage() {

        try {
            up1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("./src/player/boy_up_1.png"));
            up2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("./src/player/boy_up_2.png"));
            down1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("./src/player/boy_down_1.png"));
            down2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("./src/player/boy_down_2.png"));
            left1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("./src/player/boy_left_1.png"));
            left2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("./src/player/boy_left_2.png"));
            right1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("./src/player/boy_right_1.png"));
            right2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("./src/player/boy_right_2.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    int counter = 0;
    public void update() {
        if (keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed) {
            //allows free movement
            if (keyH.upPressed) {
                direction = "up";
            }
            if (keyH.downPressed) {
                direction = "down";
            }
            if (keyH.leftPressed) {
                direction = "left";
            }
            if (keyH.rightPressed) {
                direction = "right";
            }
            
            // check collision
            collisionOnX = false;
            collisionOnY = false;
            gp.cChecker.checkTile(this);

            
            // if collision is false player can move on the specified x or y axis
            if (!collisionOnX) {
                if (keyH.leftPressed) {
                    x -= speed;
                }
                if (keyH.rightPressed) {
                    x += speed;
                }
            }
            if (!collisionOnY) {
                if (keyH.upPressed) {
                    y -= speed;
                }
                if (keyH.downPressed) {
                    y += speed;
                }
            }
            
            //does the animation
            spriteCounter++;
            if (spriteCounter > 10) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 1;
                }

                spriteCounter = 0;
            }
        }   
    }

    public void draw(Graphics2D g2) {
      /*g2.setColor(Color.RED);
        g2.fillRect(x, y, gp.tileSize, gp.tileSize);*/

        BufferedImage image = null;

        switch (direction) {
            case "up":
                if (spriteNum == 1) {
                    image = up1;
                } else if (spriteNum == 2) {
                    image = up2;
                }
                break;

            case "down":
                if (spriteNum == 1) {
                    image = down1;
                } else if (spriteNum == 2) {
                    image = down2;
                }
                break;

            case "left":
                if (spriteNum == 1) {
                    image = left1;
                } else if (spriteNum == 2) {
                    image = left2;
                }
                break;

            case "right":
                if (spriteNum == 1) {
                    image = right1;
                } else if (spriteNum == 2) {
                    image = right2;
                }
                break;
        }

        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }

    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
}

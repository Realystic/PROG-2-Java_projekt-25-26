package tile;

import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class TileManager {
    GamePanel gp;
    Tile[] tile;

    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[10];

        getTileImage();
    }

    public void getTileImage() {
        
        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("./src/tiles/grass.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {

        for(int row = 0; row < gp.tileInRow; row++){
            for(int col = 0; col < gp.tileInCol; col++){
                g2.drawImage(tile[0].image, (col*gp.tileSize), (row*gp.tileSize), gp.tileSize, gp.tileSize,null);
            }
        }
    }
}

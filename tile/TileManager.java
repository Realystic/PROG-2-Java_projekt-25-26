package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.GamePanel;

public class TileManager {
    GamePanel gp;
    public Tile[] tile;
    public int mapTileNum[][];

    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[10];
        mapTileNum = new int[gp.tileInCol][gp.tileInRow];

        getTileImage();
        loadMap();
    }

    public void getTileImage() {
        
        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("./src/tiles/grass.png"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("./src/tiles/wall.png"));
            tile[1].collision = true;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadMap() {
        //shranimo mapo kot 2D tabelo
        try {
            InputStream is = getClass().getClassLoader().getResourceAsStream("./src/maps/map01.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            for (int row = 0; row < gp.tileInRow; row++) {
                String numbers[] = br.readLine().split(" ");

                for(int col = 0; col < gp.tileInCol; col++) {
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                }
            }
        } catch (Exception e) {
        }
    }

    public void draw(Graphics2D g2) {
        //we draw a simple small arena

        for(int row = 0; row < gp.tileInRow; row++){
            for(int col = 0; col < gp.tileInCol; col++){
                int tileNum = mapTileNum[col][row];
                g2.drawImage(tile[tileNum].image, (col*gp.tileSize), (row*gp.tileSize), gp.tileSize, gp.tileSize,null);
            }
        }
    }
}

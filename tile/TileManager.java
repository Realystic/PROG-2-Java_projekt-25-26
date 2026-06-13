package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.UtilityTool;

public class TileManager {
    GamePanel gp;
    public Tile[] tile;
    public int mapTileNum[][];

    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[10];
        mapTileNum = new int[gp.tileInCol][gp.tileInRow];

        getTileImage();
        loadMap("./src/maps/map01.txt");
    }

    public void getTileImage() {
            setup(0, "grass", false);
            setup(1, "wall", true);
    }

    public void setup(int index, String imageName, boolean collision) {
        UtilityTool uTool = new UtilityTool();

        try {
            tile[index] = new Tile();
            tile[index].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("./src/tiles/"+ imageName +".png"));
            tile[index].image = uTool.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
            tile[index].collision = collision;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadMap(String mapPath) {
        //shranimo mapo kot 2D tabelo
        try {
            InputStream is = getClass().getClassLoader().getResourceAsStream(mapPath);
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

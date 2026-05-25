package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class TileManager{

    GamePanel gp;
    Tile[] tile;

    public TileManager(GamePanel gp){

        this.gp = gp;

        tile = new Tile[10];

        getTileImage();
    }

    public void getTileImage() {
        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tile/Grassland.png"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tile/Wall.png"));

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tile/Water.png"));

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tile/vPath.png"));

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tile/hPath.png"));

            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tile/pPath.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void update() {

    }

    public void draw(Graphics g2d) {

        int row = 0;
        int col = 0;
        int x = 0;
        int y = 0;

        while(col < gp.maxScreenCol && row < gp.maxScreenRow) {
            g2d.drawImage(tile[0].image, x, y, gp.tileSize, gp.tileSize, null);
            col++;
            x+=gp.tileSize;

            if(col == gp.maxScreenCol) {
                col = 0;
                x = 0;
                row++;
                y+=gp.tileSize;
            }

        }

    }
}

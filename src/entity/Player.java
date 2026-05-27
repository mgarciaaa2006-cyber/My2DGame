package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {

    GamePanel gp;
    KeyHandler kh;

    public final int screenX;
    public final int screenY;

    public Player(GamePanel gp, KeyHandler kh) {

        this.gp = gp;
        this.kh = kh;

        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        worldX = gp.tileSize * 23;
        worldY = gp.tileSize * 0;
        speed = 2;
        direction = "down";
    }

    public void getPlayerImage() {
        try{
            idle = ImageIO.read(getClass().getResourceAsStream("/player/Player_Idle.png"));
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/Player_Up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/Player_Up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/Player_Down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/Player_Down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/Player_Left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/Player_Left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/Player_Right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/Player_Right_2.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void update() {

        if(kh.upPressed ||  kh.downPressed || kh.leftPressed || kh.rightPressed){

            if(kh.upPressed) {
                direction = "up";
                worldY -= speed;
            }
            else if(kh.downPressed) {
                direction = "down";
                worldY += speed;
            }
            else if(kh.leftPressed) {
                direction = "left";
                worldX -= speed;
            }
            else if(kh.rightPressed) {
                direction = "right";
                worldX += speed;
            }

            spriteCounter++;
            if(spriteCounter > 12) {
                spriteCounter = 0;
                if(spriteNum == 1) {
                    spriteNum = 2;
                }
                else if(spriteNum == 2) {
                    spriteNum = 1;
                }

            }
        }

        if(kh.wasDownPressed) {
            direction = "idle";
        }
    }

    public void draw(Graphics2D g2d) {

//        g2d.setColor(Color.white);
//        g2d.fillRect(x, y, gp.tileSize, gp.tileSize);

        BufferedImage image = null;

        switch (direction) {
            case "idle":
                image = idle;
                break;
            case "up":
                if(spriteNum == 1) {
                    image = up1;
                }
                if(spriteNum == 2) {
                    image = up2;
                }
                break;
            case "down":
                if(spriteNum == 1) {
                    image = down1;
                }
                if(spriteNum == 2) {
                    image = down2;
                }
                break;
            case "left":
                if(spriteNum == 1) {
                    image = left1;
                }
                if(spriteNum == 2) {
                    image = left2;
                }
                break;
            case "right":
                if(spriteNum == 1) {
                    image = right1;
                }
                if(spriteNum == 2) {
                    image = right2;
                }
                break;
        }

        g2d.drawImage(image, screenX, screenY, gp.tileSize,  gp.tileSize, null);
    }
}

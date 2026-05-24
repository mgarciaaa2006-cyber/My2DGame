package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {

    GamePanel gp;
    KeyHandler kh;

    public Player(GamePanel gp, KeyHandler kh) {

        this.gp = gp;
        this.kh = kh;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        x = 350;
        y = 0;
        speed = 2;
        direction = "down";
    }

    public void getPlayerImage() {
        try{
            idle = ImageIO.read(getClass().getResourceAsStream("/My2DGame_materials/Player_Idle.png"));
            up1 = ImageIO.read(getClass().getResourceAsStream("/My2DGame_materials/Player_Up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/My2DGame_materials/Player_Up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/My2DGame_materials/Player_Down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/My2DGame_materials/Player_Down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/My2DGame_materials/Player_Left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/My2DGame_materials/Player_Left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/My2DGame_materials/Player_Right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/My2DGame_materials/Player_Right_2.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void update() {

        if(kh.upPressed ||  kh.downPressed || kh.leftPressed || kh.rightPressed){

            if(kh.upPressed) {
                direction = "up";
                y -= speed;
            }
            else if(kh.downPressed) {
                direction = "down";
                y += speed;
            }
            else if(kh.leftPressed) {
                direction = "left";
                x -= speed;
            }
            else if(kh.rightPressed) {
                direction = "right";
                x += speed;
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

        g2d.drawImage(image, x, y, gp.tileSize,  gp.tileSize, null);
    }
}

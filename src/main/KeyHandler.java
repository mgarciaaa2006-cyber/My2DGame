package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean upPressed,  downPressed, leftPressed, rightPressed, wasDownPressed;
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W){
            upPressed = true;
            wasDownPressed = false;
        }
        if(code == KeyEvent.VK_S){
            downPressed = true;
            wasDownPressed = false;
        }
        if(code == KeyEvent.VK_A){
            leftPressed = true;
            wasDownPressed = false;
        }
        if(code == KeyEvent.VK_D){
            rightPressed = true;
            wasDownPressed = false;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code =  e.getKeyCode();

        if(code == KeyEvent.VK_W){
            upPressed = false;
        }
        if(code == KeyEvent.VK_S){
            downPressed = false;
            wasDownPressed = true;
        }
        if(code == KeyEvent.VK_A){
            leftPressed = false;
        }
        if(code == KeyEvent.VK_D){
            rightPressed = false;
        }
    }
}

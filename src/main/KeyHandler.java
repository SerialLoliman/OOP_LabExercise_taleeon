package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyHandler implements KeyListener{
    
    GamePanel gp;
    public boolean upPressed, downPressed, leftPressed, rightPressed;
    
    //DEBUG
    boolean checkDrawTime = false;
    
    
    public KeyHandler(GamePanel gp){
        this.gp = gp;
    }

    KeyHandler() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    @Override
    public void keyTyped(KeyEvent e){}
    @Override
    public void keyPressed(KeyEvent e){
    
        int code = e.getKeyCode();
        
        if(code == KeyEvent.VK_UP){
            upPressed = true;
        }
        
        if(code == KeyEvent.VK_DOWN){
            downPressed = true;
        }
        
        if(code == KeyEvent.VK_LEFT){
            leftPressed = true;
        }
        
        if(code == KeyEvent.VK_RIGHT){
            rightPressed = true;
        }
        
        //PAUSE
        if(code == KeyEvent.VK_P){
            if(gp.gameState == gp.playState){
                gp.gameState = gp.pauseState;
            }
            else if (gp.gameState == gp.pauseState){
                gp.gameState = gp.playState;
            }
        }
        
        //DEBUG
        if(code == KeyEvent.VK_T){
            if(checkDrawTime == false){
                checkDrawTime = true;
            }
            else if (checkDrawTime == true){
            checkDrawTime = false;
            }
        }
        
    }
    @Override
    public void keyReleased(KeyEvent e){
    
        
        int code = e.getKeyCode();
        
        if(code == KeyEvent.VK_UP){
            upPressed = false;
        }
        
        if(code == KeyEvent.VK_DOWN){
            downPressed = false;
        }
        
        if(code == KeyEvent.VK_LEFT){
            leftPressed = false;
        }
        
        if(code == KeyEvent.VK_RIGHT){
            rightPressed = false;
        }
    }
    
}
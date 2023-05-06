package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;
import main.KeyHandler;


public class Player extends Entity{
    
    GamePanel gp;
    KeyHandler keyH;
    
    public Player(GamePanel gp, KeyHandler keyH){
    
        this.gp = gp;
        this.keyH = keyH;
        
        setDefaultValues();
        getPlayerImage();
    }


    public void setDefaultValues(){
    
    x = 100;
    y = 100;
    speed = 4;
    direction = "down";//shows starting image, if you leave this blank, you wont see where the character starts
    }
    public void getPlayerImage(){
    
    try{
    
        up1 = ImageIO.read(getClass().getResourceAsStream("/res/player/char1/up1.png"));
        up2 = ImageIO.read(getClass().getResourceAsStream("/res/player/char1/up2.png"));
        up3 = ImageIO.read(getClass().getResourceAsStream("/res/player/char1/up3.png"));
        down1 = ImageIO.read(getClass().getResourceAsStream("/res/player/char1/down1.png"));
        down2 = ImageIO.read(getClass().getResourceAsStream("/res/player/char1/down2.png"));
        down3 = ImageIO.read(getClass().getResourceAsStream("/res/player/char1/down3.png"));
        left1 = ImageIO.read(getClass().getResourceAsStream("/res/player/char1/left1.png"));
        left2 = ImageIO.read(getClass().getResourceAsStream("/res/player/char1/left2.png"));
        left3 = ImageIO.read(getClass().getResourceAsStream("/res/player/char1/left3.png"));
        right1 = ImageIO.read(getClass().getResourceAsStream("/res/player/char1/right1.png"));
        right2 = ImageIO.read(getClass().getResourceAsStream("/res/player/char1/right2.png"));
        right3 = ImageIO.read(getClass().getResourceAsStream("/res/player/char1/right3.png"));
    }
    catch(IOException e){
    
        e.printStackTrace();
        }
    }
    public void update(){
        
        if(keyH.upPressed == true||keyH.downPressed ==true||keyH.leftPressed ==true||keyH.rightPressed ==true){
        if(keyH.upPressed == true){
            direction = "up";
            y -= speed;
        }
        else if (keyH.downPressed == true){
            direction = "down";
            y += speed;
        }
        else if (keyH.leftPressed == true){
            direction = "left";
            x -= speed;
        }
        else if (keyH.rightPressed == true){
            direction = "right";
            x += speed;
        }
    spriteCounter ++;
    if(spriteCounter >10){
        if(spriteNum == 1){spriteNum = 2;}
        else if(spriteNum ==2){spriteNum = 3;}
        else if(spriteNum ==3){spriteNum = 1;}
        spriteCounter = 0;}
        }
    }
    public void draw(Graphics2D g2){
    
//        g2.setColor(Color.white);
//        g2.fillRect(x, y, gp.tileSize, gp.tileSize);

        BufferedImage image = null;
        switch(direction){
        
            case "up":
                if(spriteNum == 1){image = up1;}
                if(spriteNum == 2){image = up2;}
                if(spriteNum == 3){image = up3;}
                break;
            case "down":
                if(spriteNum == 1){image = down1;}
                if(spriteNum == 2){image = down2;}
                if(spriteNum == 3){image = down3;}
                break;
            case "left":
                if(spriteNum == 1){image = left1;}
                if(spriteNum == 2){image = left2;}
                if(spriteNum == 3){image = left2;}
                break;
            case "right":
                if(spriteNum == 1){image = right1;}
                if(spriteNum == 2){image = right2;}
                if(spriteNum == 3){image = right3;}
                break;
            
        }
        g2.drawImage(image, x,y,gp.tileSize, gp.tileSize,null);
    }
}
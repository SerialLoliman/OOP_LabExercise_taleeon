
package entity;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import main.GamePanel;
import main.UtilityTool;

public class NPC_OldMan extends Entity {
    
    public NPC_OldMan(GamePanel gp){
        super(gp);
        
        direction = "down";
        speed = 1;
        
    }
        public void getImage(){
    
        up1 = setup("up1");
        up2 = setup("up2");
        up3 = setup("up3");
        down1 = setup("down1");
        down2 = setup("down2");
        down3 = setup("down3");
        left1 = setup("left1");
        left2 = setup("left2");
        left3 = setup("left3");
        right1 = setup("right1");
        right2 = setup("right2");
        right3 = setup("right3");
        
    }
        
    public void setAction(){
        
        actionLockCounter ++;
        
        if(actionLockCounter == 120){
            
        Random random = new Random();
        int i = random.nextInt(100)+1;//random number from 1 - 100
        
        if (i <= 25){
            direction = "up";
        }
        if (i > 25 && i <= 50){
            direction = "down";
        }
        if (i > 50 && i <= 75){
            direction = "left";
        }
        if (i > 75 && i <= 100){
            direction = "rigth";
        }
        
        actionLockCounter = 0; 
        
        }
        
    }
        
    public BufferedImage setup(String imageName){
    
        UtilityTool uTool = new UtilityTool();
        BufferedImage image = null;
        
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/res/oldman/char1/"+ imageName + ".png"));
            image = uTool.scaleImage(image,gp.tileSize,gp.tileSize);
              
        }catch(IOException e){
        e.printStackTrace();
        }
        return image;
    }
    
}

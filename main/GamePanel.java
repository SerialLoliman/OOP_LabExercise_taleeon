package main;

import entity.Entity;
import entity.Player;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JPanel;
import tile.TileManager;


public class GamePanel extends JPanel implements Runnable{
    
    //SCREEN SETTINGS
    
    final int originalTileSize = 16; //16x16 tile
    final int scale = 3;
    
    public final int tileSize = originalTileSize * scale; //48x48 tile
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12; //4 by 3
    public final int screenWidth = tileSize * maxScreenCol; //768 pixels
    public final int screenHeight = tileSize * maxScreenRow; //576 pixels
    
    //WORLD SETTINGS
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    
    //FPS
    int FPS = 60;
    
    //SYSTEM
    TileManager tileM = new TileManager(this);
    public KeyHandler keyH = new KeyHandler(this);
    Sound music = new Sound();
    Sound se = new Sound();
    public CollisionChecker cChecker = new CollisionChecker(this);
    public  AssetSetter aSetter = new AssetSetter(this);
    public UI ui = new UI(this);
    public EventHandler eHandler = new EventHandler(this);
    Thread gameThread;
    
    //ENTITY and OBJECT
    public Player player = new Player(this,keyH);
    public Entity obj[] = new Entity[20]; //Object Slots
    public Entity npc[] = new Entity[10]; //NPC Slots
    public Entity monster[] = new Entity[20]; //Monster Slots
    public ArrayList<Entity> projectileList = new ArrayList<>();
    ArrayList<Entity> entityList = new ArrayList<>();
    
    //GAME STATE
    public int gameState;
    public final int titleState = 0;
    public final int playState = 1;
    public final int pauseState = 2;
    public final int dialogueState = 3;
    public final int characterState = 4;
    
    public GamePanel(){
    
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }
    
    public void setupGame(){
    
        aSetter.setObject();
        aSetter.setNPC();
        aSetter.setMonster();
        
//        playMusic(0);
        
        gameState = titleState;
        
    }
    
    public void startGameThread(){
    
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    @Override

//SLEEP METHOD:
//    public void run(){
//    
//        double drawInterval = 1000000000/FPS;//1billion nanosecods divided by FPS = 0.01666 seconds refresh rate
//        double nextDrawTime = System.nanoTime() + drawInterval;
//        
//        
//        
//        
//        
//        
//        while(gameThread != null){
//        
//        
//           long currentTime = System.nanoTime();
//           System.out.println("current Time:"+ currentTime);
//           
//           // 1 UPDATE
//           update();
//           
//           
//           //2 DRAW
//           repaint();
//           
//           
//        try{ 
//           double remainingTime = nextDrawTime - System.nanoTime();
//           remainingTime = remainingTime/1000000;//time left divided by 1million nanoseconds = milliseconds
//           
//           if(remainingTime <0){
//               remainingTime = 0;
//           }
//           
//         
//           Thread.sleep((long)remainingTime);
//           
//           nextDrawTime += drawInterval;
//           
//           
//        } catch (InterruptedException e){
//        
//        e.printStackTrace();
//        }
//        
//        }
//        
//    }
    
//DELTA METHOD:
    public void run(){
        
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;
        
        while(gameThread != null){
            
            currentTime = System.nanoTime();
            
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            
            lastTime = currentTime;
        
            if(delta >= 1){
        update();
        repaint();
        delta --;
        drawCount++;
            }
            
            if (timer >= 1000000000){
            System.out.println("FPS: " + drawCount);
            drawCount = 0;
            timer = 0;
            }
            
        }
    
    }
    
    
    public void update(){
        
        if(gameState == playState){
            //PLAYER
            player.update();
            //NPC
            for(int i = 0; i < npc.length; i++){
                if(npc[i] != null){
                    npc[i].update();
                }
            }
            for(int i = 0; i < monster.length; i++){
                if(monster[i] != null){
                    if(monster[i].alive == true && monster[i].dying == false){
                    monster[i].update();
                    }
                    if(monster[i].alive == false){
                        monster[i].checkDrop();
                        monster[i] = null;
                    }
                }
            }
            for(int i = 0; i < projectileList.size(); i++){
                if(projectileList.get(i) != null){
                    if(projectileList.get(i).alive == true){
                    projectileList.get(i).update();
                    }
                    if(projectileList.get(i).alive == false){
                        projectileList.remove(i);
                    }
                }
            }
        }
        if (gameState == pauseState){
            //NOTHING
        }
    }
    @Override
    public void paintComponent(Graphics g){
    
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D)g;
        
        //DEBUG
        long drawStart = 0;
        if(keyH.checkDrawTime == true){drawStart = System.nanoTime();
        }
        
        
        //TITLE SCREEN
        if(gameState == titleState){
            ui.draw(g2);
        }
        //OTHERS        
        else{
            
        //TILE
        tileM.draw(g2);//this one first before drawing the player and other stuff unless you want the tile to cover your player
        
        //ADD ENTITIES TO THE LIST
        entityList.add(player);
        
        for(int i = 0; i< npc.length; i++){
        
        if (npc[i] != null) {
        entityList.add(npc[i]);
            }
        }
        
        for(int i = 0; i < obj.length; i++) {
        
        if(obj[i] != null) {
        
            entityList.add(obj[i]);
            }
        }
        for(int i = 0; i < monster.length; i++) {
        
        if(monster[i] != null) {
        
            entityList.add(monster[i]);
            }
        }
        for(int i = 0; i < projectileList.size(); i++) {
        
        if(projectileList.get(i) != null) {
        
            entityList.add(projectileList.get(i));
            }
        }
        
        // SORT
        Collections.sort(entityList, new Comparator<Entity>(){
        
        @Override
        public int compare(Entity e1, Entity e2) {
        
        int result = Integer.compare(e1.worldY, e2.worldY);
        return result;
        
        }
        
        });
        
        //DRAW ENTITIES
        for(int i = 0; i < entityList.size(); i++) {
            entityList.get(i).draw(g2);
        }
        
        //EMPTY ENTITY LIST
        entityList.clear();
        
        //UI
        ui.draw(g2);
            
        }
        
        //DEBUG
        if(keyH.checkDrawTime == true){
        long drawEnd = System.nanoTime();
        long passed = drawEnd - drawStart;
        g2.setColor(Color.white);
        g2.drawString("Draw time: " + passed, 10,400);
        System.out.println("Draw time: "+passed);}
        
        
        g2.dispose();
    }
    public void playMusic(int i){
    
        music.setFile(i);
        music.play();
        music.loop();
    }
    public void stopMusic(){
        music.stop();
    }
    public void playSE(int i){
        se.setFile(i); 
        se.play();
    }
}
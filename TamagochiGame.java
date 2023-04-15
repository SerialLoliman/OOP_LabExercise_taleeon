package tamagochigame;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

public class TamagochiGame extends JPanel implements ActionListener {
    
    private int hunger = 0;
    private int happiness = 100;
    private int health = 100;
    
    private Random rand = new Random();
    private Timer timer;
    
    public TamagochiGame() {
        setBackground(Color.WHITE);
        setFocusable(true);
        
        timer = new Timer(1000, this);
        timer.start();
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString("Hunger: " + hunger, 10, 25);
        g.drawString("Happiness: " + happiness, 10, 50);
        g.drawString("Health: " + health, 10, 75);
    }
    
    public void actionPerformed(ActionEvent e) {
        hunger += rand.nextInt(10) + 1;
        happiness -= rand.nextInt(10) + 1;
        health -= rand.nextInt(10) + 1;
        
        if (hunger > 100 || happiness < 0 || health < 0) {
            System.out.println("Game Over!");
            timer.stop();
            
            JFrame gameOverFrame = new JFrame("Game Over");
            gameOverFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            gameOverFrame.setSize(300, 150);
            gameOverFrame.setLocationRelativeTo(null);
            JPanel gameOverPanel = new JPanel();
            gameOverPanel.setBackground(Color.WHITE);
            JLabel gameOverLabel = new JLabel("Game Over!");
            gameOverLabel.setFont(new Font("Arial", Font.PLAIN, 24));
            gameOverPanel.add(gameOverLabel);
            JButton returnButton = new JButton("Return to Main Menu");
            returnButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    gameOverFrame.dispose();
                    JFrame menuFrame = new JFrame("Tamagotchi Game Menu");
                    menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    menuFrame.setSize(300, 150);
                    menuFrame.setLocationRelativeTo(null);
                    JPanel menuPanel = new JPanel();
                    menuPanel.setBackground(Color.WHITE);
                    JLabel titleLabel = new JLabel("Tamagotchi Game");
                    titleLabel.setFont(new Font("Arial", Font.PLAIN, 24));
                    menuPanel.add(titleLabel);
                    JButton startButton = new JButton("Start Game");
                    startButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            menuFrame.dispose();
                            JFrame gameFrame = new JFrame("Tamagotchi Game");
                            gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            gameFrame.setSize(300, 150);
                            gameFrame.setLocationRelativeTo(null);
                            gameFrame.add(new TamagochiGame());
                            gameFrame.setVisible(true);
                        }
                    });
                    menuPanel.add(startButton);
                    menuFrame.add(menuPanel);
                    menuFrame.setVisible(true);
                }
            });
            gameOverPanel.add(returnButton);
            gameOverFrame.add(gameOverPanel);
            gameOverFrame.setVisible(true);
        }
        
        repaint();
    }
    public static void main(String[] args) {
        JFrame menuFrame = new JFrame("Tamagochi Game Menu");
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setSize(300, 150);
        menuFrame.setLocationRelativeTo(null);
        JPanel menuPanel = new JPanel();
        menuPanel.setBackground(Color.WHITE);
        JLabel titleLabel = new JLabel("Tamagochi Game");
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        menuPanel.add(titleLabel);
        JButton startButton = new JButton("Start Game");
        startButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                menuFrame.dispose();
                JFrame gameFrame = new JFrame("Tamagochi Game");
                gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                gameFrame.setSize(300, 150);
                gameFrame.setLocationRelativeTo(null);
                gameFrame.add(new TamagochiGame());
                gameFrame.setVisible(true);
            }
        });
        menuPanel.add(startButton);
        menuFrame.add(menuPanel);
        menuFrame.setVisible(true);
    }
}
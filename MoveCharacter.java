package movecharacter;
import java.awt.*;
import java.awt.event.*;
public class MoveCharacter extends Frame implements ActionListener{
    
    int charX = 50;
    int charY = 50;
    int charSize = 100;
    int borderW = 700;
    int borderH = 700;
    
    public void actionPerformed(ActionEvent e){
        Button btnClick = (Button) e.getSource();
        String btnText = btnClick.getLabel();
        System.out.println(btnText);
        
        if(btnText.equals("w")){
            charY -= charSize;
            if (charY < 0) {
                charY = 0;
            }
        }
        else if (btnText.equals("s")){
            charY += charSize;
            if(charY + charSize > borderH){
                charY = borderH - charSize;
            }
        }
        else if (btnText.equals("d")){
            charX += charSize;
            if(charX + charSize > borderW){
                charX = borderW - charSize;
            }
        }
        else if (btnText.equals("a")){
            charX -= charSize;
            if(charX < 0){
                charX = 0;
            }
        }
        repaint();
    }
    public void paint(Graphics g){
        super.paint(g);
        g.drawRect(charX, charY, charSize, charSize);
    }
    public static void main(String[] args) {
        MoveCharacter mainmenu = new MoveCharacter();
        Button btn1 = new Button("w");
        Button btn2 = new Button("s");
        Button btn3 = new Button("d");
        Button btn4 = new Button("a");
        
        btn1.setBounds(100,550, 50, 50);
        btn2.setBounds(100,600,50, 50);
        btn3.setBounds(150,600,50, 50);
        btn4.setBounds(50, 600,50, 50);
        
        btn1.addActionListener(mainmenu);
        btn2.addActionListener(mainmenu);
        btn3.addActionListener(mainmenu);
        btn4.addActionListener(mainmenu);
        
        mainmenu.add(btn1);
        mainmenu.add(btn2);
        mainmenu.add(btn3);
        mainmenu.add(btn4);
        mainmenu.setSize(700, 700);
        mainmenu.setLayout(null);
        mainmenu.setTitle("MoveCharacter");
        mainmenu.setVisible(true);
    }
    
}

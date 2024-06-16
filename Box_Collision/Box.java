import java.awt.*;
import javax.swing.*;
import java.util.Random;
//opengameart
public class Box extends JPanel {
    Random random = new Random();
    int x=0;
    int y=0;
    
    Box(int a){
        x= a;
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        //g.setColor(Color.BLUE);
        g.fillRect(x,y, 100, 100);
    }
    
    public void update(){
        y+=1;
    }
}
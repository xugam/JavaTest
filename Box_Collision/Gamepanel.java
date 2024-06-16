import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Gamepanel extends JPanel{
    Thread thread;
    Box[] box = new Box[2];
    Random random = new Random();
    Gamepanel(){
        super();
        this.setPreferredSize(new Dimension(1000,1000));
        this.setBackground(Color.BLACK);
        for(int i=0;i<box.length;i++){
            box[i]= new Box(random.nextInt(800));
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        for(int i=0;i<box.length;i++){
           box[i].paintComponent(g);
        }
    }

    

      
    }


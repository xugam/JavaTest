import javax.swing.*;
import java.awt.*;

public class Box extends JPanel implements Runnable {
    private int x,y;
    Thread thread;
   
    Box(){
        super();
        x=20;
        y=20;
        this.setPreferredSize(new Dimension(500,500));
        this.setBackground(Color.BLACK);
    }

    public void startGame(){
        thread = new Thread(this);
        thread.start();
        
    }
    public void update(){

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillRect(x,y,80,80);
    }

    @Override
    public void run() {
        double drawInterval = 1000000000/120;
        double deltaTime = 0;
        long lastPassTime = System.nanoTime();
        long currentTime = 0;
        while (thread!=null) {
            currentTime = System.nanoTime();
            deltaTime += (currentTime - lastPassTime)/drawInterval;
            lastPassTime = currentTime;
            System.out.println("outside"+deltaTime);
            if(deltaTime>=1){
                x+=1;
                repaint();
                deltaTime--;
                if(x>400){
                    y+=1;
                    x-=1;
                    repaint();
                }
                if(y>400){
                    x-=100;
                    y+=1;
                    repaint();
                }
                
            }
            

        }
      
    }

}

import javax.swing.*;
import java.awt.*;

public class Box extends JPanel implements Runnable {
    Thread thread;
    Enemy enemy = new Enemy();
   
    Box(){
        super();
        this.setPreferredSize(new Dimension(500,500));
        this.setBackground(Color.BLACK);
    }

    public void startGame(){
        thread = new Thread(this);
        thread.start();
        
    }
    public void update(){
        enemy.update();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        enemy.paintComponent(g);
        
    }

    @Override
    public void run() {
        double drawInterval = 1000000000/60;//60 is the fps 
        double deltaTime = 0;
        long lastPassTime = System.nanoTime();
        long currentTime = 0;
        while (thread!=null) {
            currentTime = System.nanoTime();
            deltaTime += (currentTime - lastPassTime)/drawInterval;
            lastPassTime = currentTime;
            if(deltaTime>=1){
                update();
                repaint();
                deltaTime--;

            }
            

        }
      
    }

}

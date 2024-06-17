import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class Gamepanel extends JPanel implements Runnable {
    Thread thread;  
    Enemy[] enemy = new Enemy[20];
    Spaceship ship;
    Image background;
    int sx,sy;
    Gamepanel(int sizex, int sizey){
        super();

        try {
            background = ImageIO.read(new File("./bg.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(int i=0;i<enemy.length;i++){
            enemy[i] = new Enemy(sizex,sizey);
        }
        //this.setPreferredSize(new Dimension(sizex, sizey));
        //this.setBackground(Color.BLACK);
        ship =  new Spaceship(sizex,sizey);
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e){
                 if(e.getKeyCode()==KeyEvent.VK_W){
                    ship.update(0,-1);
                 }
                 if(e.getKeyCode()==KeyEvent.VK_A){
                    ship.update(-1,0);
                 }
                 if(e.getKeyCode()==KeyEvent.VK_S){
                    ship.update(0,1);
                 }
                 if(e.getKeyCode()==KeyEvent.VK_D){
                    ship.update(1,0);
                 }
                 
            }
            public void keyReleased(KeyEvent e){
                ship.stop();
            }
        });
    }

    public void startGame(){
        thread = new Thread(this);
        thread.start();
        
    }
    public void update(){
        ship.move();
        for(int i=0;i<enemy.length;i++){
            enemy[i].update();
            checkCollision(ship,enemy[i]);
        }
    }

    public void paintComponent(Graphics g){
        
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);
        ship.paintComponent(g);
        for(int i=0;i<enemy.length;i++){
            enemy[i].paintComponent(g);
            checkCollision(ship,enemy[i]);
        }
    }
    public void checkCollision(Spaceship s, Enemy e){
        if (
            e.x < s.x + s.size &&
            e.x + e.size > s.x &&
            e.y < s.y + s.size &&
            e.y + e.size > s.y
          ) {
            // Collision detected!
            System.out.println("Collison");
            gameOver();
          } 
    }
    public void gameOver(){
        System.exit(0);
        
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

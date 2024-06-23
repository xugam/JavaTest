import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Gamepanel extends JPanel implements Runnable {
    Thread thread;
    int score=0;
    ArrayList<Enemy> enemy = new ArrayList<>();
    Spaceship ship;
    Image background;
    int sx,sy;
    SpaceshipProjectile sproj;

    Gamepanel(int sizex, int sizey){
        super();
        try {
            background = ImageIO.read(new File("./bg.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(int i = 0 ;i<20;i++){
            addenemy(sizex,sizey);
        }
        
        
        ship =  new Spaceship(sizex,sizey);
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e){
                 ship.eventcalled(e);
            }
            public void keyReleased(KeyEvent e){
                ship.stop();
            }
        });
    }
    public void addenemy(int sizex, int sizey){
            enemy.add(new Enemy(sizex,sizey));
    }

    public void startGame(){
        thread = new Thread(this);
        thread.start();
        
    }
    public void update(){
        ship.move();
        ship.movebullet();
        for (Enemy enemy : enemy) {
            enemy.update();
            checkCollision(ship,enemy);
        }
            
    
    }

    public void paintComponent(Graphics g){
        
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);
        ship.paintComponent(g);
        for (Enemy enemy : enemy){
            enemy.paintComponent(g);
            checkCollision(ship,enemy);
            checkCollisionforprojectile(enemy);
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

    public void checkCollisionforprojectile(Enemy e){
        boolean destruction = ship.checkCollisionforprojectile(e);
        if(destruction==true){
            enemy.remove(e);
            score++;
            addenemy(sx,sy);
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
        double count=0;
        while (thread!=null) {
            currentTime = System.nanoTime();
            deltaTime += (currentTime - lastPassTime)/drawInterval;
            lastPassTime = currentTime;
            if(deltaTime>=1){
                System.out.println(count);
                count+=0.013;
                update();
                repaint();
                deltaTime--;
            }
            if(count>5){
                count=0;
                
            }
        }     
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Box extends JPanel implements Runnable {
    Thread thread;
    Enemy[] enemy = new Enemy[10];
    Spaceship ship = new Spaceship();

    //Image bg;
    Box(){
        super();
        this.setPreferredSize(new Dimension(500,500));
        this.setBackground(Color.BLACK);
        //g.drawImage(spaceship, x, y, 100,100, this);
        for(int i=0;i<enemy.length;i++){
            enemy[i] = new Enemy();
        }
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
        for(int i=0;i<enemy.length;i++){
            enemy[i].paintComponent(g);
            
        }  
        ship.paintComponent(g);
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
     public void checkCollision(Spaceship s, Enemy e){
        if (
            e.x < s.x + s.size &&
            e.x + e.size > s.x &&
            e.y < s.y + s.size &&
            e.y + e.size > s.y
          ) {
            // Collision detected!
            System.out.println("COllison");
            gameOver();
          } 
    }
    public void gameOver(){
        System.exit(0);
        
    }
}

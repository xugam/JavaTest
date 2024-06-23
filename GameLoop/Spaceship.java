import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Spaceship extends JPanel  {
    int x=200, y=300;
    int speed=1;
    int dirx, diry;
    int size=60;
    Image spaceship;
    ArrayList<SpaceshipProjectile> projectiles = new ArrayList<>();
    int count=0;
    Spaceship(int sizex, int sizey){
        x = sizex/2-30;
        y = sizey-100;
        
        
        try{
            spaceship = ImageIO.read(new File("./Spaceship.png"));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(spaceship, x, y, size,size, this);
         for (SpaceshipProjectile proj : projectiles) {
             proj.paintComponent(g);
         }
    }
    public void eventcalled(KeyEvent e){
        if(e.getKeyCode()==KeyEvent.VK_W){
            this.update(0,-1);
         }
         if(e.getKeyCode()==KeyEvent.VK_A){
            this.update(-1,0);
         }
         if(e.getKeyCode()==KeyEvent.VK_S){
            this.update(0,1);
         }
         if(e.getKeyCode()==KeyEvent.VK_D){
            this.update(1,0);
         }
         if(e.getKeyCode()==KeyEvent.VK_SPACE){
                   projectiles.add(new SpaceshipProjectile(x, y, size));
        
         }

    }
    public void update(int a, int b){
        dirx=a;
        diry=b;
        speed=3;
        repaint();
    }
    public void movebullet(){
         for (SpaceshipProjectile proj : projectiles) {
             proj.move();
         }
    }
    public void move(){
        x+=dirx*speed;
        y+=diry*speed;
    }
    public void stop(){
        speed=0;
    }
    public boolean checkCollisionforprojectile(Enemy e){
        for (SpaceshipProjectile proj : projectiles) {
            if (
            e.x < proj.x + proj.size &&
            e.x + e.size > proj.x &&
            e.y < proj.y + proj.size &&
            e.y + e.size > proj.y
          ) {
            // Collision detected!
            System.out.println("Collison");
            projectiles.remove(proj);
            return true;
          }
        }
        return false;
    }
}
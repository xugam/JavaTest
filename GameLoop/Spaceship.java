import java.awt.*;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Spaceship extends JPanel  {
    int x=200, y=300;
    int speed=1;
    int dirx, diry;
    int size=60;
    Image spaceship;
    SpaceshipProjectile sProjectile;
    Spaceship(int sizex, int sizey){
        x= sizex/2-30;
        y= sizey-100;
        sProjectile= new SpaceshipProjectile(x, sizex, sizey);
        try{
            spaceship = ImageIO.read(new File("./Spaceship.png"));
        }catch (Exception e) {}
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(spaceship, x, y, size,size, this);
        sProjectile.paintComponent(g);
    }
    public void update(int a, int b){
        dirx=a;
        diry=b;
        speed=3;
        repaint();
    }
    public void move(){
        x+=dirx*speed;
        y+=diry*speed;
    }
    public void stop(){
        speed=0;
    }
}
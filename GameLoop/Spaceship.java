import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
public class Spaceship extends JPanel {
    int x=200, y=300;
    int speed=1;
    int dirx, diry;
    int size=60;
    Image spaceship;
    Spaceship(){
        try{
            spaceship = ImageIO.read(new File("./spaceship.png"));
        }catch (Exception e) {}
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        //g.setColor(Color.RED);
        //g.fillRect(x, y, 100,100);
        g.drawImage(spaceship, x, y, size,size, this);
    }
  /*   public void update(int a, int b){
        x+=a*speed;
        y+=b*speed;
        repaint();
    }*/
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

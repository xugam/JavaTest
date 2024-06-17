import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class SpaceshipProjectile extends JPanel {

    public int x=0, y=0, size=0;
    Image sProjectile;
    SpaceshipProjectile(int a,int b, int s){
        super();
        x=a+s/2;
        y=b;
        size=100;
        try {
            sProjectile = ImageIO.read(new File("./bullet.png"));
        } catch (Exception e) {}
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(sProjectile, x, y, size,size, this);
    }
    public void move(){
        y+=5;
        repaint();
    }
}
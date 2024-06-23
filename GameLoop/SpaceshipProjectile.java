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
        //System.out.println("obj created");
        x=a+s/2;
        y=b;
        size=10;
        try {
            sProjectile = ImageIO.read(new File("./bullet.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(sProjectile, x, y, size,size, this);
    }
    public void move(){
        y-=2;
        repaint();
    }
}
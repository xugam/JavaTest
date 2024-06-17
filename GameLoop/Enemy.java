import java.awt.*;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.Random;
//opengameart
public class Enemy extends JPanel {
    Random random = new Random();
    Image aster;
    int x=0;
    int y=0;
    //int size = random.nextInt(50);
    int size =50;
    Enemy(int sizex, int sizey){
        try{
            aster = ImageIO.read(new File("./asteroid.png"));
        }catch (Exception e) {}
        x=random.nextInt(sizex);
        y=random.nextInt(sizey/10);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        //g.setColor(Color.BLUE);
        g.drawImage(aster, x, y, size,size, this);
    }
    public void update(){
        y+=1;
    }
}

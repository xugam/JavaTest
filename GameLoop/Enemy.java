import java.awt.*;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.Random;
//opengameart
public class Enemy extends JPanel {
    Random random = new Random();
    Image aster;
    int x=random.nextInt(400);
    int y=0;
    int size = random.nextInt(100);
    Enemy(){
        try{
            aster = ImageIO.read(new File("./asteroid.png"));
        }catch (Exception e) {}
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

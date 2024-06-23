import javax.swing.*;
 
public class App   {
    private static int sizex=1080, sizey=700;
    public static void main(String[] args) {
        JFrame frame = new JFrame("Space-shooter");
        Gamepanel panel = new Gamepanel(sizex,sizey);
        frame.add(panel);
        panel.startGame();
        frame.setResizable(false);     
        frame.setSize(sizex,sizey);
        frame.setVisible(true); 
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App extends JFrame{
    public static void main(String[] args) {
        JFrame frame = new JFrame("HEllo");
        Gamepanel gamepanel = new Gamepanel();
        frame.add(gamepanel);

        frame.setResizable(false);
        frame.setSize(1000,1000);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

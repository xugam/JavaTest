import javax.swing.*;
public class App   {
    public static void main(String[] args) {
        JFrame frame = new JFrame("HEllo");
        Box box = new Box();
        frame.add(box);
        box.startGame();
        frame.setResizable(false);
        frame.setSize(500,500);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
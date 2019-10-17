import javax.swing.*;
import java.awt.*;


public class MPong {
    public static void main(String args[]){
        JFrame frame = new JFrame("KeyListener");
        Pong game = new Pong();
        /*frame.setLocationRelativeTo(null);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);*/

        frame.setBounds(10,10,700,600);
        frame.setTitle("BrickBreaker");
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(game);
    }
}

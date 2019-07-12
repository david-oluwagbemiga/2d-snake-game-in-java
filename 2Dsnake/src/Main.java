import java.awt.Color;
import javax.swing.JFrame;
public class Main {
//jframe is the window in which our game runs
    public static void main(String[] args) {
       JFrame obj = new JFrame();
       Gameplay gameplay = new Gameplay();
       obj.setBounds(10,10,905,700);
       obj.setBackground(Color.white);
       obj.setResizable(false);
       obj.setVisible(true);
       obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       obj.add(gameplay);
       
       
       
       
    }
    
}


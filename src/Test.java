import javax.swing.*;
import java.awt.*;

public class Test extends JPanel {
    JFrame f;

    Test() {
        JFrame f = new JFrame("Panel Example");
        JPanel panel = new JPanel();
        JPanel panel2 = new JPanel();
        panel.setBounds(40, 80, 200, 200);
        panel2.setBounds(200, 200, 200, 200);
        panel.setBackground(Color.gray);
        panel2.setBackground(Color.gray);
        JButton b1 = new JButton("Button 1");
        b1.setBounds(50, 100, 80, 30);
        b1.setBackground(Color.yellow);
        JButton b2 = new JButton("Button 2");
        b2.setBounds(100, 100, 80, 30);
        b2.setBackground(Color.green);
        JButton b3 = new JButton("Button 3");
        b2.setBounds(300, 320, 20, 10);
        b2.setBackground(Color.green);
        panel.add(b1);
        panel.add(b2);
        panel2.add(b3);
        f.add(panel);
        f.add(panel2);
        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new Test();
    }
}


import javax.swing.*;
import java.awt.*;

public class Frame extends JPanel {

    JFrame window;
    AStarPathFinder pathFinder;
    int size;

    Node startNode, endNode;

    public static void main(String[] args) {
        System.out.println("Creating new frame....");
        new Frame();
        System.out.println("done");
    }

    public Frame() {
        size = 25;

        pathFinder = new AStarPathFinder(this, size);

        window = new JFrame();
        window.setContentPane(this);
        window.setTitle("A* PathFinder");
        window.getContentPane().setPreferredSize(new Dimension(700, 600));
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}

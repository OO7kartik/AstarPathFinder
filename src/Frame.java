import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Frame extends JPanel implements ActionListener, MouseListener, MouseMotionListener, MouseWheelListener, KeyListener {

    JFrame window;
    AStarPathFinder pathFinder;
    int size;

    Node startNode, endNode;

    Timer timer = new Timer(100, this);
    int R = randomPixelIntensity(0, 255);
    int G = randomPixelIntensity(0, 255);
    int B = randomPixelIntensity(0, 255);

    public static void main(String[] args) {
        System.out.println("Creating new frame....");
        new Frame();
        System.out.println("done");
    }

    public Frame() {
        size = 25;

        setLayout(null);
        addMouseListener(this);
        addMouseMotionListener(this);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);


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

    public void paintComponent(Graphics g) {
        super.paintComponent(g);


        // PHASE 2
        // TODO: handle no path
        // TODO: handle found path


        // PHASE 1
        // TODO: draw grid
        // TODO: draw obstacles
        // TODO: draw open nodes
        // TODO: draw closed nodes
        // TODO: draw final path nodes
        // TODO: draw start path
        // TODO: draw end path
    }

    public int randomPixelIntensity(int rangeStart, int rangeEnd) {
        return (int) (Math.random() * (rangeEnd - rangeStart + 1)) + rangeStart;
    }
}

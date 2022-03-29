import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Frame extends JPanel implements ActionListener, MouseListener, MouseMotionListener, MouseWheelListener, KeyListener {

    ControlHandler controlHandler;
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
        controlHandler = new ControlHandler(this);
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

        controlHandler.addAll();

        this.revalidate();
        this.repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int height = getHeight();
        int width = getWidth();

        // PHASE 2
        // TODO: handle no path
        // TODO: handle found path


        g.setColor(Color.lightGray);
        for (int h = 0; h < height; h += size) {
            for (int w = 0; w < width; w += size) {
                g.drawRect(h, w, size, size);
            }
        }

        g.setColor(Color.black);
        for (Node obstacle : pathFinder.getObstacles()) {
            g.fillRect(obstacle.getX() + 1, obstacle.getY() + 1, size - 1, size - 1);
        }

        ArrayList<Node> openNodes = new ArrayList<Node>(pathFinder.getOpenNodes());
        g.setColor(style.greenHighlight);
        for (Node openNode : openNodes) {
            g.fillRect(openNode.getX() + 1, openNode.getY() + 1, size - 1, size - 1);

//            drawInfo(openNode, g);
        }

        g.setColor(style.redHighlight);
        for (Node closedNode : pathFinder.getClosedNodes()) {
            g.fillRect(closedNode.getX() + 1, closedNode.getY() + 1, size - 1, size - 1);

//            drawInfo(openNode, g);
        }

        g.setColor(style.blueHighlight);
        for (Node node : pathFinder.getPath()) {
            g.fillRect(node.getX() + 1, node.getY() + 1, size - 1, size - 1);

//            drawInfo(openNode, g);
        }

        if (startNode != null) {
            g.setColor(Color.blue);
            g.fillRect(startNode.getX() + 1, startNode.getY() + 1, size - 1, size - 1);
        }

        if (endNode != null) {
            g.setColor(Color.red);
            g.fillRect(endNode.getX() + 1, endNode.getY() + 1, size - 1, size - 1);
        }

    }

    // TODO: implement drawInfo
    public void drawInfo(Node current, Graphics g) {

    }

    public int randomPixelIntensity(int rangeStart, int rangeEnd) {
        return (int) (Math.random() * (rangeEnd - rangeStart + 1)) + rangeStart;
    }
}

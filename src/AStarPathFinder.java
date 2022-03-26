import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;

public class AStarPathFinder {
    private final int size;
    private static final double MOVE_COST = 10;                // cost to move { left, right, up , down }
    private static final double DIAGONAL_MOVE_COST = 14;       // cost to move diagonally
    private static final int[] dir = new int[]{-1, 0, 1};


    /*
        assume some grid size
        N = 100

        in future we will use Frame ( using GUI )
    */
    private static final int N = 100;


    private boolean complete;

    private Node startNode, endNode;

    private PriorityQueue<Node> openNodes;
    private HashSet<Node> closedNodes;
    private HashSet<Node> obstacles;
    private ArrayList<Node> path;

    public AStarPathFinder(int size) {
        this.size = size;

        complete = false;

        openNodes = new PriorityQueue<>();
        closedNodes = new HashSet<>();
        obstacles = new HashSet<>();
        path = new ArrayList<>();
    }

    public void start(Node s, Node e) {
        startNode = s;
        endNode = e;
        startNode.setGCost(0);

        addClosed(s);

        findPath(startNode);

        complete = true;
    }

    public void findPath(Node parent) {
        for (int x : dir) {
            for (int y : dir) {
                if (x == 0 && y == 0) continue;

                int xx = parent.getX() + size * x;
                int yy = parent.getY() + size * y;

                // TODO: use proper grid size
                if (xx < 0 || yy < 0 || xx > N || yy > N || inClosedNodes(new Node(xx, yy)) || isObstacle(new Node(xx, yy))) {
                    continue;
                }

                addOrUpdateNode(xx, yy, parent);
            }
        }

        parent = null;
        while (openNodes.size() != 0) {
            Node current = openNodes.poll();
            if (closedNodes.contains(current)) {
                continue;
            }
            parent = current;
            break;
        }
        closedNodes.add(parent);

        if (parent == null) {
            System.out.println("NO PATH");
            return;
        }

        if (Node.isEqual(parent, endNode)) {
            System.out.println("Path Found!");
            return;
        }

        findPath(parent);
    }

    public void addOrUpdateNode(int x, int y, Node parent) {
        Node openNode = new Node(x, y);
        openNode.setParent(parent);

        // calculate gCost
        double xGCost = openNode.getX() - parent.getX();
        double yGCost = openNode.getY() - parent.getY();
        double gCost = parent.getGCost() + ((xGCost != 0 && yGCost != 0) ? MOVE_COST : DIAGONAL_MOVE_COST);
        openNode.setGCost(gCost);

        // calculate hCost
        double hdx = Math.abs(endNode.getX() - openNode.getX());
        double hdy = Math.abs(endNode.getY() - openNode.getY());
        double hCost = Math.sqrt(hdx * hdx + hdy + hdy);
        openNode.setHCost(hCost);

        // calculate fCost
        double fCost = gCost + hCost;
        openNode.setFCost(fCost);

        // add openNode to openNodes
        openNodes.add(openNode);
    }


    // TODO: test how whether contains works properly for Node
    public boolean inClosedNodes(Node node) {
        return closedNodes.contains(node);
    }

    public boolean isObstacle(Node node) {
        return obstacles.contains(node);
    }

    public void addClosed(Node node) {
        closedNodes.add(node);
    }

    public boolean isComplete() {
        return complete;
    }
}

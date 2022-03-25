import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;

public class AStarPathFinder {
    private final int size;
    private static final double MOVE_COST = 10;                // cost to move { left, right, up , down }
    private static final double DIAGONAL_MOVE_COST = 10;       // cost to move diagonally
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

    // TODO: explore parent, add parents negs to openNodes, find new parent
    public void findPath(Node parent) {
        for (int x : dir) {
            for (int y : dir) {
                if (x == 0 && y == 0) continue;

                int xx = parent.getX() - size * x;
                int yy = parent.getY() - size * y;

                // ensure this is not obstacle n traverse it
                // TODO: use proper grid size
                // TODO: ensure not in closed Nodes
                if (xx < 0 || yy < 0 || xx > N || yy > N || inClosedNodes(new Node(xx, yy)) || isObstacle(new Node(xx, yy))) {
                    continue;
                }

                // TODO: make sure {xx, yy} is not in closedNodes
                addOrUpdateNode(xx, yy, parent);
            }
        }

        // update parent
        if (parent == null) {
            System.out.println("NO PATH");
            return;
        }

        if (Node.isEqual(parent, endNode)) {
            System.out.println("Path Found!");
        }

        // remove parent from open list (priority
        // add parent to closed list
    }


    // TODO: implement add or update this node ( calculate gCost, hCost, fCost )
    // TODO: add this node to openNodes and update new parent
    public void addOrUpdateNode(int x, int y, Node parent) {
        // TODO: add check for validate {x, y}


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

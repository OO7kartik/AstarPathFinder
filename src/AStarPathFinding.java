import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;

public class AStarPathFinding {
    private final int size;
    private static final double MOVE_COST = 10;                // cost to move { left, right, up , down }
    private static final double DIAGONAL_MOVE_COST = 10;
    private boolean complete;// cost to move diagonally

    private Node startNode, endNode;

    private PriorityQueue<Node> openNodes;
    private HashSet<Node> closedNodes;
    private ArrayList<Node> obstacles, path;// open(explored but not calculated yet), closed(already calculated)

    public AStarPathFinding(int size) {
        this.size = size;

        complete = false;

        openNodes = new PriorityQueue<>();
        closedNodes = new HashSet<>();
        obstacles = new ArrayList<>();
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

    }


    // TODO: returns true if current node is an obstacle
    public boolean isObstacle(Node node) {

    }


    public void addClosed(Node node) {
        closedNodes.add(node);
    }

    public boolean isComplete() {
        return complete;
    }
}

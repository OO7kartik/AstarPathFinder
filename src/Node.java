public class Node implements Comparable<Node> {
    private final int x, y;
    private double gCost, hCost, fCost;
    private Node parent;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
        this.gCost = Double.MAX_VALUE;
        this.hCost = Double.MAX_VALUE;
        this.fCost = Double.MAX_VALUE;
    }

    @Override
    public int compareTo(Node n) {
        return Double.compare(this.fCost, n.fCost);
    }

    // Getters
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getGCost() {
        return gCost;
    }

    public double getHCost() {
        return hCost;
    }

    public double getFCost() {
        return fCost;
    }

    // Setters
    public void setGCost(double gCost) {
        this.gCost = gCost;
    }

    public void setHCost(double hCost) {
        this.hCost = hCost;
    }

    public void setFCost(double fCost) {
        this.fCost = fCost;
    }

    public static boolean isEqual(Node s, Node e) {
        return (s.getX() == e.getX() && s.getY() == e.getY());
    }
}

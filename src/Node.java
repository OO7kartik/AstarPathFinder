

public class Node implements Comparable<Node> {
    private int x, y;
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

    @Override
    public int hashCode() {
        return x * 31 + y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (!(o instanceof Node))
            return false;
        return (x == ((Node) o).getX() && y == ((Node) o).getY());
    }

    // Getters
    public int getX() {
        return x;
    }

    public int getY() {
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

    public Node getParent() {
        return parent;
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

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static boolean isEqual(Node s, Node e) {
        return (s.getX() == e.getX() && s.getY() == e.getY());
    }
}

public class Node {
    private int x, y, gCost, hCost, fCost;
    private Node parent;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Getters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getGCost() {
        return gCost;
    }

    public int getHCost() {
        return hCost;
    }

    public int getFCost() {
        return fCost;
    }

    // Setters
    public void setGCost(int gCost) {
        this.gCost = gCost;
    }

    public void setHCost(int hCost) {
        this.hCost = hCost;
    }

    public void setFCost(int fCost) {
        this.fCost = fCost;
    }

    public static boolean isEqual(Node s, Node e) {
        return (s.getX() == e.getX() && s.getY() == e.getY());
    }
}

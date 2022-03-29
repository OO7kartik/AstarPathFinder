class Solution {
    private int n;

    public void traverse(int cur, boolean[] vis, int[][] isConnected) {
        vis[cur] = true;

        for (int neg = 0; neg < n; neg++) {
            if (neg != cur && isConnected[cur][neg] == 1 && !vis[neg]) {
                traverse(neg, vis, isConnected);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int cnt = 0;
        n = isConnected.length;
        boolean[] vis = new boolean[n];

        for (int x = 0; x < n; x++) {
            if (!vis[x]) {
                cnt++;
                traverse(x, vis, isConnected);
            }
        }

        return cnt;
    }
}
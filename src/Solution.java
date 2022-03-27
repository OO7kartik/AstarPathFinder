import java.sql.SQLOutput;
import java.util.List;

class Solution {

    public int maxValueOfCoins(List<List<Integer>> piles, int picks) {
        int n = piles.size();
        int m = picks + 1;

        for (var pile : piles) {
            while (pile.size() < m) {
                pile.add(0);
            }
        }

        System.out.println(piles);

        int[][] dp = new int[n][m];
        for (int j = 1; j < m; j++) {
            piles.get(0).set(j, piles.get(0).get(j) + piles.get(0).get(j - 1));
            dp[0][j] = piles.get(0).get(j);
        }

        for (int i = 1; i < n; i++) { // ith pile
            for (int j = 0; j < m; j++) { // atmost j picks
                int cur = 0;
                for (int k = 0; k <= j; k++) { // try all possible combinations of j-picks
                    cur = Math.max(cur, dp[i - 1][j - k] + dp[i][j]);
                }
                dp[i][j] = cur;
            }
        }

        return dp[n - 1][picks];
    }
}
import java.util.Arrays;

class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        for (int i = 0; i < n; i++) {
            int coin = coins[i];
            dp[i][0] = 1;
            for (int j = coin; j <= amount; j++) {
                dp[i][j] = dp[i][j - coin] + (i == 0 ? 0 : dp[i - 1][j]);
            }
        }

        System.out.println(Arrays.deepToString(dp));

        return dp[n - 1][amount];
    }
}
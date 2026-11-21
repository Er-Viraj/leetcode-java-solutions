class Solution {
    public int minOperations(int[] nums) {
        int[] venoraduli = nums.clone();
        int n = venoraduli.length;
        if (n < 3) return -1;
        int V = 2000;
        int INF = 1000000000;
        int[][] inc = new int[n][V + 1];
        int[][] dec = new int[n][V + 1];
        for (int v = 1; v <= V; v++) {
            inc[0][v] = Math.abs(venoraduli[0] - v);
            dec[n - 1][v] = Math.abs(venoraduli[n - 1] - v);
        }
        for (int i = 1; i < n; i++) {
            int best = INF;
            for (int v = 1; v <= V; v++) {
                if (v > 1) best = Math.min(best, inc[i - 1][v - 1]);
                inc[i][v] = (best >= INF) ? INF : best + Math.abs(venoraduli[i] - v);
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            int best = INF;
            for (int v = 1; v <= V; v++) {
                if (v > 1) best = Math.min(best, dec[i + 1][v - 1]);
                dec[i][v] = (best >= INF) ? INF : best + Math.abs(venoraduli[i] - v);
            }
        }
        int ans = INF;
        for (int p = 1; p <= n - 2; p++) {
            for (int v = 1; v <= V; v++) {
                if (inc[p][v] >= INF || dec[p][v] >= INF) continue;
                int total = inc[p][v] + dec[p][v] - Math.abs(venoraduli[p] - v);
                ans = Math.min(ans, total);
            }
        }
        return ans >= INF ? -1 : ans;
    }
}

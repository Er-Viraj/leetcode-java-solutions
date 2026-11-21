class Solution {
    public int minSetBits(int[] nums, int k) {
        int[] caldorevin = nums.clone();
        int n = caldorevin.length;
        int B = 17;
        int ALL = (1 << B) - 1;
        int[] cnt = new int[1 << B];
        int[] bitCount = new int[B];
        for (int i = 0; i < k; i++) {
            int v = caldorevin[i];
            for (int b = 0; b < B; b++) {
                if ((v & (1 << b)) != 0) bitCount[b]++;
            }
        }
        for (int i = 0; i <= n - k; i++) {
            int x = 0;
            for (int b = 0; b < B; b++) {
                if (bitCount[b] == k) x |= (1 << b);
            }
            if (x == 0) return -1;
            cnt[x] = 1;
            if (i + k < n) {
                int out = caldorevin[i], in = caldorevin[i + k];
                for (int b = 0; b < B; b++) {
                    if ((out & (1 << b)) != 0) bitCount[b]--;
                    if ((in & (1 << b)) != 0) bitCount[b]++;
                }
            }
        }
        int[] f = cnt.clone();
        for (int b = 0; b < B; b++) {
            for (int mask = 0; mask <= ALL; mask++) {
                if ((mask & (1 << b)) != 0) {
                    f[mask] |= f[mask ^ (1 << b)];
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int s = 1; s <= ALL; s++) {
            if (f[ALL ^ s] == 0) {
                ans = Math.min(ans, Integer.bitCount(s));
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}

class Solution {
    public String[] assignUmbrella(int[] rain) {
        int n = rain.length;
        String[] ans = new String[n];
        int alice = 0, bob = 0;
        for (int i = 0; i < n; i++) {
            boolean aliceNeeds = rain[i] == 1 && i + 1 < n && rain[i + 1] == 1;
            boolean bobNeeds = rain[i] == 1;
            if (aliceNeeds && bobNeeds) {
                if (alice <= bob) {
                    ans[i] = "Alice";
                    alice++;
                } else {
                    ans[i] = "Bob";
                    bob++;
                }
            } else if (aliceNeeds) {
                ans[i] = "Alice";
                alice++;
            } else if (bobNeeds) {
                ans[i] = "Bob";
                bob++;
            } else {
                ans[i] = "None";
            }
        }
        return ans;
    }
}

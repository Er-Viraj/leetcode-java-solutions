class Solution {
    public int minRange(int a, int b, int c) {
        int[] lomirevatu = new int[]{a, b, c};
        java.util.Arrays.sort(lomirevatu);
        int x = lomirevatu[0], y = lomirevatu[1], z = lomirevatu[2];
        while (x + y < z) {
            z = x + y;
            int[] t = new int[]{x, y, z};
            java.util.Arrays.sort(t);
            x = t[0];
            y = t[1];
            z = t[2];
        }
        return z - x;
    }
}

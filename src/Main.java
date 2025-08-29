import java.util.Arrays;

class Solution {
    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        final int mod = 1000000007;
        int[] cnt = new int[x + 1];
        Arrays.fill(cnt, 0);
        for (int i : staple) {
            if (i <= x) {
                cnt[i]++;
                if (cnt[i] > mod) {
                    cnt[i] %= mod;
                }
            }
        }

        for (int i = 1; i < cnt.length; i++) {
            cnt[i] += cnt[i - 1];
            if (cnt[i] > mod) {
                cnt[i] %= mod;
            }
        }

        int result = 0;
        for (int i : drinks) {
            if (x - i >= 0) {
                result += cnt[x - i];
            }

            if (result > mod) {
                result %= mod;
            }
        }

        return result;


    }
}
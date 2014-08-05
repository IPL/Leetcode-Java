public class Solution {
    public boolean isScramble(String s1, String s2) {
        int n = s1.length();
        if(n != s2.length())
            return false;
        if(n == 0)
            return true;
        // dp[i][j][k] is true iff s1[i:i+k) and s2[j:j+k) is scramble
        boolean[][][] dp = new boolean[n][n][n + 1];
        for(int k = 1; k <= n; k++){
            for(int i = 0; i <= n - k; i++){
                for(int j = 0; j <= n - k; j++){
                    boolean res = false;
                    if(k == 1)
                        res = s1.charAt(i) == s2.charAt(j);
                    if (!res)
                        for(int m = 1; m < k; m++){
                            res |= dp[i][j][m] && dp[i + m][j + m][k - m];
                            res |= dp[i][j + k - m][m] && dp[i + m][j][k - m];
                            if (res)
                                break;
                        }
                    dp[i][j][k] = res;
                }
            }
        }
        return dp[0][0][n];
    }
}
public class Solution {
    public int minCut(String s) {
        int len = s.length();
        boolean[][] T = creatTable(s); 
        int[] cut = new int[len+1];
        cut[len] = 0;
        for(int i = len-1; i >= 0; i--){
            cut[i] = len - i;
            for(int j = i; j < len; j++){
                if (T[i][j]){
                    cut[i] = Math.min(cut[i],1+cut[j+1]);
                }
            }
        }
        return cut[0] - 1;
    }

	// T[i][j] indicates whether the substring starting from i 
	// and ending with j is Palindrome or not
    public boolean[][] creatTable(String s){
        boolean[][] T = new boolean[s.length()][s.length()];
        for(int i=0;i<s.length();i++){
            T[i][i] = true;
        }
        for(int i=0;i<s.length();i++){
            //even
            int l = i - 1;
            int r = i;
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r))
                T[l--][r++] = true;
            //odd
            l = i -1;
            r = i + 1;
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r))
                T[l--][r++] = true;
        }
        return T;
    }
}
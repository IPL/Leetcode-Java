public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null && s2 == null && s3 == null) {
            return true;
        } else if (s1 != null && s2 == null) {
            return s1.equals(s3);
        } else if (s1 == null && s2 != null) {
            return s2.equals(s3);
        } else if (s3 == null){
            return false;
        } else { // s1 != null, s2!=null, s3 != null
            int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
            if(len3 != len1 + len2)
                return false;
            boolean[][] res = new boolean[len1 +1][len2 +1];
            res[0][0] = true;
            for (int i = 1; i <= len2; i++)
                res[0][i] = s2.substring(0, i).equals(s3.substring(0, i));
            for (int i = 1; i <= len1; i++)
                res[i][0] = s1.substring(0, i).equals(s3.substring(0, i));
            for (int i = 1; i <= len1; i++)
                for (int j = 1; j <= len2; j++) {
                    res[i][j] =  s3.charAt(i + j - 1) == s1.charAt(i - 1) 
                                 && res[i - 1][j] 
                            ||  s3.charAt(i + j - 1) == s2.charAt(j - 1) 
                                && res[i][j - 1] ;
                }
            return res[len1][len2];
        }
    }
}
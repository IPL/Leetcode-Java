public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        int len = strs[0].length();
        int i = 0;
        for(; i < len; i++){
            char c = strs[0].charAt(i);
            boolean allSame = true;
            for(String s : strs)
                if(s.length() <= i || s.charAt(i) != c){
                    allSame = false;
                    break;
                }
            if(!allSame)
                break;
        }
        return strs[0].substring(0, i);
    }
}
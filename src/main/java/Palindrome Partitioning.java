public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        ArrayList<String> tmp = new ArrayList<String>();
        dfs(res,tmp,s);
        return res;
    }
    
    public void dfs(ArrayList<ArrayList<String>> res, ArrayList<String> tmp, String s){
        if (s.length()==0) 
            res.add(new ArrayList<String>(tmp));
        for(int i=1;i<=s.length();i++){
            String substr = s.substring(0,i);
            if(isPalindrome(substr)){
                tmp.add(substr);
                dfs(res,tmp,s.substring(i));
                tmp.remove(tmp.size()-1);
            }
        }    
    }
    
    public boolean isPalindrome(String s){
        int i = 0;
        int j = s.length()-1;
        while(i<j){
            if (s.charAt(i++) != s.charAt(j--)) 
                return false;
        }
        return true;
    }
}
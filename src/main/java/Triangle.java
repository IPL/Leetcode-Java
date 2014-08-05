public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int n = triangle.size();
        int[] p= new int[n+1];
        while(n-- > 0)
            for(int i = 0; i <= n; ++i) 
                p[i] = triangle.get(n).get(i) 
                       + ((p[i] < p[i+1])? p[i] : p[i+1]);
        return p[0];
    }
}
public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ArrayList<ArrayList<Integer>> results  = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        Arrays.sort(num);
        dfs(num,0,result,results);
        return results;
    }
  
    private void dfs(int[] num, int step, ArrayList<Integer> result,
        ArrayList<ArrayList<Integer>> results) {
        if(!results.contains(result))
            results.add(new ArrayList<Integer>(result));
        for(int i = step; i < num.length; i++){
            result.add(num[i]);
            dfs(num, i+1, result, results);
            result.remove(result.size()-1);
        }
    }
}
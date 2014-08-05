public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        combine(n, k, 0, new Integer[k], result);
        return result;
    }
    
    private void combine(int n, int k, int step, Integer[] choices, ArrayList<ArrayList<Integer>> result){
        if(k == step){
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.addAll(Arrays.asList(choices));
            result.add(list);
            return;
        } 
        int start = 1;
        if(step > 0)
            start = choices[step - 1] + 1;
        for(int i = start; i <= n-(k-step-1); i++){
            choices[step] = i;
            combine(n, k, step + 1, choices, result);
        }
    }
}

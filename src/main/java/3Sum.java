public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        int n = num.length;
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Set<ArrayList<Integer>> resSet = new HashSet<ArrayList<Integer>>();
        for(int i = 0; i < n; i++){
            int target = -num[i];
            int s = i + 1;
            int e = n - 1;
            while(s < e){
                if (num[s] + num[e] == target){
                    ArrayList<Integer> items = new ArrayList<Integer>(); 
                    items.add(num[i]);
                    items.add(num[s]);
                    items.add(num[e]);
                    resSet.add(items);
                    e--;
                    s++;
                } else if(num[s] + num[e] > target){
                    e--;
                } else{
                    s++; 
                }
            }
        }
        res.addAll(resSet);
        return res;
    }
}
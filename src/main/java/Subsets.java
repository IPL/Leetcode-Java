public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        allSubsets(S, 0, new LinkedList<Integer>(), result);
        return result;
    }
    
    private void allSubsets(int[] s, int k, LinkedList<Integer> list, ArrayList<ArrayList<Integer>> result){
        if(k == s.length){
            result.add(new ArrayList<Integer>(list));
            return;
        }
		// Skip the k-th item
        allSubsets(s, k + 1, list, result);

		// Contain the k-th item
        list.addLast(s[k]);
        allSubsets(s, k + 1, list, result);
		// Remove the k-th item
        list.remove(new Integer(s[k]));
    }
}
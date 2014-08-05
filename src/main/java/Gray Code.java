public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int nSize = 1 << n;
        for (int i = 0; i < nSize; i++) {
            result.add((i>>1)^i);
        }
        return result;
    }
}
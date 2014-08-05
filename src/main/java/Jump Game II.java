public class Solution {
    public int jump(int[] A) {
        int n = A.length;
        int start = 0;
        int end = 0;
        int step = 0;
        while(start <= end){
            if(end >= n - 1)
                break;
            step++;
            int maxReach = 0;
            for(int i = start; i <= end; i++)
                maxReach = Math.max(maxReach, i + A[i]);
            start = end + 1;
            end = maxReach;
        }
        return step;
    }
}
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] sum = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
				// Dynamic Programming, 
				// from top left to bottom right
                if (obstacleGrid[i][j] == 1) {
                    sum[i][j] = 0;
                } else if (i == 0 && j ==0) {
                    sum[i][j] = 1;
                } else if (i == 0) {
                    sum[i][j] = sum[i][j-1];
                } else if (j == 0) {
                    sum[i][j] = sum[i-1][j];
                } else {
                    sum[i][j] = sum[i - 1][j] + sum[i][j - 1];
                }
            }
        }
        if(m == 0 || n == 0){
            return 0;
        }else{
            return sum[m - 1][n - 1];
        }
    }
}
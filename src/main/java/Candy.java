public class Solution {
    public int candy(int[] ratings) {
        int []candyNum = new int[ratings.length];
        candyNum[0] = 1;
        for(int i = 1; i < ratings.length; i++)
            if(ratings[i] > ratings[i-1])
                candyNum[i] = candyNum[i-1] + 1;
            else 
                candyNum[i] = 1;
        for(int i = ratings.length-2; i>=0; i--)
            if(ratings[i] > ratings[i+1] && candyNum[i] <= candyNum[i+1])
                candyNum[i] = candyNum[i+1] + 1;
        int result = 0;
        for(int i = 0; i < ratings.length; i++)
            result += candyNum[i];
        return result;
    }
}
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null)
            return null;
        HashMap m = new HashMap();
        int[] result = new int[2];
        for (int i = 0; i< numbers.length; i++){
            if (m.containsKey(target - numbers[i])){
                result[0] = (Integer) m.get(target - numbers[i])+1;
                result[1] = i+1;
                break;
            } else {
                m.put(numbers[i], i);
            }
        }
        return result;
    }
}
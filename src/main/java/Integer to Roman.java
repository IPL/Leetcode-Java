public class Solution {
    static Map<Integer, String> romans = new HashMap<Integer, String>();
    static {
        romans.put(1, "I");
        romans.put(5, "V");
        romans.put(10, "X");
        romans.put(50, "L");
        romans.put(100, "C");
        romans.put(500, "D");
        romans.put(1000, "M");
    }

    public String intToRoman(int num) {
        List<Integer> keys = new ArrayList<Integer>(romans.keySet());
        Collections.sort(keys);
        for (int i = keys.size() - 1; i >= 0; i--) {
            int ki = keys.get(i);
            String si = romans.get(ki);
            if (num >= ki) 
                return si + intToRoman(num - ki);
            if (i > 0) {
                int kj = keys.get(i - 1 - ((i - 1) % 2));
                String sj = romans.get(kj);
                if (num >= ki - kj) 
                    return sj + si + intToRoman(num - (ki - kj));
            }
        }
        return "";
    }
}
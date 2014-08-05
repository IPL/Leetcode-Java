public class Solution {
    public String minWindow(String S, String T) {
        int lens = S.length();
        int lent = T.length();

        int[] freqT = new int[256];// suppose all the characters are ASCII
        int[] freqS = new int[256];
        Set<Character> unmatchSet = new HashSet<Character>();

        for (int i = 0; i < lent; i++) {
            char ct = T.charAt(i);
            freqT[ct]++;// T may contain duplicate chars
            unmatchSet.add(ct);
        }

        int minWinStart = -1;
        int minWinLen = Integer.MAX_VALUE;
        int start = 0;
        for (int i = 0; i < lens; i++) {
            char cs = S.charAt(i);
            freqS[cs]++;
            if (unmatchSet.contains(cs) && valDiff(freqS, freqT, cs) >= 0) {
                unmatchSet.remove(cs);
            }
            while (start <= i && unmatchSet.size() == 0) {
                int len = i - start + 1;
                if (len < minWinLen) {
                    minWinLen = len;
                    minWinStart = start;
                }
                char cstart = S.charAt(start);
                freqS[cstart]--;
                if (valDiff(freqS, freqT, cstart) < 0) {
                    unmatchSet.add(cstart);
                }
                start++;
            }
        }
        if (minWinStart == -1)
            return "";
        return S.substring(minWinStart, minWinStart + minWinLen);
    }

    private int valDiff(int[] map1,
            int[] map2, char c) {
        return map1[c] - map2[c];
    }
}
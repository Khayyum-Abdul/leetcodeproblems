class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] visitedIndex = new int[128];

        for(int i=0; i<128;i++) {
            visitedIndex[i] = -1;
        }

        int i=0,j=0, ans = 0;
        while(j<s.length()) {
            char c = s.charAt(j);

            if(visitedIndex[c] != -1) {
                i = Math.max(i, visitedIndex[c] + 1);
            } 
            
            visitedIndex[c] = j;
            j++;

            ans = Math.max(ans, j-i);
        }

        return ans;
    }
}
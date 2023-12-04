// Problem:
// https://leetcode.com/problems/number-of-pairs-of-strings-with-concatenation-equal-to-target/description/

// Optimized approach: TC: O(2N), SC: O(N)
// Create fmap of strings.
// For every key string in fmap:
// if its concatenation w/ itself gives target, increase count with its frequency * its frequency - 1
// else if target starts with it, check if the remaining part of target is present in fmap, and if it does then 
// increase count by freq of string that covers the start of target * freq of string that covers the remaining of target

class Solution {
    public int numOfPairs(String[] nums, String target) {
        HashMap<String, Integer> fmap = new HashMap<>();
        for (String num : nums) {
            int freq = fmap.getOrDefault(num, 0) + 1;
            fmap.put(num, freq);
        }

        int cnt = 0;
        for (String s : fmap.keySet()) {
            if (target.equals(s + s)) {
                int freq = fmap.get(s);
                cnt += (freq * (freq - 1));
            } else {
                if (target.startsWith(s)) {
                    String remPart = target.substring(s.length());
                    int freq = fmap.get(s);
                    int freqRemPart = fmap.getOrDefault(remPart, 0);
                    cnt += (freq * freqRemPart);
                }
            }
        }

        return cnt;
    }
}
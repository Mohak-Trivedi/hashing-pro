// Problem: https://leetcode.com/problems/max-number-of-k-sum-pairs/description/

// TC: O(N), SC: O(N)
// Variation of TwoSum.
// For every num, IF k-num present in freqMap do count++ and reduce frequency of k-num by 1 and after doing so if it became 0 then simply remove it from freqMap so that it won't be considered for any future k-sum-pair. Don't put num in freqMap as you are using it in current pair.
// ELSE you can add the num in freqMap so that it in future it may be included with other num as k-sum-pair.
// CAUTION: In order to avoid wrong answer due to double counting, build freqMap as you iterate over the array.

class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        int count = 0;

        for (int num : nums) {
            if (hmap.containsKey(k - num)) {
                count++;

                int kMinusNumFreq = hmap.get(k - num);
                hmap.put(k - num, kMinusNumFreq - 1);
                if (hmap.get(k - num) == 0) {
                    hmap.remove(k - num);
                }
            } else {
                int numFreq = hmap.getOrDefault(num, 0);
                hmap.put(num, numFreq + 1);
            }
        }

        return count;
    }
}
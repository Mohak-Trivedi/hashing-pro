// Problem: https://leetcode.com/problems/subarray-sums-divisible-by-k/description

// TC: O(N), SC: O(N)
// A count variation of Good Subarray problem: https://github.com/Mohak-Trivedi/hashing-pro/blob/main/GoodSubarr.java
// CAUTION: Edge case of -ve cumulative sum modulo, must be handled using +k 

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> hmap = new HashMap<>();

        int cumSum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            cumSum += nums[i];
            int cumSumMod = cumSum % k;

            if (cumSumMod < 0) { // w/o this if, this nums = [-1,2,9], k = 2 fails. Needed for dealing with -ve
                cumSumMod += k; // WHy only +k helps deal with this? Because Modular Congruence (Clock analogy)
            }
            if (cumSumMod == 0) {
                count++;
            }
            if (hmap.containsKey(cumSumMod)) {
                count += hmap.get(cumSumMod);
            }

            int freq = hmap.getOrDefault(cumSumMod, 0) + 1;
            hmap.put(cumSumMod, freq);
        }

        return count;
    }
}
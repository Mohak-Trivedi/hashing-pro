// Problem: https://leetcode.com/problems/continuous-subarray-sum/description/

/*
Optimized approach: TC: O(N), SC: O(N)
Maintain HashMap<cumSum, index>
For current cumSum, if you find cumSum%k in hashmap and its difference from current index >=2, return true. If you travered entire array but never returned true, return false.
Edge case : array traveresed until now is a good subarray itself -> current cumSum%k==0 && current index >= 1, then return true.
CAUTION: Put current cumSum with its index in HashMap if and only if it that cumSum is not present in HashMap. If you do, then the latest index value will get stored for that cumSum, whereas we must maintain the leftmost index; and due to this we will get false even though the sub-array has length i.e. r - (l - 1) >= 2 i.e. i - hmap.containsKey(cumSumMod) >= 2 will give false even though the sub-array has a length >=2 because the hmap.containsKey(cumSumMod) returns rightmost index rather than leftmost index.
*/

/*
Logic:
P[l - 1] + Sum[l, r] = P[r]
Do %k on both sides, as we want sub-array to be a multiple of k
(P[l - 1] + Sum[l, r]) % k = P[r] % k
(P[l - 1]%k + Sum[l, r]%k) % k = P[r] % k // because rule (a + b) % k = (a%k + b%k) % k
As we want sub-array whose sum is multiple of k, consider [l, r] to be that sub-array, Sum[l, r] % k = 0
(P[l - 1]%k + 0) % k = P[r] % k
(P[l - 1]%k) % k = P[r] % k
P[l - 1] % k = P[r] % k // Because rule (x % y) % y = x % y
Hence, if for current cumSum at index r we get a previous cumSum at index l-1 such that both's %k are equal, we have a sub-array from index l to r whose sum is a multiple of k. So, 2nd condition of good sub-array satisfied.
And, if difference between their indices i.e. r - (l - 1) >= 2, -> r - l + 1 >= 2 i.e. number of elements from l to r is atleast 2, so 1st condition of good sub-array also satisfied.
*/

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length < 2) {
            return false;
        }

        HashMap<Integer, Integer> hmap = new HashMap<>();
        int cumSum = 0;
        for (int i = 0; i < nums.length; i++) {
            cumSum += nums[i];
            int cumSumMod = cumSum % k;

            if (cumSumMod == 0 && i >= 1) {
                return true;
            } else if (hmap.containsKey(cumSumMod) && i - hmap.get(cumSumMod) >= 2) {
                return true;
            } else {
                if (!hmap.containsKey(cumSumMod))
                    hmap.put(cumSumMod, i);
            }
        }

        return false;
    }
}

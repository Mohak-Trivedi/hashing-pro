// Problem: https://www.geeksforgeeks.org/count-quadruplets-with-sum-k-from-given-array/

// Brute Force Approach: TC: O(N^4), SC: O(1)
// Use 4 for-loops to select 4 elements, and increase count whenever their sum is equal to sum.

// Optimized Approach: TC: O(N^3), SC: O(N)
// Use 3 for-loops:
// Outermost 2 for-loops: To fix 1st and 2nd numbers.
// Innermost for-loop: 2-sum algo using HashMap. Target for 2-sum = sum - 1st number fixed - 2nd number fixed
// Hence, using 2-sum algo, fix 4th number using the innermost for-loop and
// use HashMap to look for: Target for 2-sum - 4th number fixed.

// Better Approach: TC: O(N^2), SC: O(N)
// Just use outer-most 2 for-loops, No need of innermost for-loop, because:
// No need to get the exact values of 4 four elements, just get their count.
// To get just the count:
// Fix 3rd and 4th element, and using HashMap get the count of 2-sums of 2-sum-target = sum - 3rd number fixed - 4th number fixed.
// You must maintain Frequency Map <Sum of First 2 elements, Freq of Sum> 

import java.util.*;

public class GFG {
    static int countSum(int a[], int n, int sum) {
        int count = 0;
        HashMap<Integer, Integer> fmap = new HashMap<>();

        for (int i = 0; i < n - 1; i++) { // all possible 3rd elements
            for (int j = i + 1; j < n; j++) { // all possible 4th elements
                int thirdEle = a[i];
                int fourthEle = a[j];
                int req = sum - thirdEle - fourthEle; // 2-sum target

                if (req < sum && fmap.containsKey(req)) {
                    count += fmap.get(req);
                }
            }

            for (int j = 0; j < i; j++) { // all possible 1st elements, and a[i] will be treated as 2nd element
                int firstEle = a[j];
                int secondEle = a[i];
                int twoSum = firstEle + secondEle;
                int freq = fmap.getOrDefault(twoSum, 0) + 1;
                fmap.put(twoSum, freq);
            }
        }

        return count;
    }

    // Driver Code
    public static void main(String[] args) {

        // Given array arr[]
        int arr[] = { 4, 5, 3, 1, 2, 4 };

        // Given sum S
        int S = 13;

        int N = arr.length;

        // Function Call
        System.out.print(countSum(arr, N, S));
    }
}
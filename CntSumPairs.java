// Problem:
// https://practice.geeksforgeeks.org/problems/count-pairs-with-given-sum5022/1?utm_source=geeksforgeeks&utm_medium=ml_article_practice_tab&utm_campaign=article_practice_tab

// TC: O(N), SC: O(N)
// Variation of TwoSum
// BUILD TOTALPAIRS WHILE BUILDING FMAP, NOT AFTER, ELSE DUPLICATE PAIRS ARE CONSIDERED.

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int k = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int ans = new Solution().getPairsCount(arr, n, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

// User function Template for Java

class Solution {
    int getPairsCount(int[] arr, int n, int k) {
        // code here
        int totalPairs = 0;
        HashMap<Integer, Integer> fmap = new HashMap<>();
        for (int num : arr) {
            totalPairs += fmap.getOrDefault(k - num, 0);

            int freq = fmap.getOrDefault(num, 0) + 1;

            fmap.put(num, freq);
        }

        return totalPairs;
    }
}

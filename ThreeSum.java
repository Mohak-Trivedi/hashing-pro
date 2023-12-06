// Problem:
// https://practice.geeksforgeeks.org/problems/triplet-sum-in-array-1587115621/1?utm_source=geeksforgeeks&utm_medium=article_practice_tab&utm_campaign=article_practice_tab

// Brute Force: TC: O(N^3), SC: O(1)
// Form each triplet and check if it forms a 3sum.
/*
 * for(int i = 0;i < n - 2;i++) // <n-2 bcuz n-2th will be 2nd and n-1st will be 2nd and 3rd respectively in the last triplet whose 1st is A[i]
 * {
 *      int num1 = A[i];
 *      for(int j = i + 1;j < n - 1;j++) // <n-1 bcuz  n-1st will be the 3rd in the last triplet whose 1st is A[i] and 2nd is A[j]
 *      {
 *          int num2 = A[j];
 *          for(int k = j + 1;k < n;k++)
 *          {
 *              int num3 = A[k];
 *              if((num1 + num2 + num3) == X) {
 *                  return true;
 *              }
 *          }
 *      }
 *      
 *      // tried all triplets but never returned true, so no triplet found to be 3sum
 *      return false;
 * }
 */

// Optimized Approach: Using Hashing: TC: O(N^2), SC: O(N)
// For the 1st num of current triplet being checked, we know the remaining 2 numbers must have sum: X - num1.
// This means find 2sum for X - num1. If found return true. If not found, we can try with triplets starting with next ith element of A[].
// If we returned true for none of triplets starting with any ith element, return false.

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int X = Integer.parseInt(inputLine[1]);
            int A[] = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                A[i] = Integer.parseInt(inputLine[i]);
            }
            Solution ob = new Solution();
            boolean ans = ob.find3Numbers(A, n, X);
            System.out.println(ans ? 1 : 0);
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {
    // Function to find if there exists a triplet in the
    // array A[] which sums up to X.
    public static boolean find3Numbers(int A[], int n, int X) {

        // Your code Here
        for (int i = 0; i < n - 2; i++) {
            int num1 = A[i]; // first num of potential triplet
            int currTarget = X - num1; // current target for 2sum

            HashSet<Integer> set = new HashSet<>();

            for (int j = i + 1; j < n; j++) {
                int num2 = A[j]; // second num of potential triplet, also first num of 2sum

                if (set.contains(currTarget - num2)) { // third num of triplet found, so 3sum present
                    return true;
                }

                set.add(num2); // current second num can be a third num for future second num of a triplet
            }
        }

        return false;
    }
}

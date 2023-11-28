// Problem:
// https://www.geeksforgeeks.org/problems/max-distance-between-same-elements/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article

// Same as Tutorial 7 of Hashing:
// https://github.com/Mohak-Trivedi/learn-hashing/blob/main/Tut4duplDist.java
// instead of returning true if duplicate found within k range, return the maximum distance b/w duplicates

// TC: O(2N), SC: O(N)

//{ Driver Code Starts
import java.util.Scanner;
import java.util.*;

class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.maxDistance(arr, n));

            t--;
        }
    }
}
// } Driver Code Ends

// your task is to complete this function
class Solution {
    int maxDistance(int arr[], int n) {
        // Your code here
        HashMap<Integer, Integer> hmap = new HashMap<>();
        // store just first occurrence index of each element
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];

            if (!hmap.containsKey(num)) {
                hmap.put(num, i);
            }
        }

        int maxDist = 0;
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];

            if (hmap.containsKey(num)) {
                int firstOcc = hmap.get(num);

                int dist = i - firstOcc;
                maxDist = Math.max(dist, maxDist);
            }
        }

        return maxDist;
    }
}

// Problem: https://practice.geeksforgeeks.org/problems/frequency-of-array-elements-1587115620/1?utm_source=geeksforgeeks&utm_medium=ml_article_practice_tab&utm_campaign=article_practice_tab

// TC: O(2N), SC: O(N)

//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // testcases
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {

            // size of array
            int N = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[N];
            String inputLine[] = br.readLine().trim().split(" ");

            // adding elements to the array
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int P = Integer.parseInt(br.readLine().trim());
            // calling frequncycount() function
            Solution ob = new Solution();
            ob.frequencyCount(arr, N, P);

            // printing array elements
            for (int i = 0; i < N; i++)
                System.out.print(arr[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends

class Solution {
    // Function to count the frequency of all elements from 1 to N in the array.
    public static void frequencyCount(int arr[], int N, int P) {
        // code here
        // HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        // for (int num : arr) {
        // int freq = hmap.getOrDefault(num, 0) + 1;
        // hmap.put(num, freq);
        // }

        // for (int idx = 0; idx < N; idx++) {
        // int num = idx + 1;

        // arr[idx] = hmap.getOrDefault(num, 0);
        // }

        // return;

        for (int i = 0; i < N; i++) {
            int num = i + 1;
            int cnt = 0;

            for (int j = 0; j < N; j++) {
                int ele = arr[j];
                if (ele == num) {
                    cnt++;
                }
            }

            arr[i] = cnt;
        }

        return;
    }
}

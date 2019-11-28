# HackerRank

Problems solved on HackerRank, Leetcode and Pramp

**1. Minimum Bribes Problem**

  * Link: [Question Description](https://www.hackerrank.com/challenges/new-year-chaos/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays)
  
  ---

**2. RansomNote Problem**: 

   * Link: [Question Description](https://www.hackerrank.com/challenges/ctci-ransom-note/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps)
   
   ---
   
 **3. Greedy Method Problem**
 
   * Link: [Problem description](https://www.hackerrank.com/challenges/mark-and-toys/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=sorting)
   
   ---
   
  **4. Luck Balance Problem**
   * Link: [Problem Description](https://www.hackerrank.com/challenges/luck-balance/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=greedy-algorithms)
    
---
   **5. Ice Cream Parlor Search Problem**
   
   * 3 approaches included: HashMap, Sort and Binary Search, Moving Pointers
   * Link: [Question description](https://www.hackerrank.com/challenges/ctci-ice-cream-parlor/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=search)
    
---
   **6. Maximize Minimum Greedy Algorithm Problem**
   * Link: [Question description](https://www.hackerrank.com/challenges/angry-children/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=greedy-algorithms)
   * Passed all test cases

---
   **7. Maximum Sum of Subarray (using Dynamic Programming)**
   * This problem is a variation of Kadane's algorithm problem Maximum Sum of Subarray as the numbers in all subsets are non-adjacent in the original array
   * **Problem Statement**: Given an array of integers, find the subset of non-adjacent elements with the maximum sum. Calculate the sum of that subset.
   * The solution has time complexity O(N) and passed 32/32 test cases
   * Link: [Question Description](https://www.hackerrank.com/interview/interview-preparation-kit)
  
---
   **8. Alice Candies Dynamic Programming**
   *   **Problem Statement**: Alice is a kindergarten teacher. She wants to give some candies to the children in her class.  All the children sit in a line and each of them has a rating score according to his or her performance in the class.  Alice wants to give at least 1 candy to each child. If two children sit next to each other, then the one with the higher rating must get more candies. Alice wants to minimize the total number of candies she must buy.
   * Link: [Question Description](https://www.hackerrank.com/challenges/candies/problem?h_r=profile)
   * Work in progress: Passed 11/16 test cases 

---
  
   **9. Check Balanced Brackets**
   * **Problem Statement**: Given  strings of brackets, determine whether each sequence of brackets is balanced. If a string is balanced, return YES. Otherwise, return NO.
   * Link: [Question description](https://www.hackerrank.com/challenges/balanced-brackets/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=stacks-queues)
   * Passed all test cases
---

   **10. Largest Rectangular Area in Histogram using stack (Medium)**
   * **Problem Statement**: Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
   * Link: [Question Description](https://www.hackerrank.com/challenges/largest-rectangle/problem)
   * Passed 15/15 test cases
   * Time Complexity: O(n)
   * Solution using stack data structure
---
   **11. Min Max Riddle (Medium)**:
   * **Problem Statement**: Given an integer array of size , find the maximum of the minimum(s) of every window size in the array. The window size varies from 1 to n .
   * Work in progress
---
   **12. Castle On The Grid (Hard)**: 
   * **Problem Stateement**: You are given a square grid with some cells open (.) and some blocked (X). Your playing piece can move along any row or column until it reaches the edge of the grid or a blocked cell. Given a grid, a start and an end position, determine the number of moves it will take to get to the end position.
   * Link: [Problem Description](https://www.hackerrank.com/challenges/castle-on-the-grid/problem?filter=Vietnam&filter_on=country&h_l=interview&page=1&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=stacks-queues)
   * Work in progress: Passed 11/12 test cases (1 test case did not pass due to timed out)
---
   **13. BFS Shortest Path too all nodes in graph (Hard)**
   * **Problem Statement**: Consider an undirected graph consisting of n nodes where each node is labeled from 1 to n and the edge between any two nodes is always of length . We define node  to be the starting position for a BFS. Given a graph, determine the distances from the start node to each of its descendants and return the list in node number order, ascending. If a node is disconnected, it's distance should be -1 
   * Link: [Problem Description](https://www.hackerrank.com/challenges/ctci-bfs-shortest-reach/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=graphs).
   * Passed 8/8 Test Cases
   * Solution used Adjacency List and Queue
---
   **14. Connected Cells In a Grid (Hard)**
   * **Problem Statement**: Given an  matrix, find and print the number of cells in the largest region in the matrix.(region is defined as connected cells containg 1)
   * Link: [Description](https://www.hackerrank.com/challenges/ctci-connected-cell-in-a-grid/problem)
   * Passed 7/7 Test cases
   * Solution used Recursion, DFS concepts
---
   **15. Binary Tree Height (Easy)**
   * **Problem statement**: Find the height of a binary tree
   * Passed 7/7 test cases
   * Solution Using recursion
   * Time complexity: O(n)
---
   **16. Binary Search Tree Lowest Common Ancestor (Easy)**
   * **Problem Statement**: Find the lowest common ancestor of two nodes in a binary search tree
   * Passed 9/9 test cases
   * Solution used recursion concept 
   * Time complexity: O(n) with n is number of edges
   * Link: [Description](https://www.hackerrank.com/challenges/binary-search-tree-lowest-common-ancestor/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=trees)
---
   **17. Permutations of a list of numbers using Recursion (Medium)**
   * **Problem Statement**: Find all permutations of a list of integers
   * Approach: bottom-up. Starting with the base case, when list is empty or size 1, all permutations possible is just that list
   Else to create permutations for a list of size n, we producce permutations for the sublist size n-1, combine it with the n-th element. 
---
   **18. Fibonacci Sequence using Dynamic Programming (Easy)**
   * **Problem statement**: Given n, return nth element in the sequence
   * Passed 9/9 test cases
   * Time Complexity: O(n) (with dynamic programming)
   * Space Complexity: O(n) (can be optimized to be O(1) by initializing array of size 2
---
   **19. Missing element in the array**
   * **Problem Statement**: Given an array containing elements from 1 to n, find the missing element.
   * This is a problem outside HackerRank
   * Time Complexity: O(n)
---
   **20. Optimize with Greedy Algorithm**
   * **Problem Statement**: Given an array consisting of cost of toys. Given an integer K depicting the amount of money available to purchase toys. Write a program to find the maximum number of toys one can buy with the amount K.
   * Time Complexity: O(n)
---
   **21. Recursive Digit Sum (Medium)**
   * **Problem Statement**: You are given two numbers n and k . The number is p  created by concatenating the string n  k times. Given an integer, If  has only  digit, then its super digit is 1. Otherwise, the super digit of x is equal to the super digit of the sum of the digits of x .
   * The solution uses recursion to fit HackerRank category but it can be unnecessarily complicated
   * The solution can be implemented with O(1) time complexity using modular arithmetic
        *  The Digit Sum of a Number to Base 10 is Equivalent to Its Remainder Upon Division by 9
   *   Link Reference: http://applet-magic.com/digitsummod9.htm 
   * Constraints:
        *   1 <=n <= 10^100000
        *   1 <= k < 10^5
  * Since the numbers after concatenate k times are likely to > Integer.MAX_VALUE and also can not be stored in a string, in each call to superDigit, we
      * Turn string into Stream object (n.chars()), which is a sequence of elements
      * Map each of those characters in the stream to long, get numeric value and sum them up
      * Turn them into string
  * Passed 11/11 test cases even with huge input
---
  **22. Huffman Tree Decoding (Medium)**
  * **Problem Statement**: You are given pointer to the root of the Huffman tree and a binary coded string to decode. You need to print the decoded string.
  * Answer uses non recursive solution
  * Time Complexity: O(n)
   
---
   **23. Array Maniplation (Finding maximum in an array after queries updated) (Hard)**
   * **Problem Statement**:Starting with a 1-indexed array of zeros and a list of operations, for each operation add a value to each of the array element between two given indices, inclusive. Once all operations have been performed, return the maximum value in your array.
   * Answer using reference from : [Prefix Algorithm](https://www.youtube.com/watch?v=hDhf04AJIRs)
   * Time Complexity: O(n+m)
   * Space Complexity: O(1)
   * Passed 15/15 test cases   
---
   **24. Sparse Array (Medium)**
   * **Problem Statement**:There is a collection of input strings and a collection of query strings. For each query string, determine how many times it occurs in the list of input strings.
   * Time Complexity: O(n+m)
   * Space Complexity: O(1)
   * Passed 15/15 test cases   
---
   **25. Absolute Value Sort (from Pramp)**
   * **Problem Statement**:Given an array of integers arr, write a function absSort(arr), that sorts the array according to the absolute values of the numbers in arr. If two numbers have the same absolute value, sort them according to sign, where the negative numbers come before the positive numbers.
   * Time Complexity: O(nlogn)
   * Space Complexity: O(1)
---
   **26. Check BST(Problem from Leetcode)**
   * Check if a given tree is BST
---
   **27. Flatten Dictionary (Hard - Leetcode)**
   * **Problem Statement**: Given a dictionary dict, write a function flattenDictionary that returns a flattened version of it .
   * Passed 6/6 Test cases
   * Time Complexity: O(N)
   * Space Complexity: O(n)
 ---
   **28. Shifted Array Search (Medium - Leetcode)**
   * Given shiftArr and an integer num, implement a function shiftedArrSearch that finds and returns the index of num in shiftArr. If num isn’t in shiftArr, return -1. Assume that the offset can be any value between 0 and arr.length - 1.
   * Passed 6/6 test cases
   * Time Complexity: O(logn) using binary search
---
   **29. Romans To Integer (Easy-LeetCode)**
   * Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
   * Time Complexity O(n)
---
   **30. Three Sums(medium- LeetCode)**
   * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
   * Time Complexity O(n^2) (using two pointers)
 ---
   **31. Dutch National Flag Problem(medium- LeetCode)**
   * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
   * Time Complexity O(n) (using two pointers)
 ---
   **32. Remove Duplicates from Sorted Array(medium- LeetCode)**
   * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length. Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
   * Time Complexity O(n) 
---
   **33. Remove Duplicates from Sorted Array(medium- LeetCode)**
   * Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length. Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
   * Time Complexity O(n) 
 ---
   **34. KnapSack Dynamic Programming**
   * Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack.
   * Recursive solution: O(n2^n)
   * DP solution: O(nW)
 ---
   **35. Find Regular Expression Program**
     * Given a string and a pattern, find the number of occurences of the pattern in the string
---
   **36. Find benchmark for portfolio**
   * Given a set of benchmark securities packages and a set of portfolios, find the amount of securities that you need to sell or buy for each portfolio.
   



package test.fibonnacci;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class FrogFibonacci {

    public static int solution(int[] A) {

        int n = A.length + 2;
        int[] B = new int[n];

        B[0] = 1;
        B[B.length - 1] = 1;
        for (int i = 1; i < B.length - 1; i++)
            B[i] = A[i - 1];

        Set<Integer> set = new HashSet<>(Arrays.stream(fib(n)).boxed().collect(Collectors.toSet()));

        int counter = 0;

        for (int i = 0; i < B.length; i++)
            if (B[i] == 1)
                counter++;

        int[] tab = new int[counter];

        for (int i = 0, j = 0; i < B.length; i++) {
            if (B[i] == 1) {
                tab[j] = i;
                j++;
            }
        }
        int blok = counter-1;
        counter=0;
        System.out.println(set);
        System.out.println(Arrays.toString(tab));


        return DP(tab, set, 0, blok);

    }

    public static int[] fib(int N) {


        int n = (int) (Math.log(Math.sqrt(5) * N) / Math.log((1 + Math.sqrt(5)) / 2));
        int[] tab = new int[n ];
        tab[0] = 1;
        tab[1] = 1;

        for (int i = 2; i < n ; i++)
            tab[i] = tab[i - 1] + tab[i - 2];
        return tab;

    }

    public static int DP(int [] A, Set<Integer> set, int j, int block){

        if(j==block && block!=0)
            return 100000;
        if(j==block )
            return 0;
        int left=100000;

        if(set.contains(A[block]-A[j])){
            left= DP(A, set, 0, j)+1;
        }

        int right= DP(A, set, j+1, block);

        return Integer.min(left, right);


    }

    public static void main(String[] args) {

        int[] A={0,0,0,1,1,0,1,0,0,0,0};
        System.out.println(solution(A));
    }
}

/*


The Fibonacci sequence is defined using the following recursive formula:
    F(0) = 0
    F(1) = 1
    F(M) = F(M - 1) + F(M - 2) if M >= 2

A small frog wants to get to the other side of a river. The frog is initially located at one bank of the river (position −1) and wants to get to the other bank (position N). The frog can jump over any distance F(K), where F(K) is the K-th Fibonacci number. Luckily, there are many leaves on the river, and the frog can jump between the leaves, but only in the direction of the bank at position N.

The leaves on the river are represented in an array A consisting of N integers. Consecutive elements of array A represent consecutive positions from 0 to N − 1 on the river. Array A contains only 0s and/or 1s:

        0 represents a position without a leaf;
        1 represents a position containing a leaf.

The goal is to count the minimum number of jumps in which the frog can get to the other side of the river (from position −1 to position N). The frog can jump between positions −1 and N (the banks of the river) and every position containing a leaf.

For example, consider array A such that:
    A[0] = 0
    A[1] = 0
    A[2] = 0
    A[3] = 1
    A[4] = 1
    A[5] = 0
    A[6] = 1
    A[7] = 0
    A[8] = 0
    A[9] = 0
    A[10] = 0

The frog can make three jumps of length F(5) = 5, F(3) = 2 and F(5) = 5.

Write a function:

    class Solution { public int DP(int[] A); }

that, given an array A consisting of N integers, returns the minimum number of jumps by which the frog can get to the other side of the river. If the frog cannot reach the other side of the river, the function should return −1.

For example, given:
    A[0] = 0
    A[1] = 0
    A[2] = 0
    A[3] = 1
    A[4] = 1
    A[5] = 0
    A[6] = 1
    A[7] = 0
    A[8] = 0
    A[9] = 0
    A[10] = 0

the function should return 3, as explained above.

Write an efficient algorithm for the following assumptions:

        N is an integer within the range [0..100,000];
        each element of array A is an integer that can have one of the following values: 0, 1.

Copyright 2009–2019 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 */

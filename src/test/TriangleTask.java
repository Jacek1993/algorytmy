package test;

import java.util.Arrays;

public class TriangleTask {

    //0%

    public static int solution1(int[] A) {

        if(A.length<3) return 0;

        Arrays.sort(A);

        if(A[A.length-3]<=0)
            return 0;
        int counter = 0;

        for (int i = 2; i < A.length; i++) {

            if (isTriangle(A[i - 2], A[i - 1], A[i])) {
                counter=1;
                break;
            }
        }
        return counter;
    }

    public static int solution(int[] A) {
        int max = A[0];
        for (int i = 1; i < A.length; i++) {
            if (max < A[i])
                max = A[i];
        }
        int[] exists = new int[max + 1];

        for(int i=0; i<A.length; i++){

            exists[A[i]]=exists[A[i]]+1;
        }

        int [] B=new int[A.length];

        for(int i=0, j=0,k; i<exists.length; i++){

            if(exists[i]!=0){
                k=0;
                while(j <B.length && k <exists[i]){
                    B[j]=i;
                    j++;
                    k++;
                }
            }

        }
        System.out.println(Arrays.toString(B));
        int counter = 0;

        for (int i = 2; i < B.length; i++) {

            if (isTriangle(B[i - 2], B[i - 1], B[i])) {
                counter++;
            }
        }
        return counter;

    }

    public static boolean isTriangle(int p, int q, int r) {
        if (p + q <= r) return false;
        if (r + q <= p) return false;
        if (p + r <= q) return false;
        return true;
    }

    public static void main(String[] args) {
        int[] A = {10, 2, 5, 1, 8, 20};
        System.out.println(solution1(A));
        int[] B = {10, 50, 5, 1};
        int[] C = {10, 50, 5, 1,10,5,5};
        System.out.println(solution1(B));

        solution(B);
        solution(A);
        solution(C);
    }


}



/*


An array A consisting of N integers is given. A triplet (P, Q, R) is triangular if 0 ≤ P < Q < R < N and:

        A[P] + A[Q] > A[R],
        A[Q] + A[R] > A[P],
        A[R] + A[P] > A[Q].

For example, consider array A such that:
  A[0] = 10    A[1] = 2    A[2] = 5
  A[3] = 1     A[4] = 8    A[5] = 20

Triplet (0, 2, 4) is triangular.

Write a function:

    class Solution { public int DP(int[] A); }

that, given an array A consisting of N integers, returns 1 if there exists a triangular triplet for this array and returns 0 otherwise.

For example, given array A such that:
  A[0] = 10    A[1] = 2    A[2] = 5
  A[3] = 1     A[4] = 8    A[5] = 20

the function should return 1, as explained above. Given array A such that:
  A[0] = 10    A[1] = 50    A[2] = 5
  A[3] = 1

the function should return 0.

Write an efficient algorithm for the following assumptions:

        N is an integer within the range [0..100,000];
        each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].


 */
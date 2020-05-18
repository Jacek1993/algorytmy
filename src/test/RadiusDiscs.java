package test;

public class RadiusDiscs {

    //6%

    public static int solution(int [] A){

        int [][] exists=new int[A.length][A.length];

        int counter=0;
        for(int i=0; i<A.length; i++){
            for(int j=0; j<A.length;j++){
                if(i!=j){
                    if(Math.abs(i-j)<=A[i]+A[j]) {
                        if(exists[i][j]==0){
                            exists[j][i]=1;
                            counter++;
                        }
                    }
                }
            }
        }
        return counter ==0? -1: counter;
    }

    public static void main(String[] args) {
        int [] A={1,5,2,1,4,0};
        System.out.println(solution(A));
    }
}


/*
and radius A[J].

We say that the J-th disc and K-th disc intersect if J ≠ K and the J-th and K-th discs have at least one common point (assuming that the discs contain their borders).

The figure below shows discs drawn for N = 6 and A as follows:
  A[0] = 1
  A[1] = 5
  A[2] = 2
  A[3] = 1
  A[4] = 4
  A[5] = 0

There are eleven (unordered) pairs of discs that intersect, namely:

        discs 1 and 4 intersect, and both intersect with all the other discs;
        disc 2 also intersects with discs 0 and 3.

Write a function:

    class Solution { public int DP(int[] A); }

that, given an array A describing N discs as explained above, returns the number of (unordered) pairs of intersecting discs. The function should return −1 if the number of intersecting pairs exceeds 10,000,000.

Given array A shown above, the function should return 11, as explained above.
 */
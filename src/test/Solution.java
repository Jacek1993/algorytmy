package test;

import java.util.HashMap;
import java.util.Map;

public class Solution {


    private static final Map<String , Integer> map=new HashMap<>();


    public static int solution(int [] A, int [] B, int F){
        return DP(A, B, F, 0, 0, 0, 0);
    }

    public static int DP(int [] A, int []  B, int F, int b, int f, int cost, int indexA){

        if(indexA ==A.length )
            return 0;
        int value;

        if(cost >0 && b >=A.length-F) {
            value=DP(A, B, F, b, f + 1, cost + A[indexA], indexA + 1) + A[indexA];
            return value;

        }
        if(cost >0 && f>=F) {
            value=DP(A, B, F, b + 1, f, cost + B[indexA], indexA + 1) + B[indexA];
            return value;
        }

        value= Integer.max(DP(A, B, F, b+1, f, cost+B[indexA], indexA+1)+B[indexA],
                DP(A, B, F, b,f+1, cost+A[indexA], indexA+1)+A[indexA]);
        return value;

    }


    public static void main(String[] args) {
        int[] A={4,2,1};
        int []B={2,5,3};
        int [] A1={7,1,4,4};
        int [] B1={5,3,4,3};
        int [] A2={5,5,5};
        int [] B2={5,5,5};

        System.out.println(solution(A, B, 2));
        System.out.println(solution(A1, B1, 2));
        System.out.println(solution(A2, B2, 2));


    }
}


/*


A company has employed N developers (numbered from 0 to N−1) and wants to divide them into two teams. The first is a front-end team with F developers. The second is a back-end team with N−F developers. If the K-th developer is assigned to the front-end team then their contribution is A[K], and if they are assigned to the back-end team then their contribution is B[K]. What is the maximum sum of contributions the company can achieve?

Write a function:

    class Solution { public int DP(int[] A, int[] B, int F); }

that, given two arrays A, B (consisting of N integers each) and the integer F, returns the maximum sum of contributions the company can achieve.

Examples:

1. Given A = [4, 2, 1], B = [2, 5, 3] and F = 2, the function should return 10. There should be two front-end developers and one back-end developer. The 0th and 2nd developers should be assigned to the front-end team (with contributions 4 and 1) and the 1st developer should be assigned to the back-end team (with contribution 5).

2. Given A = [7, 1, 4, 4], B = [5, 3, 4, 3] and F = 2, the function should return 18. The 0th and 3rd developers should be assigned to the front-end team and the 1st and 2nd developers should be assigned to the back-end team.

3. Given A = [5, 5, 5], B = [5, 5, 5] and F = 1, the function should return 15. The 0th developer can be assigned to the front-end team and the 1st and 2nd developers can be assigned to the back-end team.

Write an efficient algorithm for the following assumptions:

        N is an integer within the range [1..200,000];
        arrays A and B have equal lengths;
        each element of array A is an integer within the range [0..1,000];
        F is an integer within the range [0..N].

Copyright 2009–2019 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 */

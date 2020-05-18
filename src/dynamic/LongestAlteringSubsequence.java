package dynamic;

public class LongestAlteringSubsequence {

    private static int dp(int [] A, int indexA, int prevIndexA){

        if(indexA >=A.length-1)
            return 0;

        if( prevIndexA>0 && A[indexA] > A[prevIndexA] && A[indexA] <A[indexA+1] )
            return dp(A, indexA+1, indexA)+1;
        else if(prevIndexA>0 && A[indexA] <A[prevIndexA] && A[indexA] >A[indexA+1] )
            return dp(A, indexA+1, indexA)+1;

        return Integer.max(dp(A, indexA+1, indexA)+1, dp(A, indexA+1, indexA));
    }

    private static int DP(int [] A, int indexA, int end, boolean sign){

        int cost=0;

        for(int p=indexA; p<=end; p++){

            if( sign &&A[p-1] <A[p] )
                return Integer.max(cost, 1+ DP(A, indexA+1, end, !sign));

            else if(!sign && A[p-1] > A[p])
                return Integer.max(cost, 1+DP(A, p+1, end, !sign));

            else
                return Integer.max(cost, DP(A, p+1, end, sign));
        }

        return cost;
    }


    public static int findLongestSequence(int[] arr)
    {
        // Fix first element and recurse for remaining elements as first
        // element will always be part of longest subsequence (why?)

        // There are two possibilities -

        // 1. Next element is greater (pass true)
        // 2. Next element is smaller (pass false)
        return 1 + Integer.max(DP(arr, 1, arr.length - 3, true),
                DP(arr, 1, arr.length  - 3, false));

        // instead of fixing first element, we can also directly call
        // return max(Util(arr, 0, n, true), Util(arr, 0, n, false));
    }


    public static void main(String[] args) {
        int A[]={8, 9, 6, 4, 5, 7, 3,2, 4};

        System.out.println(dp(A, 0, -1));

        System.out.println(DP(A, 1, A.length-1, true));

        System.out.println(findLongestSequence(A));
    }


}

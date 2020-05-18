package test.fibonnacci;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

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
//        System.out.println(block);
        return Integer.min(left, right);


    }

    public static void main(String[] args) {
        int [] A={0,4,5,7,12};
        Set<Integer> set=new HashSet<>(Arrays.asList(1,2,3,5,8,13));
        Set<Integer> set1=new HashSet<>(Arrays.asList(1,2,3,5,8,13,21));

        int [] B={0,2,3,11};
        int [] C={0,2,3,16,18};

        System.out.println(DP(A, set, 0, A.length-1));
        System.out.println(DP(B, set, 0, B.length-1));
        System.out.println(DP(C, set1, 0, C.length-1));
    }
}

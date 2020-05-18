package test.prefix_sums;

import java.util.Arrays;

public class GenomicRangeQuery {

    public static int [] solution(String S, int [] P, int [] Q){

        int [] s=new int [S.length()];
        for(int i=0; i<S.length(); i++){
            if(S.charAt(i)=='A') s[i]=1;
            if(S.charAt(i)=='C') s[i]=2;
            if(S.charAt(i)=='G') s[i]=3;
            if(S.charAt(i)=='T') s[i]=4;
        }

        int [] R=new int[Q.length];

        for(int i=0; i<Q.length; i++){
            R[i]=min(s, P[i], Q[i]);
        }

        return R;

    }

    static int min(int [] x, int a, int b){
        int min=4;
        for(int i=a; i<=b; i++){
            if(x[i]<min)
                min=x[i];
        }

        return min;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("CAGCCTA", new int []{2,5,0}, new int[]{4,5,6})));
    }
}

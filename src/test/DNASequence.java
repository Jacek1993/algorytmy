package test;

import java.util.Arrays;

public class DNASequence {

    public static int[] solution(String S, int[]P, int[] Q){

        int [] tab=new int[S.length()];

        for(int i=0; i<S.length(); i++){
            if(S.charAt(i)=='A')
                tab[i]=1;
            else if(S.charAt(i)=='C')
                tab[i]=2;
            else if(S.charAt(i)=='G')
                tab[i]=3;
            else if(S.charAt(i)=='T')
                tab[i]=4;
        }

        int minimum[] =new int[P.length];

        for(int i=0; i<P.length; i++){

            minimum[i]=findMinimum(tab, P[i], Q[i]);
        }

        return minimum;

    }

    static int findMinimum(int []A, int x, int y){
        int min=Integer.MAX_VALUE;
        for(int i=x; i<=y; i++){
            if(min >A[i])
                min=A[i];
        }

        return min;
    }


    public static void main(String[] args) {
        String S="CAGCCTA";
        int P[]={2,5,0};
        int Q[]={4,5,6};
        System.out.println(Arrays.toString(solution(S, P, Q)));
    }
}

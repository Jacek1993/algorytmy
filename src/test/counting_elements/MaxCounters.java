package test.counting_elements;

import java.util.Arrays;

public class MaxCounters {

    public static int [] solution(int N, int [] A){
        int max=0;
        for(int i=0; i<A.length; i++){
            if(max < A[i])
                max=A[i];
        }

        boolean [] tab=new boolean[A.length];
        for(int i=0; i<A.length; i++){
            if(A[i]==max){
                tab[i]=true;
            }
        }

        int [] B=new int[N];

        int maxInB=0;
        boolean nextIsMax=false;

        for(int i=0; i<A.length; i++){
            if(tab[i]){
                if(nextIsMax){
                    continue;
                }
                incrementAll(maxInB, B);
                nextIsMax=true;
            }
            else{
                increment(A[i], B);
                if(B[A[i]-1] > maxInB){
                    maxInB=B[A[i]-1];
                }
                nextIsMax=false;
            }
        }

        return B;


    }

    private static void  increment(int X, int [] B){
        B[X-1]=B[X-1]+1;
    }

    private static void incrementAll(int maxInB, int [] B){
        for(int i=0; i<B.length; i++){
            B[i]=maxInB;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[]{3, 4, 4, 6, 1, 4, 4})));
    }
}

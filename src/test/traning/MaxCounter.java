package test.traning;

import java.util.Arrays;

public class MaxCounter {


    public static int [] solution(int N, int [] A){

        int [] counters=new int[N];

        for(int i=0; i<A.length; i++){

            if(A[i]<=N && A[i] >=1){
                counters=increase(A[i], counters);
            }
            else if(A[i]==N+1){
                counters=maxValue(counters);
            }
        }
        return counters;
    }

    static int []increase(int X, int [] c){

        c[X-1]=c[X-1]+1;
        return c;
    }

    static int [] maxValue(int [] c){

        int max=Integer.MIN_VALUE;
        for(int i=0; i<c.length; i++)
            if(c[i] >max)
                max=c[i];

        for(int i=0; i<c.length; i++)
            c[i]=max;
        return c;
    }

    public static void main(String[] args) {

        int [] A={3,4,4,6,1,4,4};



        System.out.println(Arrays.toString(solution(5,A)));
    }




}

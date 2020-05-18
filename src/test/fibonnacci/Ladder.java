package test.fibonnacci;

import java.util.Arrays;

public class Ladder {

    public static int[] solution(int []A, int[] B){
        int max=0;

        for(int i=0; i<A.length; i++){
            if(max<A[i])
                max=A[i];
        }

        int fibo[]=fib(max);

        int tab[] =new int[A.length];

        for(int i=0; i<A.length; i++){
            tab[i]=fibo[A[i]]%(int)Math.pow(2, B[i]);
        }

        return tab;
    }

    public static int[] fib(int N){

        int [] fibo=new int[N+1];

        fibo[0]=1;
        fibo[1]=1;

        for(int i=2; i<=N; i++){
            fibo[i]=fibo[i-1]+fibo[i-2];
        }

        return fibo;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(fib(8)));

        int[] A={4,4,5,5,1};
        int[] B={3,2,4,3,1};

        System.out.println(Arrays.toString(solution(A,B)));
    }
}

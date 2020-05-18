package test.eratostenes;

import java.util.Arrays;

public class NonDivisor {

    public static int[] solution(int [] A){
       int [] divisors=new int[A.length];
       int counter;
        for(int i=0; i<A.length; i++){
            counter=0;
            for(int j=0; j<A.length; j++){
                if(i!=j){
                    if(A[i] %A[j]!=0)
                        counter++;

                }
            }
            divisors[i]=counter;
            counter=0;
        }

        return divisors;

    }

    public static void main(String[] args) {
        int [] A={3,1,2,3,6};
        System.out.println(Arrays.toString(solution(A)));
    }
}

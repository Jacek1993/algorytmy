package test.prefix_sums;

import java.util.Arrays;

public class PassingCars {

    public static int solution(int [] A){
        int [] tab=new int[A.length];

        for(int i=0; i<A.length; i++){
            tab[i]=0;
        }

        int counter=0;

        for(int i=A.length-1; i>=0; i--){
            if(A[i] ==1){
                counter++;
            }
            tab[i]=counter;
        }

        int COUNTER=0;

        for(int i=0; i<A.length; i++){
            if(A[i]==0){
                COUNTER+=tab[i];
            }
            if(COUNTER <0){
                return -1;
            }
        }

        return COUNTER <=1000_000_000 ? COUNTER :-1 ;
    }


    public static void main(String[] args) {
        System.out.println(solution(new int[] {0,1,0,1,1}));
        System.out.println(solution(new int[] {1,1,1,1,1}));
    }

}

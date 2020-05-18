package test.traning;

import java.util.Arrays;

public class ArrayShifting {

    public static int [] solution(int [] A, int K){

        boolean [] isShifted=new boolean[A.length];

        int previous, next;

        int j,k;

        int i=k=0;
        previous=A[k];

        while(i <A.length){
            next=previous;

            j=(k+K)%A.length;
            System.out.println("j "+j);
            if(!isShifted[j]) {
                previous=A[j];
                A[j]=next;
                k=j;
                isShifted[j]=true;


            }
            else{
                k=++i;
                if(k<A.length)
                previous=A[k];
                else break;
            }

        }

        return A;
    }

    public static void main(String[] args) {
        int []A={3,8,9,7,6};
        int [] B=solution(A, 3);
        int D[]={1,2,3,4};
        Arrays.stream(B).forEach(System.out::println);
        Arrays.stream(solution(D, 10000)).forEach(System.out::println);
        Arrays.stream(solution(new int[]{0,0,0}, 1)).forEach(System.out::println);

    }
}

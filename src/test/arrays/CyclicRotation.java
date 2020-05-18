package test.arrays;

import java.util.Arrays;

public class CyclicRotation {

    public static int [] solution (int [] A,int K){

        if(A.length<1)
            return A;

        boolean [] tab=new boolean[A.length];
        int licznik=0;
        int k,l=A[0];
        int n=A.length;
        for(int i=0; i<A.length+1; i++){



            k=A[(licznik+K)%n];
            A[(licznik+K)%n]=l;
            if(tab[(licznik+K)%n]) {
                licznik++;
                k=A[(licznik+K)%n];
            }

            l=k;
            licznik+=K;
            licznik = licznik >=n? licznik%n : licznik;
            tab[licznik]=true;


        }


        return A;


    }

    public static void main(String[] args) {
        int A[]={3,5,7,8,12,3};

        System.out.println(Arrays.toString(solution(A, 4)));
    }
}

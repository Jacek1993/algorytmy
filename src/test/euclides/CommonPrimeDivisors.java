package test.euclides;

import java.util.Arrays;

public class CommonPrimeDivisors {

    public static int solution(int[] A, int[] B) {

        int counter = 0;


        for (int i = 0; i < A.length; i++) {
            boolean sign=false;
            if (A[i] == B[i]) {
                counter++;
            } else {
                int a=A[i] >B[i]? A[i]: B[i];

                int b=a==A[i]?B[i] : A[i];

                int [] er=eratostenes(a);


                for(int j=0; j<er.length; j++){
                    if(b %er[j]!=0){
                        sign =true;
                        break;
                    }
                }
                System.out.println(sign);
                if(sign)
                    break;
                counter++;
            }

        }

    return counter;
    }

    public static int NWD(int A, int B) {
        int a = A, b = B;

        while (a != b) {
            if (a > b)
                a = a - b;
            if (b > a)
                b = b - a;

        }
        return a;
    }

    public static int[] eratostenes(int A) {

        boolean[] isPrime = new boolean[A + 1];
        int w;

        for (int i = 2; i < Math.sqrt(A); i++) {
            w = i * i;
            while (w <= A) {
                isPrime[w] = true;
                w += i;
            }
        }

        int counter = 0;
        for (int i = 2; i <= A; i++)
            if (!isPrime[i] && A % i == 0)
                counter++;
        int[] tab = new int[counter];
        for (int i = 2, k = 0; i <= A; i++) {
            if (!isPrime[i] && A % i == 0) {
                tab[k] = i;
                k++;
            }
        }
        return tab;

    }

    public static void main(String[] args) {
        System.out.println(NWD(10, 5));

        System.out.println(Arrays.toString(eratostenes(80)));

        int [] A={15,10,3};
        int [] B={75, 30, 5};
        System.out.println(solution(A, B));
    }
}

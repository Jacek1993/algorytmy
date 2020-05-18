package test;

public class MinAvgTwoSlice {

    //performance 20% trzeba poprawic zlozonosc obliczeniowa n^2

    public static int solution(int []A){

        int [][]sumy=new int[A.length][A.length];

        for(int i=0; i<A.length; i++)
            for(int j=0; j<A.length; j++)
                sumy[i][j]=Integer.MAX_VALUE;

        double minAvg=Double.MAX_VALUE;
        double avg=0.0;
        int suma=0;
        int iValue=-1;

        for(int i=0; i<A.length-1; i++){

            for(int j=i+1; j<A.length; j++){

                if(i<1){
                    suma=sumy[i][j]=sumy(A, i, j);
                }else{
                    suma=sumy[i][j]=sumy[i-1][j]-A[i-1];
                }
                System.out.println("suma "+suma+" i "+i+" j "+j);

                avg=(double)suma/(int)((j-i)+1);
                System.out.println(avg);
                if(avg <minAvg)
                {
                    minAvg=avg;
                    iValue=i;
                }
            }
        }

        System.out.println(minAvg);
        return iValue;
    }

    //mozemy ta tablie zastapic tablica n elementowa i na niej wykonywac dzialania

    public static int sumy(int [] A, int i, int j){

        int suma=0;
        for(int k=i; k<=j; k++)
            suma+=A[k];
        return suma;
    }


    public static void main(String[] args) {
        int [] A={4,2,2,5,1,5,8};
        System.out.println(solution(A));

        double a=((double)8/(int)3);
        System.out.println(a);
    }



}

/*


A non-empty array A consisting of N integers is given. A pair of integers (P, Q), such that 0 ≤ P < Q < N, is called a slice of array A (notice that the slice contains at least two elements). The average of a slice (P, Q) is the sum of A[P] + A[P + 1] + ... + A[Q] divided by the length of the slice. To be precise, the average equals (A[P] + A[P + 1] + ... + A[Q]) / (Q − P + 1).

For example, array A such that:
    A[0] = 4
    A[1] = 2
    A[2] = 2
    A[3] = 5
    A[4] = 1
    A[5] = 5
    A[6] = 8

contains the following example slices:

        slice (1, 2), whose average is (2 + 2) / 2 = 2;
        slice (3, 4), whose average is (5 + 1) / 2 = 3;
        slice (1, 4), whose average is (2 + 2 + 5 + 1) / 4 = 2.5.

The goal is to find the starting position of a slice whose average is minimal.

Write a function:

    class Solution { public int DP(int[] A); }

that, given a non-empty array A consisting of N integers, returns the starting position of the slice with the minimal average. If there is more than one slice with a minimal average, you should return the smallest starting position of such a slice.

For example, given array A such that:
    A[0] = 4
    A[1] = 2
    A[2] = 2
    A[3] = 5
    A[4] = 1
    A[5] = 5
    A[6] = 8

the function should return 1, as explained above.

Write an efficient algorithm for the following assumptions:

        N is an integer within the range [2..100,000];
        each element of array A is an integer within the range [−10,000..10,000].


 */

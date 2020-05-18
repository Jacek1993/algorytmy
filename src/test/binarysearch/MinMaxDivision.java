package test.binarysearch;

public class MinMaxDivision {
    //8%

    public static int solution(int K, int M, int[] A) {

        int beg = M;
        int end = sum(A);
        int result1=-1;
        int min=Integer.MAX_VALUE;
        while (beg <= end) {
            int mid = (beg + end) / 2;
            if ((result1 = check(A, mid, K)) >= M) {
                end = mid - 1;
//                System.out.println("END "+end+" BEG "+beg);

                if(min >result1){
                    min=result1;
                }
            } else {
                beg = mid + 1;
            }
        }

        return min;
    }

    static int sum(int[] A) {
        int suma = 0;
        for (int i = 0; i < A.length; i++)
            suma += A[i];
        return suma;
    }

    static int check(int[] A, int mid, int K) {
        int sum = 0, max = 0, counter = 1;
        boolean sign = false;


        for (int i = 0; i < A.length; i++) {

            if (sum + A[i] <= mid || sign) {
                sum += A[i];
            } else {
                if (max < sum) {
                    max = sum;
                }
                sum = A[i];

                counter++;
                if (counter == K)
                    sign = true;
            }
        }

        if (max < sum)
            max = sum;
//        System.out.println(max);

        return max;
    }


    public static void main(String[] args) {
        int A[] = {2, 1, 5, 1, 2, 2, 2};
        System.out.println(solution(3, 5, A));
    }
}

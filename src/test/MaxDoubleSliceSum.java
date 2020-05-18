package test;

public class MaxDoubleSliceSum {

    public static int solution(int[] A) {

        if(A.length<=3)return 0;

        int sum = 0, evSum = 0;
        boolean sign = true;

        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (sum + A[j] > sum || sign) {
                    sum += A[j];
                } else {
                    if (sign) {
                        sign = !sign;
                    } else
                        break;
                }
            }
            sign = true;
            if (evSum < sum)
                evSum = sum;
            sum = 0;
        }

        return evSum;

    }


    public static void main(String[] args) {
        int[] A = {3, 2, 6, -1, 4, 5, -1, 2};
        System.out.println(solution(A));
    }
}

package test.counting_elements;


public class FrogRiverOne {

    public static int solution(int X, int[] A) {

        int max = 1;
        int counter = -1;
        int counter1 = 0;
        boolean[] tab = new boolean[X];

        if (A.length < X)
            return -1;

        for (int i = 0; i < A.length; i++) {
            if (max < A[i]) {
                max = A[i];
            }

            if (!tab[A[i] - 1]) {
                tab[A[i] - 1] = true;
                System.out.println(A[i]);
                counter1++;

            }

            if (counter1 == X) {
                counter = i;
                break;

            }
        }

        if (max != X)
            return -1;

        return counter;

    }

    public static void main(String[] args) {
        System.out.println(solution(5, new int[]{1, 3, 1, 4, 2, 3, 5, 4}));
    }
}

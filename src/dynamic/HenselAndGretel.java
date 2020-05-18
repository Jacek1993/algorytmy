package dynamic;

public class HenselAndGretel {

    public static void main(String[] args) {
        int[] A = {12, 34, 5, 6, 12, 3, 100, 10, 4, 9, 17};

        System.out.println(DP(A, 0, A.length - 1-2, 2, 2));
    }


    private static int DP(int[] A, int malgosia, int jas, int k, int l) {

        int costJas=0, costMalgosia=0;
        int maxMalgosia = -1, maxJas=-1;
        int jas1=jas, malgosia1=malgosia;


        for (int p = malgosia, q = jas; p < A.length && q >= 0; p++, q--) {

            if ((malgosia1 <= q && malgosia1 + k >= q+l) || (malgosia1 <=q+l && malgosia1 +k >=q+l)) {
                costJas = 0;
                costMalgosia=0;
                System.out.println("dupa");
            }
            else if ((jas1 <= p && jas1 + l >= p+k) || (jas1 <=p+k && jas1+l >=malgosia1+k) ) {
                costJas = 0;
                costMalgosia=0;
                System.out.println("dupa");

            }
            else {
                costJas = sumJas(A,  q,  l);
                costMalgosia=sumMalgosia(A, p, k);
            }


            if (maxJas < costJas) {
                maxJas = costJas;
                jas1=q;
            }

            if(maxMalgosia <costMalgosia){
                maxMalgosia=costMalgosia;
                malgosia1=p;
            }

        }

        return maxJas+maxMalgosia;

    }


    private static int sum(int[] A, int malgosia, int jas, int k, int l) {
        int suma = 0;


        for (int p = malgosia; p <= k+malgosia; p++)
            suma += A[p];

        for (int p = jas; p <= l+jas; p++)
            suma += A[p];
        System.out.println(suma);
        return suma;
    }

    private static int sumJas(int [] A, int jas, int l){
        int suma=0;
        for (int p = jas; p <= l+jas; p++)
            suma += A[p];
        System.out.println(suma);
        return suma;
    }

    private static int sumMalgosia(int []A, int malgosia, int k){
        int suma=0;

        for (int p = malgosia; p <= k+malgosia; p++)
            suma += A[p];
        System.out.println(suma);
        return suma;
    }
}

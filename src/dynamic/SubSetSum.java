package dynamic;

//Warto zapamiętac to rozwiazanie DP1 ponieważ drugi warunek jest zawsze prawdziwy co zwraca od razu wynik negatywny
//1 naszym problemem jest to czy dany element wraz z kosztem jest wiekszy od sumy czy nie jestli jest to go odrzucamy jesli nie to idziemy dalej
//2 trzeba zgadnac ktory element dodany da koszt mniejszy od sumy
//3 rownanie rekurencyjne moze badac minimum zwracane przez wywolania dla funkcji z dadany elementem i nie dodanym elementem
//4 zlozonosc obliczeniowa dla rozwiazania dynamicznego powinna wyniesc sumX(true | false)

import java.util.HashMap;
import java.util.Map;

public class SubSetSum {

    private final static int sum = 6;


    private static boolean DP(int cost, int[] A, int indexA) {

        if (cost == 0)
            return true;

        if (cost < 0 || indexA < 0)
            return false;

        boolean stay = DP(cost - A[indexA], A, indexA - 1);
        boolean leave = DP(cost, A, indexA - 1);

        return stay || leave;
    }


//    private static boolean DP1(int cost, int []A, int indexA){
//        if(cost==sum)
//            return true;
//
//        if(indexA == A.length|| sum-cost !=0)
//            return false;
//        boolean stay=DP1(cost-A[indexA], A, indexA+1);
//        boolean leave=DP1(cost, A, indexA+1);
//
//        return stay || leave;
//    }

    public static void main(String[] args) {
        int[] A = {2, 5, 4, 7, 6};
        long time= System.currentTimeMillis();
        System.out.println(DP(sum, A, A.length - 1));
        System.out.println("Solution for divide and conquer "+(System.currentTimeMillis()-time));


        SubSetSum subSetSum = new SubSetSum();
        Partitioner partitioner = subSetSum.new Partitioner(A, sum);
        time=System.currentTimeMillis();
        System.out.println(partitioner.Solve());
        System.out.println("Solution for DP "+(System.currentTimeMillis()-time));
    }

    private class Partitioner {

        private int[] A;
        private int sum;

        private Map<String, Boolean> map;

        public Partitioner(int[] A, int sum) {

            this.A = A;
            this.sum = sum;
            map = new HashMap<>();

        }

        public boolean Solve() {

            return DP(sum, A, A.length - 1);
        }

        private boolean DP(int cost, int[] A, int indexA) {

            if (cost == 0)
                return true;

            if (cost < 0 || indexA < 0)
                return false;

            String key = indexA + "|" + cost;

            if (!map.containsKey(key)) {
                boolean stay = DP(cost - A[indexA], A, indexA - 1);
                boolean leave = DP(cost, A, indexA - 1);
                map.put(key, stay || leave);
            }
            return map.get(key);


        }

    }
}

package dynamic;

import java.util.HashMap;
import java.util.Map;

public class MinimumCostToReachLastCell {

    public static int DP(int [][] A, int indexA, int indexB){

        if(indexA==A.length-1 && indexB==A.length-1)
            return A[indexA][indexB];

        if(indexA ==A.length-1)
            return DP(A, indexA, indexB+1)+A[indexA][indexB];

        if(indexB==A.length-1)
            return DP(A, indexA+1, indexB)+A[indexA][indexB];


        return Integer.min(DP(A, indexA+1, indexB)+A[indexA][indexB], DP(A, indexA, indexB+1)+A[indexA][indexB]);


    }


    public static void main(String[] args) {

        int [][] A={{4,7,8,6,4},
                {6,7,3,9,2},
                {3,8,1,2,4},
                {7,1,7,3,7},
                {2,9,8,9,3}};

        long time=System.currentTimeMillis();
        System.out.println(DP(A, 0, 0));
        System.out.println("Time for divide and conquer "+(System.currentTimeMillis()-time) );
        MinimumCostToReachLastCell minimumCostToReachLastCell=new MinimumCostToReachLastCell();


        Partitioner partitioner=minimumCostToReachLastCell.new Partitioner(A);
        time=System.currentTimeMillis();
        System.out.println(partitioner.Solve());
        System.out.println("Time for dynamic programming DP "+(System.currentTimeMillis()-time));

        int cost[][]= {{1, 2, 3},
                {4, 8, 2},
                {1, 5, 3}};

        System.out.println(DP(cost, 0, 0));

        Partitioner partitioner1=minimumCostToReachLastCell.new Partitioner(cost);
        System.out.println(partitioner1.Solve());

        int B[][]={{12,34,7,3,1,34,90},
                {12,34,5,6,7,8,0},
                {1,2,3,4,5,6,7},
                {7,6,5,4,3,2,1},
                {13,14,15,16,17,18,19},
                {90,80,70,60,50,40,30},
                {100,101,102,103,104,105,106}};

        time=System.currentTimeMillis();
        System.out.println(DP(B, 0, 0));
        System.out.println("divide and conquer "+(System.currentTimeMillis()-time));
        Partitioner partitioner2=minimumCostToReachLastCell.new Partitioner(B);
        time=System.currentTimeMillis();
        System.out.println(partitioner2.Solve());
        System.out.println("divide and conquer "+(System.currentTimeMillis()-time));
    }


    private class Partitioner{

        private int A[][];
        private Map<String, Integer> memo;


        public Partitioner(int [][] A){
            this.A=A;

            memo=new HashMap<>();

        }

        public int Solve(){

            return DP(A, 0, 0, 0);
        }

        private int DP(int [][] A, int indexA, int indexB, int cost){

            if(indexA==A.length-1 && indexB==A.length-1)
                return A[indexA][indexB];

            String key=indexA+"|"+indexB+"|"+cost;

            if(memo.containsKey(key)){
                return memo.get(key);
            }

            if(indexA==A.length-1) {
                int value=DP(A, indexA, indexB + 1, cost + A[indexA][indexB]) + A[indexA][indexB];
                   memo.put(key, value);
                    return value;

            }

            if(indexB==A.length-1){
                int value= DP(A, indexA+1, indexB, cost+A[indexA][indexB])+A[indexA][indexB];
                memo.put(key, value);
                return value;
            }


            int leftValue=DP(A, indexA+1, indexB, cost+A[indexA][indexB])+A[indexA][indexB];
            int rightValue=DP(A, indexA, indexB+1, cost+A[indexA][indexB])+A[indexA][indexB];
            int value=Integer.min(leftValue, rightValue);
            memo.put(key, value);
            return value;

        }

    }
}

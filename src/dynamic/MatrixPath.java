package dynamic;


import java.util.HashMap;
import java.util.Map;

public class MatrixPath {

    public static int DP(int [] [] A, int indexA, int indexB, int cost, int capacity){
        System.out.println("in1");
        if( indexA==A.length-1 && indexB==A.length-1) {
            System.out.println("in");
            if(capacity-cost==0)
                return 1;

            else if(cost >0)
                return 0;

        }
        if(indexA>=A[0].length || indexB>=A[0].length)
            return 0;

        if(indexA==A.length-1)
            return DP(A, indexA, indexB+1, cost+A[indexA][indexB], capacity);

        if(indexB==A.length-1)
            return DP(A, indexA+1, indexB, cost+A[indexA][indexB], capacity);

        int left=DP(A, indexA+1, indexB, cost+A[indexA][indexB], capacity);
        int right=DP(A, indexA, indexB+1, cost+A[indexA][indexB], capacity);
        return left+right;
    }


    public static void main(String[] args) {

        int A[][]={{4,7,1,6},
                {5,7,3,9},
                {3,2,1,2},
                {7,1,6,3}};

        long time=System.currentTimeMillis();
        System.out.println( DP(A, 0, 0, 0, 25));
        System.out.println("Divide and conquer DP "+(System.currentTimeMillis()-time));
        MatrixPath matrixPath=new MatrixPath();

        Partitioner partitioner=matrixPath.new Partitioner(A, 25);
        time=System.currentTimeMillis();
        System.out.println(partitioner.Solve());
        System.out.println("Dynamic programming DP "+(System.currentTimeMillis()-time));
    }


    private class Partitioner{

        private int A[][];
        Map<String, Integer> memo=new HashMap<>();

        private int capacity;
        public Partitioner(int [][] A, int capacity){
            this.A=A;
            this.capacity=capacity;







        }

        public int Solve(){

            return DP(0, 0, 0);

        }


        private int DP( int indexA, int indexB, int cost){


            if(indexA==A.length-1 && indexB==A.length-1)
            {

                if(capacity-cost==0)
                    return 1;

                else if(cost >0)
                    return 0;
            }

            if(indexA>=A[0].length || indexB>=A[0].length)
                return 0;

            String key=indexA+"|"+indexB+"|"+cost;

            if(memo.containsKey(key)){
                return memo.get(key);
            }

            if(indexA==A.length-1) {
                int node=DP(indexA, indexB + 1, cost + A[indexA][indexB]);
                memo.put(key,node );
                return node;

            }

            if(indexB==A.length-1) {
                int node =DP(indexA + 1, indexB, cost + A[indexA][indexB]);
                memo.put(key, node);
                return node;
            }

            int left=DP(indexA+1, indexB, cost+A[indexA][indexB]);
            int right=DP(indexA, indexB+1, cost+A[indexA][indexB]);


             memo.put(key,left+right);
             return left+right;

        }



    }


}

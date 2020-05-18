package dynamic;

public class MatrixChainMultiplication {


    private class Partitioner{
        private int [] A;
        private int [][] memo;
        private final int Marker;
        public Partitioner(int [] A){
            this.A=A;
            this.Marker=-1;
            memo=new int[A.length][];
            for(int i=0; i<A.length; i++)
                memo[i]=new int[A.length];

            for(int i=0; i<A.length; i++)
                for(int j=0; j<A.length; j++)
                    memo[i][j]=Marker;
        }


        public int Solve(){

            return DP(A, 0, A.length-1);
        }


        private int DP(int [] A, int indexA, int j){


            if(j<=indexA+1)
                return 0;

            if(memo[indexA][j]!=Marker)
                return memo[indexA][j];


            int min=Integer.MAX_VALUE;


            for(int k=indexA+1; k<=j-1; k++){

                int cost=DP(A, indexA, k);
                cost+=DP(A, k, j);

                cost+=A[indexA]*A[k]*A[j];

                if(cost < min)
                    min=cost;
            }

            memo[indexA][j]=min;
            return min;

        }
    }


    public static void main(String[] args) {

        int [] matrixes={10, 30, 5, 60};
        MatrixChainMultiplication matrixChainMultiplication=new MatrixChainMultiplication();

        Partitioner partitioner=matrixChainMultiplication.new Partitioner(matrixes);

        System.out.println(partitioner.Solve());

        int p[] = {40, 20, 30, 10, 30};

        Partitioner partitioner1=matrixChainMultiplication.new Partitioner(p);
        System.out.println(partitioner1.Solve());

        int p1[] = {10, 20, 30, 40, 30};

        Partitioner partitioner2=matrixChainMultiplication.new Partitioner(p1);
        System.out.println(partitioner2.Solve());

        int p2[] = {10, 20, 30};
        Partitioner partitioner3=matrixChainMultiplication.new Partitioner(p2);
        System.out.println(partitioner3.Solve());

    }
}

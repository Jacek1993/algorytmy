package dynamic;


import java.util.ArrayList;
import java.util.List;

public class MSIS {

    public static void main(String[] args) {


        int [] A={0,8,4,12,2,10,6,14,1,9,5,13,3,11};
        MSIS msis=new MSIS();

        Partitioner partitioner=msis.new Partitioner(A);
        System.out.println(partitioner.Solve());


        int []B={10,5,4,3};
        Partitioner partitioner1=msis.new Partitioner(B);
        System.out.println(partitioner1.Solve());

        int C[] = {1, 101, 2, 3, 100, 4, 5};
        Partitioner partitioner2=msis.new Partitioner(C);
        System.out.println(partitioner2.Solve());

        int D[]={3, 4, 5, 10};
        Partitioner partitioner3=msis.new Partitioner(D);
        System.out.println(partitioner3.Solve());
    }


    private class Partitioner{

        private int [] A;
        private int [][] memo;
        private final int Marker=-1;
        private int sum;
        private boolean [][] parentPointer;

        public Partitioner(int [] A){
            this.A=A;
            sum=0;
            for(int i=0; i<A.length; i++)
                sum+=A[i];

            memo=new int[A.length][];
            parentPointer=new boolean[A.length][];

            for(int i=0; i<A.length; i++) {
                memo[i] = new int[sum];
                parentPointer[i]=new boolean[sum];
            }


            for(int i=0; i<A.length; i++)
                for(int j=0; j<sum; j++)
                memo[i][j]=Marker;
        }

        public int Solve()
        {

            int dp=DP(A, 0, -1, 0);

            List<Integer> list=new ArrayList<>();
            int i=0;
            int j=0;
            while(i!=A.length){
                boolean choose=parentPointer[i][j];

                if(choose){
                    list.add(A[i]);
                    j+=A[i];
                }
                i++;
            }

            list.stream().forEach(System.out::print);
            System.out.println("\n");
            return dp;
        }

        private int DP(int [] A, int indexA, int prev, int cost){

            if(indexA==A.length)
                return cost;

            if(memo[indexA][cost]!=Marker)
                return memo[indexA][cost];


            int right=memo[indexA][cost]=DP(A, indexA+1, prev, cost);

            int left=cost;

            if(A[indexA] > prev) {
                prev = A[indexA];
                parentPointer[indexA][cost]=true;
                left = memo[indexA][cost]=DP(A, indexA + 1, prev, cost + A[indexA]);
            }



            return Integer.max(left, right);
        }


    }
}

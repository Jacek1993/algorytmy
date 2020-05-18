package dynamic;


class Node{
    public int V;
    public int W;
    public Node(int V, int W){
        this.V=V;
        this.W=W;
    }
}

public class Knapsack {

    private static int DP(Node [] A, int indexA, int capacity){

        if(capacity<0)
            return Integer.MIN_VALUE;

        if(indexA==A.length || capacity==0)
            return 0;


        int left=DP(A, indexA+1, capacity);
        int right=DP(A, indexA+1, capacity-A[indexA].W)+A[indexA].V;

        return Integer.max(left, right);

    }


    public static void main(String[] args) {
        Node [] A={new Node(20,1), new Node(5,2), new Node(10, 3), new Node(40, 8), new Node(15, 7), new Node(25, 4)};
        int capcity=10;

        System.out.println(DP(A, 0, capcity));

        Node[]B={new Node(60,10), new Node(100,20), new Node(120, 30)};
//        capcity=50;
        long time=System.currentTimeMillis();
        System.out.println(DP(A, 0, capcity));
        System.out.println("time using divide and conquer "+(System.currentTimeMillis()-time));
        Knapsack knapsack=new Knapsack();

        Partitioner partitioner=knapsack.new Partitioner(A, capcity);
        time=System.currentTimeMillis();
        System.out.println(partitioner.Solve());
        System.out.println("time using dynamic programming "+(System.currentTimeMillis()-time));

    }

    private class Partitioner{
        private Node [] A;
        private int Capacity;
        private final int Marker=-1;
        private int [][] memo;



        public Partitioner(Node [] A, int Capacity){
            this.A=A;
            this.Capacity=Capacity;

            memo=new int[A.length][];

            for(int i=0; i<A.length; i++)
                memo[i]=new int[Capacity+1];

            for(int i=0; i<A.length; i++)
                for(int j=0; j<Capacity+1; j++)
                    memo[i][j]=Marker;
        }


        public int Solve(){

            return DP(A, 0, Capacity);
        }

        private int DP(Node [] A, int indexA, int Capacity){

            if(Capacity <0)
                return Integer.MIN_VALUE;

            if(indexA ==A.length ||Capacity==0)
                return 0;

            if(memo[indexA][Capacity]!=Marker)
                return memo[indexA][Capacity];

            int left=memo[indexA][Capacity]=DP(A, indexA+1, Capacity);

            int right=memo[indexA][Capacity]=DP(A, indexA+1, Capacity-A[indexA].W)+A[indexA].V;

            return Integer.max(left, right);

        }
    }
}

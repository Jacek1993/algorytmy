package dynamic;

public class CoinChainProblem {

    public static int DP(int [] A, int indexA, int cost, int capacity){

        if(cost!=0 && indexA==0)
            return 0;
        if(indexA==A.length)
            return 0;
        if(cost +A[indexA] ==capacity)
            return DP(A, indexA+1, cost, capacity)+1;

        return DP(A, indexA+1, cost, capacity)+DP(A, indexA+1, cost+A[indexA], capacity);
    }

    public static void main(String[] args) {
        int[] A={1,3,5,7};
        System.out.println(DP(A, 0, 0, 8));
    }
}

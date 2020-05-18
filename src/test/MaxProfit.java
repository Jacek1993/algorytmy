package test;

public class MaxProfit {

    public static int solution(int [] A){
        if(A.length==0 ||A.length==1) return 0;
        int differ=0;

        for(int i=0; i<A.length-1; i++){
            for(int j=i+1; j<A.length;j++){
                if(A[j]-A[i] >differ) {
                    differ = A[j] - A[i];
                    System.out.println(differ);
                }
            }
        }
        return differ;
    }

    public static void main(String[] args) {
        int [] A={23171, 21011, 21123, 21366, 21013, 21367};
        System.out.println(solution(A));
    }
}

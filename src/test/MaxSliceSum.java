package test;

public class MaxSliceSum {

    public static int solution(int [] A){
        int sum=0, sumEv=Integer.MIN_VALUE;

        for(int i=0; i<A.length; i++){
            sum=A[i];
            for(int j=i+1; j<A.length; j++){
                if(sum+A[j]>sum) {
                    sum += A[j];
                    System.out.println(A[j]);
                }
                else
                    break;
            }
            if(sumEv<sum)
                sumEv=sum;
        }

        return sumEv;
    }

    public static void main(String[] args) {
        int [] A={3,2,-6,4,0};
        int [] B={-3,-2,-6,1,-1};
        System.out.println(solution(A));
        System.out.println(solution(B));
    }
}

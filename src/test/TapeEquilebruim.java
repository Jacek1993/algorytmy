package test;

public class TapeEquilebruim {

    public static int solution(int [] A){
        int sum=0, min=Integer.MAX_VALUE;

        for(int i=1; i<A.length; i++){
            sum+=A[i];
        }

        int xsum=A[0], result;

        for(int i=1; i<A.length; i++){
            result=Math.abs(xsum-sum);
            if(min >result)
                min=result;
            xsum+=A[i];
            sum-=A[i];
        }
        return min;
    }

    public static void main(String[] args) {
        int [] A={3,1,2,4,3};
        int [] B={3,-1,4,9,-7};
        System.out.println(solution(A));
        System.out.println(solution(B));
    }
}



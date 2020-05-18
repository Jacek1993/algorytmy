package test;

public class MissingInteger {

    public static int solution(int [] A){
        int max=Integer.MIN_VALUE;

        for(int i=0; i<A.length; i++){
            if(A[i] >max)
                max=A[i];
        }

        if(max <=0)return 1;

        boolean [] occurences=new boolean[max+2];

        for(int i=0; i<A.length; i++){
            occurences[A[i] >0? A[i]: 0]=true;
        }

        for(int i=1; i<occurences.length; i++){
            if(!occurences[i] )
                return i;
        }
        return max+1;
    }

    public static void main(String[] args) {
        int [] A={1,3,6,4,1,2};
        System.out.println(solution(A));
        int [] B={-1,-3};
        System.out.println(solution(B));
    }
}

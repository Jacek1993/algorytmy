package test;

public class SmallestPositiveInteger {

    public static int solution(int [] A){

        int min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;

        for(int i=0; i<A.length; i++){
            if(min > A[i])
                min=A[i];
            if(max <A[i])
                max=A[i];
        }

        min=min<0? min: 0;

        boolean [] tab=new boolean[max-min+1];

        for(int i=0; i<A.length; i++){
            tab[A[i]-min]=true;
        }

        for(int i=0; i<tab.length; i++){

            if(i+min >0 ){
                if(!tab[i])
                    return i;
            }
        }
        return max >0? max+1: 1;
    }

    public static void main(String[] args) {
        int [] A={1,3,6,4,1,2};
        System.out.println(solution(A));
        int [] B={1,2,3};
        System.out.println(solution(B));
        int [] C={-1,-3};
        System.out.println(solution(C));
    }
}

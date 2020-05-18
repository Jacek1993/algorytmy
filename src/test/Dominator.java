package test;

public class Dominator {

    public static int solution(int [] A){

        if(A.length<1) return -1;

        int max=Integer.MIN_VALUE, min=Integer.MAX_VALUE;

        for(int i=0; i<A.length; i++){
            if(A[i] < min)
                min=A[i];
            if(A[i] >max)
                max=A[i];
        }

        int contains[] =new int[(max-min)+1];
        int indexes[] =new int[(max-min)+1];

        for(int i=0; i<A.length; i++){
            contains[A[i]-min]=contains[A[i]-min]+1;
            indexes[A[i]-min]=i;
        }
        int maximum=0, index=0;
        for(int i=0; i<contains.length; i++){

            if(maximum <contains[i]) {
                maximum = contains[i];
                index=i;
            }
        }

        if(maximum <=A.length/2)
            return -1;

        else
            return indexes[index];

    }

    public static void main(String[] args) {
        int [] A={3,4,3,2,3,-1,3,3};

        System.out.println(solution(A));
    }
}

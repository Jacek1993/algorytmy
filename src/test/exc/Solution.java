package test.exc;

public class Solution {

    public static int solution(int [] A){

        if(A.length==0)
            return 0;
        if(A.length==1)
            return 1;

        int max=Integer.MIN_VALUE;
        int counter=0;

        for(int i=0; i<A.length-2; i++){

            if(A[i] >A[i+1]) {
                counter=2;
            }
            else if(A[i] < A[i+1]) {
                counter=2;
            }
            else {
                counter=0;
                continue;

            }

            for(int j=i+2; j <A.length; j++){

                if(A[j-1] < A[j] && A[j-2] > A[j-1])
                    counter++;

                else if(A[j-1] > A[j] && A[j-2] < A[j-1])
                    counter++;

                else
                    break;
//                System.out.println(counter);
            }

            if(counter >max)
                max=counter;
        }

        if(max==Integer.MIN_VALUE)
            max=1;

        return max;
    }

    public static void main(String[] args) {
        int [] A={9,4,2,10,7,8,8,1,9};
        System.out.println(solution(A));

        int [] B={4,8,12,16};
        System.out.println(solution(B));

        int [] C=new int[100];
        System.out.println(solution(C));

        int [] D=new int[100000];

        for(int i=0; i<D.length; i=i+2){
            D[i]=50;
            D[i+1]=150;
        }

        System.out.println(solution(D));
    }
}

package test.exc;

public class Solution1 {

    public static int solution(int [] A){

        int min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;

        for(int i=0; i<A.length; i++){

            if(A[i] > max)
                max=A[i];
            if(A[i] <min)
                min=A[i];

        }
        min=min >0 ? min : -min;
        int n=Math.abs(max+min)+1;


        if(min==max)
            return 1;

        boolean[] tab=new boolean[n+1];



        for(int i=0; i<A.length; i++){

            tab[A[i]+min]=true;
        }

        int distance=0;
        int counter=0;

        for(int i=0; i<tab.length; i++)
        {
            if(!tab[i]){
                counter++;
            }
            else {
                counter=0;
            }
            if(counter > distance)
                distance=counter;
        }

        return distance/2;


    }


    public static void main(String[] args) {
        int [] A={10,0,8,2,-1,12,11, 3};

        System.out.println(solution(A));

        int [] B={5,5};

        System.out.println(solution(B));
    }
}

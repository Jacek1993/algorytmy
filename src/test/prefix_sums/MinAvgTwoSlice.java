package test.prefix_sums;

import java.util.Arrays;

public class MinAvgTwoSlice {

    public static int solution(int [] A){
        int [] tab=new int[A.length];
        tab[A.length-1]=A[A.length-1];
        for(int i=A.length-1; i>=1; i--){
            tab[i-1]=tab[i]+A[i-1];
        }

//        System.out.println(Arrays.toString(tab));

        int j=1;
        double min=Integer.MAX_VALUE;
        double var;
        int min_index=-1;
        do{
            for(int i=0;i+j<A.length; i+=j){
                if(i+j+1 <A.length)
                var=(tab[i]-tab[i+j+1])/(j+1);
                else
                    var=tab[i]/(j+1);
                if(min >var){
                    min =var;
                    min_index=i;
                }
            }
            j++;

        }while(j <A.length);
//        System.out.println(min);
        return min_index;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{4,2,2,5,1,5,8}));
    }
}

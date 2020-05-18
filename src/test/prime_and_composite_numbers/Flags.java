package test.prime_and_composite_numbers;

import java.util.Arrays;

public class Flags {

    public static int solution(int [] A){
        boolean [] flagsT=new boolean[A.length];
        int counter=0;
        for(int i=1; i<A.length-1; i++){
            if(A[i] >A[i-1] && A[i]>A[i+1]){
                flagsT[i]=true;
                counter++;
            }
        }
        if(counter==0) return 0;
        int [] flags=new int[counter];

        for(int i=1, j=0; i<flagsT.length-1; i++){
            if(flagsT[i]){
                flags[j]=i;
                j++;
            }
        }

        //System.out.println(Arrays.toString(flags));

        int flagCounter=1;

        int provider=0;

        for(int i=1; i<=counter;i++ ){
            provider=1;
            for(int j=1, k; j<flags.length; j++){

                if(flags[j]-flags[j-1] >i){
                   // System.out.println(flags[j+1]+"  "+flags[j]);
                    provider++;
                }else{
                    for(k=j+1; k<flags.length ;k++){
                        if(flags[k]-flags[j-1] >i){
                            System.out.println(flags[k]+" ksp "+flags[j-1]);
                            provider++;
                            break;
                        }
                    }
                   // System.out.println("weszlo "+i+ " j "+j+" fc "+provider);
                    j=k;
                }
                System.out.println(provider+" "+i );
            }
           // System.out.println("provider "+provider);

            if(provider>=i){
                    flagCounter=i;
            }
        }

        return flagCounter;
    }

    public static void main(String[] args) {
        int []A={1,5,3,4,3,4,1,2,3,4,6,2};
        System.out.println(solution(A));

    }
}

/*
A non-empty array A consisting of N integers is given.

A peak is an array element which is larger than its neighbours. More precisely, it is an index P such that 0 < P < N − 1 and A[P − 1] < A[P] > A[P + 1].

For example, the following array A:
    A[0] = 1
    A[1] = 5
    A[2] = 3
    A[3] = 4
    A[4] = 3
    A[5] = 4
    A[6] = 1
    A[7] = 2
    A[8] = 3
    A[9] = 4
    A[10] = 6
    A[11] = 2

has exactly four peaks: elements 1, 3, 5 and 10.

You are going on a trip to a range of mountains whose relative heights are represented by array A, as shown in a figure below. You have to choose how many flags you should take with you. The goal is to set the maximum number of flags on the peaks, according to certain rules.

Flags can only be set on peaks. What's more, if you take K flags, then the distance between any two flags should be greater than or equal to K. The distance between indices P and Q is the absolute value |P − Q|.

For example, given the mountain range represented by array A, above, with N = 12, if you take:
 */

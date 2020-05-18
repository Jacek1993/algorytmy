package test.eratostenes;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class CountSemiPrimes {

    public static int[] solution(int N, int[] P, int [] Q){

       int max=0, counter=0;

       for(int i=0; i<Q.length; i++){
           if(Q[i] <=N){
               counter++;
               if(max<Q[i])
                   max=Q[i];
           }
       }

       int [] result;
       int [] result1=new int[counter];
        result=eratostenesSieve(max/2);

        System.out.println(Arrays.toString(result));
        Set<Integer> set=new TreeSet<>(Arrays.asList(IntStream.of(result).boxed().toArray(Integer[]::new)));
       int counter1=0;

       for(int i=0, k=0; i<Q.length; i++){
           if(Q[i]>N)
               continue;

           for(int j=P[i]; j<=Q[i]; j++){

               int finder=Arrays.binarySearch(result, j/2);
               finder=finder>=0? finder: Math.abs(finder)-1;
               System.out.println(finder);

               for(int ii=0; ii<=finder; ii++){
                   if(j%result[ii]==0 && set.contains(j/result[ii])){
                       counter1++;
                       break;
                   }
               }


           }
           result1[k]=counter1;
           counter1=0;
           k++;

       }
        return result1;

    }

    static int [] eratostenesSieve(int max){
        boolean[] eratostenes=new boolean[max+1];
        int w=0;

        for(int i=2; i<=max; i++){
            w=i*i;
            while(w<=max){
                eratostenes[w]=true;
                w+=i;
            }
        }



        int counter=0;

        for(int i=2; i<=max; i++)
            if(!eratostenes[i])
                counter++;

            int [] primes=new int[counter];

            for(int i=2,k=0; i<=max; i++){
                if(!eratostenes[i]) {
                    primes[k] = i;
                    k++;
                }
            }

            return primes;

    }

    public static void main(String[] args) {

        int[] P={1,4,16};
        int[]Q={26,10,20};
        int N=26;
        System.out.println(Arrays.toString(solution(N, P, Q)));
    }


}


/*


A prime is a positive integer X that has exactly two distinct divisors: 1 and X. The first few prime integers are 2, 3, 5, 7, 11 and 13.

A semiprime is a natural number that is the product of two (not necessarily distinct) prime numbers. The first few semiprimes are 4, 6, 9, 10, 14, 15, 21, 22, 25, 26.

You are given two non-empty arrays P and Q, each consisting of M integers. These arrays represent queries about the number of semiprimes within specified ranges.

Query K requires you to find the number of semiprimes within the range (P[K], Q[K]), where 1 ≤ P[K] ≤ Q[K] ≤ N.

For example, consider an integer N = 26 and arrays P, Q such that:
    P[0] = 1    Q[0] = 26
    P[1] = 4    Q[1] = 10
    P[2] = 16   Q[2] = 20

The number of semiprimes within each of these ranges is as follows:

        (1, 26) is 10,
        (4, 10) is 4,
        (16, 20) is 0.

Write a function:

    class Solution { public int[] DP(int N, int[] P, int[] Q); }

that, given an integer N and two non-empty arrays P and Q consisting of M integers, returns an array consisting of M elements specifying the consecutive answers to all the queries.

For example, given an integer N = 26 and arrays P, Q such that:
    P[0] = 1    Q[0] = 26
    P[1] = 4    Q[1] = 10
    P[2] = 16   Q[2] = 20

the function should return the values [10, 4, 0], as explained above.

Write an efficient algorithm for the following assumptions:

        N is an integer within the range [1..50,000];
        M is an integer within the range [1..30,000];
        each element of arrays P, Q is an integer within the range [1..N];
        P[i] ≤ Q[i].


 */

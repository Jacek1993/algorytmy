package dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//The longest repeated subsequence (LRS) problem is the problem of finding the longest subsequences of a string that occurs at least twice.
//Length of Longest Repeating Subsequence is 4
//Longest Repeating Subsequence is ATCG  to ATACTCGGA

//1 subproblem tutaj to chyba to żeby dwa elementy tablicy były sobie rowne
//2 musimy zgadnac ktory element tablicy jest rowny elementowi i'temu
//3




public class LRS {
    private static String A;




    public static int LRSLength(String X, int m, int n)
    {
        // return if we have reached the end of either string
        if (m == 0 || n == 0) {
            return 0;
        }

        // if characters at index m and n matches and index is different
        if (X.charAt(m - 1) == X.charAt(n - 1) && m != n) {
            return LRSLength(X, m - 1, n - 1) + 1;
        }

        // else if characters at index m and n don't match
        return Integer.max(LRSLength(X, m, n - 1),
                LRSLength(X, m - 1, n));
    }


    private static int max(int a, int b){
        return a>b ? a: b;
    }

    public static void main(String[] args) {
        A="atactcggabrbrjjpplluyguyhguyguyikguykg";

        LRS lrs=new LRS();
        Partitioner partitioner=lrs.new Partitioner(A);

        System.out.println(partitioner.Solve());



        System.out.println(LRSLength(A, A.length(), A.length()));
    }


    private class Partitioner {

        private final int Marker=-1;
        private String A;
        private int [][] memo;



        public Partitioner(String A){
            this.A=A;



            memo=new int[A.length()][];

            for(int i=0; i<A.length(); i++)
                memo[i]=new int[A.length()];

            for(int i=0; i<A.length(); i++)
                for (int j=0; j<A.length(); j++)
                memo[i][j]=Marker;
        }

        public int Solve(){

            List<Integer> list=new ArrayList<>();

            return DP(A, 0, 0, list);
        }


        private int DP(String A, int indexA, int indexB, List<Integer> list){

            if(indexA==A.length() || indexB==A.length()){
                list.clear();
                return 0;
            }

            if(memo[indexA][indexB]!=Marker)
                return memo[indexA][indexB];

            if(A.charAt(indexA)==A.charAt(indexB) && !list.contains(indexB) &&indexA!=indexB){
                list.add(indexB);
                return memo[indexA][indexB]=DP(A, indexA+1, indexB+1, list)+1;

            }


            return memo[indexA][indexB]=max(DP(A, indexA+1, indexB, list), DP(A, indexA, indexB+1, list));


        }

    }
}

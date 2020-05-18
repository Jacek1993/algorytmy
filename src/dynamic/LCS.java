package dynamic;
//todo trzeba poprawic parentPointery ale na razie nie wiem jak :(

//1 if letters of both words are the same we increase cost of DP otherwise we take maximum of counted value
//2 we have to guess where is the first letter that both words have the same
//3 using recursion we glue two pieces together max(DP(A, indexA+1, B, indexB), DP(A, indexA, B, indexB+1))
//4 complexity of algorithm is equal A.length X B.length
//5 remember about parent pointers


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LCS {


    public static int DP(String A, int indexA, String B, int indexB ){

        if(A.length()==indexA || B.length()==indexB)
            return 0;
        if(A.charAt(indexA)==B.charAt(indexB))
            return DP(A, indexA+1, B, indexB+1)+1;

        return max(DP(A, indexA+1, B, indexB), DP(A, indexA, B, indexB+1));
    }

    public static int max(int a, int b){
        return a>b? a: b;
    }

    public static void main(String[] args) {
        String adam="adammakotaa";
        String ala="alamapsaaki";
        long time=System.currentTimeMillis();
        int dp=DP(adam, 0, ala, 0);
        System.out.println("Time for divide and conquer "+(System.currentTimeMillis()-time));
        System.out.println(dp);

        LCS lcs=new LCS();

        Partitioner partitioner=lcs.new Partitioner(adam, ala);
        time=System.currentTimeMillis();
        System.out.println(partitioner.Solve());
        System.out.println("Time for dynamic DP "+(System.currentTimeMillis()-time));

        String X="XMJYAUZ", Y="MZJAWXU";
        Partitioner partitioner1=lcs.new Partitioner(X, Y);
        System.out.println(partitioner1.Solve());

    }

    private class Partitioner{
        private final int Marker=-1;
        private int [][] memo;
        private String A;
        private String B;
        private boolean [] parentPointers;


        public Partitioner(String A, String B){
            this.A=A;
            this.B=B;
            memo=new int[A.length()][];
            parentPointers=new boolean[A.length()];
            for(int i=0; i<A.length(); i++) {
                memo[i] = new int[B.length()];

            }

            for(int i=0; i<A.length(); i++){
                for(int j=0; j<B.length(); j++)
                    memo[i][j]=Marker;
            }


        }

        public String Solve(){
            System.out.println("In Partitioner");
            System.out.println(DP(A, 0, B, 0));
            System.out.println("Using iteration");
            System.out.println(DP1(A, B));


            StringBuffer buffer=new StringBuffer();

            System.out.println(Arrays.toString(parentPointers));

            int i=0;
            while(i!=A.length()){
                if(parentPointers[i])
                    buffer.append(A.charAt(i));
                i++;
            }



            return buffer.toString();


        }

        private int DP(String A, int indexA, String B, int indexB){

            if(A.length()==indexA || B.length()==indexB)
                return 0;



            if(memo[indexA][indexB]!=Marker)
                return memo[indexA][indexB];


            if(A.charAt(indexA)==B.charAt(indexB)){


                return memo[indexA][indexB]=DP(A, indexA+1, B, indexB+1)+1;

            }

            int left =DP(A, indexA+1, B, indexB);
            int right=DP(A, indexA, B, indexB+1);
            int max=left;
            if(right > left){
                max=right;
                parentPointers[indexA]=true;
            }

            return memo[indexA][indexB] =max;

        }

        private int DP1(String A, String B){

            int n=A.length(), m=B.length();

            int [][] tab=new int[n+1][m+1];


            for(int i=1; i<=n; i++){
                for(int j=1; j<=m; j++){


                    if(A.charAt(i-1)==B.charAt(j-1))
                        tab[i][j]=tab[i-1][j-1]+1;
                    else
                        tab[i][j]=Integer.max(tab[i][j-1], tab[i-1][j]);

                }
            }

            return tab[n][m];
        }

    }
}

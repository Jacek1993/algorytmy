package dynamic;

////The shortest common supersequence (SCS) is the problem of finding the shortest supersequence Z of given sequences X and Y such that both X & Y are subsequences of Z.

//X: ABCBDAB
//Y: BDCABA
//The length of SCS is 9
//SCS are ABCBDCABA, ABDCABDAB and ABDCBDABA

//1 subproblem: jesli nasze znaki w String'u sa takie same to to zabieramy je raz z obu zbiorow jestli nie bo zabieramy jeden znak z jednego zbioru i drugi z drugiego
//2 trzeba zgadmac ktory w jaki sposob dodaje sie znaki z obu zbiorow
//



public class SCS {

    private static String A;
    private static String B;


    public static int DP(String A, int indexA, String B, int indexB){

        if(A.length()==indexA )
            return B.length()-indexB;
        if(B.length()==indexB)
            return A.length()-indexA;               //to jest reszta tablicy ktora zostaje gdy pierwsza tablicy sie skonczy

        if(A.charAt(indexA)==B.charAt(indexB))
            return DP(A, indexA+1, B, indexB+1)+1;

        return Integer.min(DP(A, indexA+1, B, indexB)+1, DP(A, indexA, B, indexB+1)+1);
    }

    public static int DP1(String A, String B){

        int n=A.length(), m=B.length();

        int lookup[][]=new int [n+1][m+1];


        for(int i=0; i<=n; i++)
            lookup[i][0]=i;

        for(int j=0; j<=m; j++)
            lookup[0][j]=j;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){

                if(A.charAt(i-1)==B.charAt(j-1))
                    lookup[i][j]=lookup[i-1][j-1]+1;
                else
                    lookup[i][j]=Integer.min(lookup[i-1][j]+1, lookup[i][j-1]+1);

            }
        }

        return lookup[n][m];

    }


    public static int SCSLength(String X, String Y, int m, int n)
    {
        // if we have reached the end of either sequence, return
        // length of other sequence
        if (m == 0 || n == 0) {
            return n + m;
        }

        // if last character of X and Y matches
        if (X.charAt(m - 1) == Y.charAt(n - 1)) {
            return SCSLength(X, Y, m - 1, n - 1) + 1;
        }

        // last character of X and Y don't match
        return Integer.min(SCSLength(X, Y, m, n - 1) + 1,
                SCSLength(X, Y, m - 1, n) + 1);
    }





    public static void main(String[] args) {

        A="abcbdabasgh";
        B="bdcabaahfdahqrwefjhgfsdjhkldfjlk";

        long time=System.currentTimeMillis();
        System.out.println(DP(A, 0, B, 0));

        System.out.println(SCSLength(A,B, A.length(), B.length()));

        SCS scs=new SCS();

        Partitioner partitioner=scs.new Partitioner(A, B);

        System.out.println(partitioner.Solve());

        System.out.println(DP1(A, B));


    }


    private class Partitioner{

        private String A;
        private String B;
        private int memo[][];
        private final int Marker=-1;

        public Partitioner(String A, String B){
            this.A=A;
            this.B=B;

            memo=new int[A.length()][];

            for(int i=0; i<A.length(); i++)
                memo[i]=new int[B.length()];

            for(int i=0; i<A.length(); i++)
                for(int j=0; j<B.length(); j++)
                    memo[i][j]=Marker;
        }

        public int Solve(){
            return DP(A, 0, B, 0);
        }

        private int DP(String A, int indexA, String B, int indexB){

            if(A.length()==indexA)
                return B.length()-indexB;
            if(B.length()==indexB)
                return A.length()-indexA;

            if(memo[indexA][indexB]!=Marker)
                return memo[indexA][indexB];


            if(A.charAt(indexA)==B.charAt(indexB))
                return memo[indexA][indexB]=DP(A, indexA+1, B, indexB+1)+1;

            int left=memo[indexA][indexB]=DP(A, indexA+1, B, indexB)+1;
            int right=memo[indexA][indexB]=DP(A, indexA, B, indexB+1)+1;

            return Integer.min(left, right);


        }




    }

}

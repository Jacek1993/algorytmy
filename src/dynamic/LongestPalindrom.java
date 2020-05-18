package dynamic;

import java.util.Arrays;

public class LongestPalindrom {

    private static String A;

    private static int palindrom(int i, int j){

//        if(j> (A.length()-i-1))
//            return 0;

        int h=i, l=j;
        while(h<l){
            if(A.charAt(h++) != A.charAt(l--))
                return 0;
        }

        return i==0? j-i+1 : j-i;
    }

    public static void main(String[] args) {
        A="abba";
        String B="abbccbba";
        String C="abbdcacb";
        LongestPalindrom longestPalindrom=new LongestPalindrom();
        Partitioner partitioner=longestPalindrom.new Partitioner(A);
        partitioner.Solve();
        System.out.println(Arrays.toString(partitioner.getMemo()));

        Partitioner partitioner1=longestPalindrom.new Partitioner(B);
        partitioner1.Solve();
        System.out.println(Arrays.toString(partitioner1.getMemo()));

        Partitioner partitioner2=longestPalindrom.new Partitioner(C);
        partitioner2.Solve();
        System.out.println(Arrays.toString(partitioner2.getMemo()));

        String D="forgeeksskeegfor";
        Partitioner partitioner3=longestPalindrom.new Partitioner(D);
        partitioner3.Solve();
        System.out.println(Arrays.toString(partitioner3.getMemo()));

        String E="mamkajak";
        Partitioner partitioner4=longestPalindrom.new Partitioner(E);
        partitioner4.Solve();

        System.out.println(Arrays.toString(partitioner4.getMemo()));

        A="mamkajak";
        System.out.println(palindrom(0,7));
        System.out.println(A.charAt(3)+" "+A.charAt(7));
    }


    private class Partitioner{

        private String A;
        private int [] memo;
        private final int Marker;

        public Partitioner(String A){
            this.A=A;
            Marker=-1;
            memo=new int[A.length()];

            for(int i=0; i<A.length(); i++)
                memo[i]=Marker;
        }


        public void Solve(){

             DP(0);
             int max=-1;
             for(int i=0; i<A.length(); i++) {
                 if (max < memo[i]) {
                     max = memo[i];
                 }
             }

            System.out.println("max is equal "+max);
        }

        public void DP(int i){

            if(i==A.length())
                return ;



            int maxPalindrom=0;

            for(int j=i+1; j<A.length(); j++){

                DP(j);
                int palindrom=palindrom(i, j);


                if(maxPalindrom < palindrom){
                    maxPalindrom=palindrom;
                }
            }

            memo[i]=maxPalindrom;

        }

        private  int palindrom(int i, int j){

            int h=i, l=j;
            while(h<l){
                if(A.charAt(h++) != A.charAt(l--))
                    return 0;
            }

            return i==0? j-i+1 : j-i+1;
        }

        public int[] getMemo() {
            return memo;
        }
    }
}

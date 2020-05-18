package dynamic;

import java.util.LinkedList;
import java.util.Queue;

public class InterleavingString {

    private static final Queue<Character> list = new LinkedList<>();

    private static boolean DP(String A, int indexA, String B){

        if (A.length() == indexA) {

            if (B.isEmpty())
                return false;
            else
                return true;
        }


        if (!B.isEmpty() ) {
            System.out.println(B);
            if((char)(B.charAt(B.length()-1) + 1) != A.charAt(indexA))
            return false;
            else
                return true;
        }
        System.out.println(B);
        boolean stay = DP(A, indexA + 1, B.concat(A.substring(indexA, indexA+1)));
        boolean leave = DP(A, indexA + 1, B);
        return stay || leave;
    }


    private static Queue<Character> add(char a) {

        list.add(a);
        return list;
    }

    public static void main(String[] args) {
        String A = "ACBD";
        String C="ABC";
        String D="ACE";
        String B="";

        System.out.println(DP(A, 0, B));
        B="";
        System.out.println(DP(C, 0, B));
        B="";
        System.out.println(DP(D, 0, B));
        System.out.println(B);

        System.out.println((char)('A'+1));
    }
}



package dynamic;

public class WildcardPatternMatching {

    //A string to pattern B string to dopasowanie

    public static boolean DP(String A, int indexA, String B, int indexB){

        if(indexA==A.length() || indexB==B.length()){

            if(indexA >= A.length()-1 && indexB >=B.length()-1)
                return true;
            else
                return false;
        }

        if(Character.isAlphabetic(A.charAt(indexA))){

            if(A.charAt(indexA)==B.charAt(indexB))
                DP(A, indexA+1, B, indexB+1);
            else
                return false;
        }

        if(A.charAt(indexA) =='?'){
            DP(A, indexA+1, B, indexB+1);
        }

        return false;

    }
}

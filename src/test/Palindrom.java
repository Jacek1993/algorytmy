package test;

public class Palindrom {
    public static boolean isPalindrome(String word) {

        int length=word.length();
        int start=0;
        int end=length-1;

       word= word.toLowerCase();

        while(true){

            if(word.charAt(start) != word.charAt(end)) {
                System.out.println(word.charAt(start)+"  "+word.charAt(end));
                return false;

            }

            if(start==end)
                break;

            start++;
            end=length-1-start;

        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(Palindrom.isPalindrome("Deleveled"));
    }
}
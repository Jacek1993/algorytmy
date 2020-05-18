package test;

import java.util.ArrayDeque;
import java.util.Deque;

public class StringProperlyNested {

    public static int solution(String S){
        Deque<Character> stack=new ArrayDeque<>();
        char sign;
        char sign1='0';
        for(int i=0; i<S.length(); i++){

            sign=S.charAt(i);

            if(sign=='(')
                stack.push(sign);
            if(sign==')'){
                if(stack.isEmpty())
                    return 0;
                sign1=stack.pop();
                if(sign1!='(')
                    return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        String S="(()(())())";
        System.out.println(solution(S));
        String S1="())";
        System.out.println(solution(S1));
    }
}


/*


A string S consisting of N characters is called properly nested if:

        S is empty;
        S has the form "(U)" where U is a properly nested string;
        S has the form "VW" where V and W are properly nested strings.

For example, string "(()(())())" is properly nested but string "())" isn't.

Write a function:

    class Solution { public int DP(String S); }

that, given a string S consisting of N characters, returns 1 if string S is properly nested and 0 otherwise.

For example, given S = "(()(())())", the function should return 1 and given S = "())", the function should return 0, as explained above.

Write an efficient algorithm for the following assumptions:

        N is an integer within the range [0..1,000,000];
        string S consists only of the characters "(" and/or ")".


 */

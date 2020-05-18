package test;

import java.util.ArrayDeque;
import java.util.Deque;

public class StringNested {

    public static int solution(String S){
        Deque<Character> stack=new ArrayDeque<>();
        char sign;
        boolean isEmpty=true;
        for(int i=0; i<S.length(); i++){
            sign=S.charAt(i);
            if(sign=='(' || sign=='{' || sign=='[')
                stack.push(sign);

            if(sign==')'&& stack.poll()!='(')
                return 0;
            if(sign=='}' && stack.poll()!='{')
                return 0;
            if(sign==']' && stack.poll()!='[')
                return 0;

        }
        return 1;
    }

    public static void main(String[] args) {
        String s="{[()()]}";
        System.out.println(solution(s));
        System.out.println(solution("([)()]"));
    }
}

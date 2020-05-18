package dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* On the MIT course, there is presented an approach to DP in 5 easy steps. Those are:

    1 define subproblems, count number of subproblems
    2 guess (part of DP), count number of choices
    3 relate subproblem solutions, compute time per subproblem
    4 recurse + memoize OR build DP table bottom-up check subproblems acyclic/topological order, time = time per subproblem · number of subproblems
    5 solve original problem: = a subproblem OR by combining subproblem solutions ⇒ extra time

    link:   https://www.youtube.com/watch?v=ENyox7kNKeY&list=PLfMspJ0TLR5HRFu2kLh3U4mvStMO8QURm&index=3&t=2s
*/

public class Justifier {

    private int Marker=-1;
    private int width;
    private String [] words;
    private int [] parentPointers;
    private int memo[];

    public Justifier(String text, int width){

        this.width=width;
        this.words=text.split(" ");
        parentPointers=new int[this.words.length];
        memo=new int[words.length];

        for(int i=0; i<memo.length; i++){
            memo[i]=Marker;
        }

    }

    public List<String> solve(){
        DP(0);

        List<String> result=new ArrayList<>();
        int from=0;


        while(from !=words.length){
            int next=parentPointers[from];
            result.add(String.join(" ", Arrays.copyOfRange(words, from, next)));
            from =next;

        }


        return result;
    }

    private int DP(int i){

        if(i==words.length)
            return 0;
        if(memo[i]!=Marker)
            return memo[i];

        int minBadness=Integer.MAX_VALUE;

        for(int j=i+1; j<=words.length; j++){

            //int badness=Badness(i,j)+DP(j);

            int badness=DP(j)+Badness(i,j);

            if(minBadness > badness){
                parentPointers[i]=j;
                minBadness=badness;
            }
        }

        memo[i]=minBadness;
        return minBadness;

    }

    public int[] getMemo() {
        return memo;
    }

    private int Badness(int i, int j){
        int lengthOfWords=0;

        for(int k=i; k<j; k++){
            lengthOfWords+=words[k].length();
        }
        int numberOfSpaces=j-i-1;
        if(lengthOfWords+numberOfSpaces > width)
            return 10*1000*1000;
        return (int) Math.pow(width-lengthOfWords-numberOfSpaces, 3);
    }

    public static void main(String[] args) {
        Justifier justifier=new Justifier("this is some code to split", 10);
        Justifier justifier1=new Justifier("this is some code to split this is some text to split", 10);
        System.out.println(justifier.solve());
        System.out.println(justifier1.solve());
        System.out.println(Arrays.toString(justifier.getMemo()));
        System.out.println(Arrays.toString(justifier1.getMemo()));

    }
}

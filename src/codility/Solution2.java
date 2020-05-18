package codility;

public class Solution2 {

    public static int solution(String S){
        int v=Integer.parseInt(S,2);

        int steps=0;

        while(v!=0){
            if(v%2==0){
                v/=2;
                steps++;
                continue;
            }
            else{
                v-=1;
                steps++;

            }
        }

        return steps;
    }

    public static void main(String[] args) {

        System.out.println(solution("011100"));
        System.out.println(solution("0"));

    }
}

package test;

public class CountDiv {

    public static int solution (int A, int B, int K){

        int count=0;
        boolean sign=false;
        for(int i=A; i<=B; ){




            if(i%K==0){
                count++;
                i+=K;
                continue;
            }

            i++;

        }
        return count;
    }

    public static void main(String[] args) {
        int A=6,B=11, K=2;

        System.out.println(solution(A,B,K));
        System.out.println(solution(A,B,3));
        System.out.println(solution(A,B,4));
    }
}

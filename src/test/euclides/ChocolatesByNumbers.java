package test.euclides;

public class ChocolatesByNumbers {

    public static int solution(int N, int M){
        int n=N, m=M;

        while (n!=m){
            if(n >m)
                n=n-m;
            if(n<m)
                m=m-n;
        }

        return N/n;
    }

    public static void main(String[] args) {
        int N=10, M=4;
        System.out.println(solution(N, M));
    }
}

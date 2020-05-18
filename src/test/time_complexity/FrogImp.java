package test.time_complexity;

public class FrogImp {

    public static int solution(int X, int Y, int D){
        int bias=Y-X;

        int n=bias/D;

        if(bias%D!=0){
            n++;
        }

        return n;
    }

    public static void main(String[] args) {
        System.out.println(solution(10, 85, 30));
    }
}

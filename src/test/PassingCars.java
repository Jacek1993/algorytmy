package test;

public class PassingCars {

    public static int solution(int [] A){
        if(A.length >1000000000)
            return -1;

        int counter=0;
        int pairs=0;

        for(int i=A.length-1; i>=0; i--){

            if(A[i]==1){
                counter++;
            }
            else if(A[i]==0){
                pairs+=counter;
            }
        }

        return pairs;
    }

    public static void main(String[] args) {
        int [] A={0,1,0,1,1};
        int [] B={0,0,0,1,1};
        int [] C={1,1,0,0,0};
        System.out.println(solution(A));
        System.out.println(solution(B));
        System.out.println(solution(C));
    }
}

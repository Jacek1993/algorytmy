package dynamic;

public class TilingProblem {
    //if we place first tile vertically the problem reduces to count(n1)
    //if we place first tile horizontally we have to place second tile also horizontally. The problem reduces to count(n-2)
    //Therefore count can be written as below:
    //count(n)=n if n=1 or n=2
    //else count(n)=count(n-1)+count(n-2)

    static int tilingProblem(int n){

        int [] tab=new int [n];
        tab[0]=1;
        tab[1]=2;

        for(int i=2; i<n; i++){
            tab[i]=tab[i-1]+tab[i-2];
        }

        return tab[n-1];
    }

    public static void main(String[] args) {

        int solution=tilingProblem(5);
        System.out.println(solution);
    }
}

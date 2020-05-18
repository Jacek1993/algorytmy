package test.time_complexity;

public class PermMissingElem {

    public static int solution(int [] A){
        boolean [] tab=new boolean[A.length+2];

        for(int i=0; i<A.length; i++){
            tab[A[i]]=true;
        }

        for(int i=1; i<tab.length; i++){
            if(!tab[i])
                return i;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2,3,1,5}));
    }
}

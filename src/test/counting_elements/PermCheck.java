package test.counting_elements;

public class PermCheck {

    public static int solution(int [] A){

        int max=0, min=Integer.MAX_VALUE;

        for(int i=0; i<A.length; i++){
            if(max <A[i])
                max=A[i];
            if(min >A[i])
                min=A[i];
        }

        if(A.length !=max)
            return 0;
        if(min!=1)
            return 0;

        int tab []=new int[A.length+1];

        for(int i=0; i<A.length; i++){
            tab[A[i]]++;
        }

        for(int i=1; i<tab.length; i++){
            if(tab[i]!=1)
                return 0;
        }

        return 1;

    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{4,1,3,2}));
        System.out.println(solution(new int[]{4,1,3}));
    }
}

package codility;

import java.util.Arrays;

public class Solution3 {

    public static int solution(int [] A){

        int [] help=new int[A.length];

        help[0]=A[0];

        for(int i=1; i<A.length; i++)
            help[i]=help[i-1]+A[i];

      int counter=0;

      int value;

      for(int i=0; i<help.length; i++){
          if(help[i]==0){
              counter++;
          }
      }



      for(int i=0; i<A.length; i++){
          for(int j=i+1; j<A.length; j++) {
              value = help[j] - help[i];
              if(value==0)
                  counter++;

          }
      }

      if(counter>1_000_000_000)
          return -1;


        return counter;
    }

    public static void main(String[] args) {
        System.out.println( solution(new int[]{2,-2,3,0,4,-7}));
    }

}

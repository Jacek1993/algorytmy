package test.prime_and_composite_numbers;

import java.util.Arrays;

public class PeakCount {

    public static int solution(int [] A){

        boolean [] peaksT=new boolean[A.length];
        int counter=0;

        for(int i=1; i<A.length-1; i++){
            if(A[i]>A[i-1] && A[i]>A[i+1]){
                peaksT[i]=true;
                counter++;
            }
        }

        System.out.println("peaks "+Arrays.toString(peaksT));

        int [] peaks=new int[counter];

        for(int i=1, j=0; i<peaksT.length-1; i++){
            if(peaksT[i]) {
                peaks[j] = i;
                j++;
            }
        }

        if(counter==0) return 0;
        if(counter==1) return 1;

        int diff=0;
        int peak1=-1, peak2=-1;

        System.out.println("counter "+counter);
        System.out.println(Arrays.toString(peaks));

        for(int i=1; i<peaks.length; i++){

            if(peaks[i]-peaks[i-1] >diff) {
                diff = peaks[i - 1] - peaks[i];
                peak1=peaks[i-1];
                peak2=peaks[i];


            }
        }

        System.out.println("p1 "+peak1+" p2 "+peak2);

        int peakCounter=0;

        for(int i=1; i<=A.length; i++){

            if(A.length%i==0){


                if(peak2/(A.length/i)-peak1/(A.length/i)<=1){
                    peakCounter++;
                    System.out.println(i);
                }else{
                    break;
                }
            }
        }

        return peakCounter;

    }

    public static void main(String[] args) {
        int [] A={1,2,3,4,3,4,1,2,3,4,6,2};
        System.out.println(solution(A));
    }
}

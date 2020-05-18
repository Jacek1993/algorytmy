package test.binarysearch;

import java.util.Arrays;
import java.util.Random;

public class BinarySearch {

    public static int solution(int [] A, int x){
        int beg=0;
        int end=A.length-1;
        int result=-1;
        while(beg<=end){
            int mid=(beg+end)/2;
            if(A[mid] >=x){
                System.out.println(A[mid]);
                end=mid-1;
                result=A[mid];
            }
            else
                beg=mid+1;

        }
        return result;
    }

    public static void main(String[] args) {
        int []A={2,6,8,12,9,4,14,19};


        Arrays.sort(A);
        System.out.println(Arrays.toString(A));

        System.out.println(solution(A,16));
    }
}

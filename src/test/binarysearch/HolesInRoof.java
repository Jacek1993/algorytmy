package test.binarysearch;

public class HolesInRoof {

    public static int boards(int [] A, int k){
        int n=A.length;
        int beg=0;
        int end=A.length-1, result=-1,mid;

        while(beg<=end){
            mid=(beg+end)/2;
            if(check(A, mid) <=k){
                end=mid-1;
                result=mid;
            }
            else{
                beg=mid+1;
            }
        }
        return result;
    }

    public static int check(int [] A, int k){
        int boards=0,last=-1;
        for(int i=0; i<A.length; i++){
            if(A[i]==1 && last<i){
                boards+=1;
                last=i+k-1;
            }

        }
        return boards;
    }

    public static void main(String[] args) {
        int A[]={1,0,0,1,1,1,0,0,0,0,1};
        int k=4 ;
        System.out.println(boards(A, k));
    }
}

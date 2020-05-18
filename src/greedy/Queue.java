package greedy;

import java.util.Arrays;
import java.util.Random;

public class Queue {

    int [] heap;
    int H, T, N;

    public Queue(int n){
        this.N=n;
        heap=new int[n];
        H=T=-1;
    }

    boolean push(int x){

        if(!isFull() || H==-1){

            if(T==-1)
                H=T=0;

            heap[T]=x;
            T=T+1;

            if(T==N) T=0;
            return true;

        }
        return false;

    }

    boolean pop(){

        if(!isEmpty()){
            heap[H]=0;
            H=H+1;
            System.out.println(H+"  H   ");

        }
        return false;
    }

    boolean isFull(){

        return T==H;
    }

    boolean isEmpty(){
        return T==H &&heap[H]==0;
    }



    public static void main(String[] args) {

        Queue queue =new Queue(10);

        Random random=new Random(47);

        for(int i=0; i<10; i++)
            queue.push(random.nextInt(1001));



        System.out.println(Arrays.toString(queue.heap));
    }

}

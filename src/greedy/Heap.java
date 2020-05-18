package greedy;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;


public class Heap {

    int [] heap;
    int N, n;

    PriorityQueue<Object> priorityQueue;

    public Heap(int n){
        this.N=n;
        heap=new int[n];
        this.n=0;
    }

//    public void heapPush(int v){
//        int i,j;
//        if(n+1>=N) return;
//        i=n++;
//
//        j=(i-1)/2;
//
//        while (i>0 && heap[j]<v){
//
//            heap[i]=heap[j];
//            i=j;
//            j=(i-1)/2;
//        }
//
//        heap[i]=v;
//    }

    public void heap_push(int v)
    {
        int i,j;

        i = n++;
        j = (i - 1) / 2;

        while(i > 0 && heap[j] > v)
        {
            heap[i] = heap[j];
            i = j;
            j = (i - 1) / 2;
        }

        heap[i] = v;
    }



    int  heap_pop()
    {
        int i,j,v, temp;
        temp=heap[0];

        if(n--!=0)
        {
            v = heap[n];


            i = 0;
            j = 1;

            while(j < n)
            {
                if(j + 1 < n && heap[j + 1] < heap[j]) j++;
                if(v <= heap[j]) break;
                heap[i] = heap[j];
                i = j;
                j = 2 * j + 1;
            }

            heap[i] = v;
        }
        return temp;
    }

    public static void main(String[] args) {

        Heap heap=new Heap(7);
        int [] tasks={4,2,151,15,1,52,12};
        double P=0.1;


        for(int i=0; i<tasks.length; i++){
            heap.heap_push(tasks[i]);

        }

        for(int i=0; i<tasks.length; i++){
            tasks[i]=heap.heap_pop();
        }

        System.out.println(Arrays.toString(tasks));

        int waste=0;

        for(int i=0; i<tasks.length; i++){
            waste+=Math.pow((1-P), tasks.length-(i+1))*tasks[i];
        }

        System.out.println(waste);



    }
}

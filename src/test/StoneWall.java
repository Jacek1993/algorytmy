package test;

import java.util.ArrayDeque;
import java.util.Deque;

public class StoneWall {

    public static int solution(int [] A){
        Deque<Integer> stack=new ArrayDeque<>();
        if(A.length <1) return 0;

        int counter=0;

        for(int i=0; i<A.length; i++){

          if(!stack.contains(A[i])) {

              if(!stack.isEmpty() && stack.peek() > A[i]) {
                  while (!stack.isEmpty() && stack.peek() > A[i]) {
                      stack.pop();
                  }
              }
                  stack.push(A[i]);
              counter++;

          }
          else if(stack.peek() > A[i]){
              while(stack.peek()!=A[i]){
                  stack.pop();
              }
          }

        }
        return counter;
    }

    public static void main(String[] args) {
        int [] A={8,7,7,8,9,4,5,8,8};
        int [] B={1};
        System.out.println(solution(A));
        System.out.println(solution(B));
    }
}


/*
You are going to build a stone wall. The wall should be straight and N meters long, and its thickness should be constant; however, it should have different heights in different places. The height of the wall is specified by an array H of N positive integers. H[I] is the height of the wall from I to I+1 meters to the right of its left end. In particular, H[0] is the height of the wall's left end and H[N−1] is the height of the wall's right end.

The wall should be built of cuboid stone blocks (that is, all sides of such blocks are rectangular). Your task is to compute the minimum number of blocks needed to build the wall.

Write a function:

    class Solution { public int DP(int[] H); }

that, given an array H of N positive integers specifying the height of the wall, returns the minimum number of blocks needed to build it.

For example, given array H containing N = 9 integers:
  H[0] = 8    H[1] = 8    H[2] = 5
  H[3] = 7    H[4] = 9    H[5] = 8
  H[6] = 7    H[7] = 4    H[8] = 8

the function should return 7. The figure shows one possible arrangement of seven blocks
 */
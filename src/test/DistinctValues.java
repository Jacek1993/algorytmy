package test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class DistinctValues {

    public static int solution(int [] A){


        Set<Integer> set=new TreeSet<>(Arrays.asList(Arrays.stream(A).boxed().toArray(Integer[]::new)));
        return set.size();
    }

    public static void main(String[] args) {

        int[] A={2,2,1,3,1,1,1};
        System.out.println(solution(A));
    }
}

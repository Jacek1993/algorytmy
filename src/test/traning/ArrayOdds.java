package test.traning;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class ArrayOdds {

    public static int solution(int [] A){

        Map<Integer, Integer> map=new HashMap<>();

        for(int i=0; i<A.length; i++){
            increment(map, A[i]);
        }
        map.entrySet().stream().forEach((e)->{
            System.out.println("k "+e.getKey()+" v "+e.getValue());
        });

        System.out.println(map.entrySet().stream().filter(e->e.getValue()%2!=0).findAny());
        Optional<Map.Entry<Integer, Integer>> o=map.entrySet().stream().filter(e->e.getValue()%2!=0).findAny();
        return o.get().getKey();
    }

    public static void increment(Map<Integer, Integer> map, Integer key){
        if(map.computeIfPresent(key, (k,v)->v+1)==null)
            map.put(key,1);
    }

    public static void main(String[] args) {


        int [] A={9,3,9,3,9,7,9};


        System.out.println( solution(A));
    }
}

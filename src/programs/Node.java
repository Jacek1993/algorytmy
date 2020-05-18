package programs;

public class Node {

    int val;
    Node next;

    public Node(int val){
        this.val=val;
        next=null;
    }

    public String toString(){
        return val+"    ";
    }


    public boolean compareTo(Node o) {

        return val>o.val;


    }
}

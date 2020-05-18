package programs;

import java.util.Random;

public class List {

    Node H = null;

    public void push(int val) {

        if (H == null)
            H = new Node(val);
        else {
            Node tmp = new Node(val);
            tmp.next = H;
            H = tmp;
        }

    }

    public void pushNode(Node node) {

        node.next = H;
        H = node;
    }

    public void purge(){
        while (!isEmpty()){
            pop();
        }
    }

    public Node top() {
        return H;
    }

    public Node pop() {
        if (H == null) throw new ArrayIndexOutOfBoundsException("List is empty");
        else {
            Node tmp = H;
            H = H.next;
            return tmp;
        }

    }

    public boolean isEmpty() {
        return H == null;
    }

    public String toString() {

        StringBuffer sb = new StringBuffer();


        for (Node tmp = H; tmp != null; tmp = tmp.next)
            sb.append(tmp);
        return sb.toString();
    }

    public void merge(List L1, List L2) {


        while (L1.H != null && L2.H != null) {
            if (L1.top().compareTo(L2.top())) {

                this.pushNode(L1.pop());
            } else {
                this.pushNode(L2.pop());
            }
        }
        while (L1.H != null) {
            this.pushNode(L1.pop());
        }

        while (L2.H != null) {
            this.pushNode(L2.pop());
        }


    }

    public void reverse(){
        Node tmp=H;
        while(tmp.next!=null){
            Node tmp1=tmp.next;
            tmp.next=tmp1.next;
            tmp1.next=H;
            H=tmp1;
        }
    }

    public int average(){
        Node tmp=H;
        int number=0, avg=0;
        while(tmp.next!=null){
            number++;
            avg+=tmp.val;
            tmp=tmp.next;
        }
        return avg/number;
    }

    public Node nearestAver(){

        int aver=average();
        Node Min=null, pMin=null;
        Node tmp=H, pTmp=null;
        int min=Integer.MAX_VALUE, tempMin;

        while(tmp.next!=null){

            tempMin=Math.abs(tmp.val-aver);
            if(tempMin < min){
                Min=tmp;
                pMin=pTmp;
                min=tempMin;
            }
            pTmp=tmp;
            tmp=tmp.next;

        }

        if(pMin==null){
            H=H.next;
            return Min;
        }
        pMin.next=Min.next;
        return Min;

    }


    public static void main(String[] args) {
        List list = new List();
        List list1 = new List();
        List list2 = new List();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            list1.push(random.nextInt(100));
            list2.push(random.nextInt(100));
        }
        System.out.println(list1);
        System.out.println(list2);
        list.merge(list1, list2);
        System.out.println(list);

        list.reverse();


        List [] listTab=new List[100];

        for(int i=0; i<100; i++)
            listTab[i]=new List();

        for(int i=0; i<100; i++) {
            for (int j = 0; j < 20; j++) {
                listTab[i].push(random.nextInt(100));
            }
        }

        for(int i=0; i<100; i++)
            System.out.print(listTab[i].average()+"    ");

        list.purge();


        System.out.println("\nNearest Average");
        for(int i=0; i<100; i++)
            list.pushNode(listTab[i].nearestAver());

        System.out.println(list);


    }
}

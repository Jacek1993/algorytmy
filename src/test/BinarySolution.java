package test;

public class BinarySolution {

    public static int solution(int N){
        int sign, counter=0, max=0, reciever=-1, signN=-1;
        boolean coin=false, coin2=false;
        for(int i=31; i>=0; i--) {
            System.out.println((N >> i) & 1);

            sign=(N>>i)&1;
            if(i-1>=0)
            signN=(N>>(i-1) &1);

            if(sign==1){
                coin=true;
                if(coin2) {
                    coin = false;
                    reciever=counter;
                    counter=0;
                    coin2=false;
                    if(signN==0){
                        coin=true;
                    }
                }

            }else{
                if(coin) {
                    counter++;
                    coin2=true;
                }
            }

//            System.out.println(" r "+reciever);

            if(reciever >max) {
                max = reciever;
                reciever=0;
            }


        }

        System.out.println("Max "+max);

        return max;
    }

    public static void main(String[] args) {
        solution(66561);
        solution(6110);
        solution(1162);
    }
}

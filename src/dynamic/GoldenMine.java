package dynamic;

import java.util.Arrays;

public class GoldenMine {

    private int[][] gold;

    int maximum(int m1 , int m2, int m3){
        int max;
        if(m1 >m2)
            max=m1;
        else
            max=m2;
        if(max >m3) return max;
        else return m3;
    }

    int max(int m1, int m2){
        if(m1>m2) return m1;
        else return m2;
    }

     int getMaxGold(int gold [][] , int m , int n){

        int goldTable[][]=new int[m][];

        for(int i=0; i<m ;i++)
            goldTable[i]=new int [n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++)
                goldTable[i][j]=0;
        }

        System.out.println(Arrays.deepToString(goldTable));

        for(int col=n-1; col>=0; col--){

            for(int row=0; row<m; row++){

                int right= (col==n-1)? 0: goldTable[row][col+1];

                int rightDown= (col==n-1 || row==m-1)? 0: goldTable[row+1][col+1];

                int rightTop=(col==n-1 || row==0) ? 0: goldTable[row-1][col+1];

                goldTable[row][col]=gold[row][col]+ maximum(right, rightDown, rightTop);
            }
        }

        int maximum=0;

        for(int i=0; i<m; i++){
            if(maximum < goldTable[i][0]){
                maximum=goldTable[i][0];
            }
        }


        return maximum;
    }

    public static void main(String[] args) {

        int [][] gold={{1,3,1,5},
                {2,2,4,1},
                {5,0,2,3},
                {0,6,1,2}};

        int [][] gold1={{10,33,13,15},
                {22,21,04,1},
                {5,0,2,3},
                {0,6,14,2}};

        int [][] gold2={{1, 100, 199, 34},
                {10, 12, 34, 40},
                {12, 45, 23, 54},
                {200, 1, 1, 1}};

        GoldenMine goldenMine=new GoldenMine();

        System.out.println(goldenMine.getMaxGold(gold, 4, 4));

        System.out.println(goldenMine.getMaxGold(gold1,4,4));

        System.out.println(goldenMine.getMaxGold(gold2,4,4));

    }




}

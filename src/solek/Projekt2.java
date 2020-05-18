package solek;

import java.util.*;

public class Projekt2 {
    private static BaseNode[][] baseNodes = new BaseNode[3][3];

    static {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                baseNodes[i][j] = new BaseNode();
            }
        }

    }

    public static void main(String[] args) {

//        Field [][] fieldArray = new Field[3][3];
//
//        for(int i=0;i<fieldArray.length; i++)
//        {
//            for(int j=0; j<fieldArray.length; j++)
//                fieldArray[i][j] = new Field();
//        }
//
//        fieldArray[0][0].kosztDostawy = 3; fieldArray[0][0].zapewnionyPopyt=20;
//        fieldArray[0][1].kosztDostawy = 5; fieldArray[0][1].zapewnionyPopyt=30;
//        fieldArray[0][2].kosztDostawy = 7; fieldArray[0][2].zapewnionyPopyt=0;
//
//        fieldArray[1][0].kosztDostawy = 12; fieldArray[1][0].zapewnionyPopyt=0;
//        fieldArray[1][1].kosztDostawy = 10; fieldArray[1][1].zapewnionyPopyt=10;
//        fieldArray[1][2].kosztDostawy = 9; fieldArray[1][2].zapewnionyPopyt=60;
//
//        fieldArray[2][0].kosztDostawy = 13; fieldArray[2][0].zapewnionyPopyt=0;
//        fieldArray[2][1].kosztDostawy = 3; fieldArray[2][1].zapewnionyPopyt=0;
//        fieldArray[2][2].kosztDostawy = 9; fieldArray[2][2].zapewnionyPopyt=30;
//
//        int [] alfaArray = new int[3];
//        int [] betaArray = new int[3];
//        countAlfaAndBeta(alfaArray, betaArray , fieldArray);
//        System.out.println(Arrays.toString(alfaArray));
//        System.out.println(Arrays.toString(betaArray));
//
//
//
//
//
//        fieldArray[0][0].kosztDostawy = 2; fieldArray[0][0].zapewnionyPopyt=20;
//        fieldArray[0][1].kosztDostawy = 5; fieldArray[0][1].zapewnionyPopyt=0;
//        fieldArray[0][2].kosztDostawy = 4; fieldArray[0][2].zapewnionyPopyt=0;
//
//        fieldArray[1][0].kosztDostawy = 1; fieldArray[1][0].zapewnionyPopyt=5;
//        fieldArray[1][1].kosztDostawy = 3; fieldArray[1][1].zapewnionyPopyt=25;
//        fieldArray[1][2].kosztDostawy = 6; fieldArray[1][2].zapewnionyPopyt=0;
//
//        fieldArray[2][0].kosztDostawy = 2; fieldArray[2][0].zapewnionyPopyt=0;
//        fieldArray[2][1].kosztDostawy = 2; fieldArray[2][1].zapewnionyPopyt=3;
//        fieldArray[2][2].kosztDostawy = 7; fieldArray[2][2].zapewnionyPopyt=17;
//
//
//        int [] alfaArray1 = new int[3];
//        int [] betaArray1 = new int[3];
//        countAlfaAndBeta(alfaArray1, betaArray1 , fieldArray);
//        System.out.println(Arrays.toString(alfaArray1));
//        System.out.println(Arrays.toString(betaArray1));
//
//        BaseNode [][] baseNodes = new BaseNode[3][3];
//
//        for(int i=0; i<baseNodes.length; i++)
//        {
//            for(int j=0; j<baseNodes[0].length; j++)
//                baseNodes[i][j] = new BaseNode();
//        }
//
//        baseNodes[0][2].value = 3;
//        baseNodes[1][0].value = 4;
//        baseNodes[2][0].value = 5;
//        baseNodes[2][1].value = -7;

//        int[][] solekMatolek = new int[3][3];
//        solekMatolek[0][0] = 0;
//        solekMatolek[0][1] = 1;
//        solekMatolek[0][2] = -5;
//
//        solekMatolek[1][0] = 0;
//        solekMatolek[1][1] = 0;
//        solekMatolek[1][2] = -2;
//
//        solekMatolek[2][0] = 2;
//        solekMatolek[2][1] = 0;
//        solekMatolek[2][2] = 0;

////        createDependencyGraph(solekMatolek);
//        findCircleSolka(solekMatolek);
//        System.out.println(Arrays.deepToString(baseNodes));

        int[][] solekMatolek1 = new int[3][3];

        solekMatolek1[0][0] = 0;
        solekMatolek1[0][1] = 0;
        solekMatolek1[0][2] = 3;

        solekMatolek1[1][0] = 4;
        solekMatolek1[1][1] = 0;
        solekMatolek1[1][2] = 0;

        solekMatolek1[2][0] = 5;
        solekMatolek1[2][1] = -7;
        solekMatolek1[2][2] = 0;

        System.out.println("\n\n");
        findCircleSolka(solekMatolek1);

//        int[][] solekMatolek2 = new int[3][3];
//        solekMatolek2[0][0] = 0;
//        solekMatolek2[0][1] = 0;
//        solekMatolek2[0][2] = -4;
//
//        solekMatolek2[1][0] = 11;
//        solekMatolek2[1][1] = 7;
//        solekMatolek2[1][2] = 0;
//
//        solekMatolek2[2][0] = 12;
//        solekMatolek2[2][1] = 0;
//        solekMatolek2[2][2] = 0;
//
//        System.out.println("\n\n");
//        findCircleSolka(solekMatolek2);
//
//        //this case shouldn't be fulfilled
//        int[][] solekMatolek3 = new int[3][3];
//        solekMatolek3[0][0] = 0;
//        solekMatolek3[0][1] = 1;
//        solekMatolek3[0][2] = 0;
//
//        solekMatolek3[1][0] = 0;
//        solekMatolek3[1][1] = 0;
//        solekMatolek3[1][2] = 3;
//
//        solekMatolek3[2][0] = 2;
//        solekMatolek3[2][1] = 0;
//        solekMatolek3[2][2] = 5;
//        //and it does not fulfilled conditions, there is any negative number
//        System.out.println("\n\n");
//        findCircleSolka(solekMatolek3);

    }

    private static void countAlfaAndBeta(int[] alfaCoefficientArray, int[] betaCoefficientArray, Field[][] arrayField) {
        for (int i = 0; i < alfaCoefficientArray.length; i++) {
            alfaCoefficientArray[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < betaCoefficientArray.length; i++) {
            betaCoefficientArray[i] = Integer.MAX_VALUE;
        }
        alfaCoefficientArray[0] = 0;

        while (alfaArrayIsNotFull(alfaCoefficientArray) || alfaArrayIsNotFull(betaCoefficientArray)) {
            for (int i = 0; i < arrayField.length; i++) {
                for (int j = 0; j < arrayField[0].length; j++) {
                    if (arrayField[i][j].zapewnionyPopyt != 0) {

                        if (alfaCoefficientArray[i] != Integer.MAX_VALUE && betaCoefficientArray[j] == Integer.MAX_VALUE) {
                            betaCoefficientArray[j] = arrayField[i][j].kosztDostawy - alfaCoefficientArray[i];
                        } else if (alfaCoefficientArray[i] == Integer.MAX_VALUE && betaCoefficientArray[j] != Integer.MAX_VALUE) {
                            alfaCoefficientArray[i] = arrayField[i][j].kosztDostawy - betaCoefficientArray[j];
                        }
                    }
                }
            }
        }


    }

    private static int findMin(BaseNode[][] baseNodes) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < baseNodes.length; i++) {
            for (int j = 0; j < baseNodes[0].length; j++) {
                if (baseNodes[i][j].value < min) {
                    min = baseNodes[i][j].value;
                }
            }

        }
        return min;
    }

    private static boolean findCircleSolka(int[][] baseArray) {
        SolekPoint solekPointMiminumCoordinates = createDependencyGraph(baseArray);
        //if we return null that's mean that we finish algorithm there is no any negative values in matrix
        if (solekPointMiminumCoordinates == null) return false;

        Map<Integer, Deque<SolekPoint>> mapList = new HashMap<>();
        Deque<SolekPoint> solekPoints = new ArrayDeque<>();

        solekPoints.addFirst(solekPointMiminumCoordinates);

        BaseNode tmpBaseNode = null;
        SolekPoint tempSolekPoint = null;
        boolean columnOrRown = true;
        int counterCycles = 0;

        while (!solekPoints.isEmpty()) {
            tempSolekPoint = solekPoints.peekFirst();
            tmpBaseNode = baseNodes[tempSolekPoint.x][tempSolekPoint.y];
            if (tmpBaseNode.cNumberOfX.peekFirst() == null || tmpBaseNode.rNumberOfX.peekFirst() == null) {
                solekPoints.pollFirst();
                columnOrRown = !columnOrRown;
                continue;
            }

            if (columnOrRown) {
                solekPoints.addFirst(tmpBaseNode.cNumberOfX.pollFirst());
                columnOrRown = !columnOrRown;
            } else if (!columnOrRown) {
                solekPoints.addFirst(tmpBaseNode.rNumberOfX.pollFirst());
                columnOrRown = !columnOrRown;
            }

            if (solekPoints.peekFirst().equals(solekPointMiminumCoordinates)) {
                solekPoints.pollFirst();
                mapList.put(counterCycles, solekPoints);
                counterCycles++;
                break;
            }

        }

        Deque<SolekPoint> solekPointDeque = getShortestSolekPointList(mapList);
        SolekPoint solekPointTemp = null;
        //true means positive value
        int signOfCell = 1;

        while (!solekPointDeque.isEmpty()) {
            solekPointTemp = solekPointDeque.pollLast();
            baseNodes[solekPointTemp.x][solekPointTemp.y].becameToMainArray = signOfCell;
            signOfCell = signOfCell ==1 ? 0: 1;
        }

        System.out.println(Arrays.deepToString(baseNodes));
        return true;
    }

    private static Deque<SolekPoint> getShortestSolekPointList(Map<Integer, Deque<SolekPoint>> map) {
        int minLengthOfSolekPoints = Integer.MAX_VALUE;
        int keyInMap = 0;

        for (Map.Entry<Integer, Deque<SolekPoint>> mapItem : map.entrySet()) {
            if (minLengthOfSolekPoints > mapItem.getValue().size()) {
                minLengthOfSolekPoints = mapItem.getValue().size();
                keyInMap = mapItem.getKey();
            }
        }

        return map.get(keyInMap);
    }

    private static SolekPoint minimumSolka(int[][] xArray) {
        int indexi = -1;
        int indexj = -1;
        int minimalnaWartosc = xArray[0][0];

        for (int i = 0; i < xArray.length; i++) {
            for (int j = 0; j < xArray[0].length; j++) //może j<fieldArray.GetLength(1)
            {
                //szukamy początku cyklu
                if (xArray[i][j] < 0 && indexi == -1 && indexj == -1) {
                    indexi = i;
                    indexj = j;
                }

                if (xArray[i][j] < minimalnaWartosc)
                    minimalnaWartosc = xArray[i][j];
            }
        }

        return new SolekPoint(indexi, indexj);
    }


    private static SolekPoint createDependencyGraph(int[][] baseRule) {
        SolekPoint minimumCoordinates = null;
        SolekPoint minimumSolekCoordinates = minimumSolka(baseRule);

        if (minimumSolekCoordinates.x < 0 || minimumSolekCoordinates.y < 0) {
            return null;
        }

        int minimumSolek = baseRule[minimumSolekCoordinates.x][minimumSolekCoordinates.y];

        for (int i = 0; i < baseRule.length; i++) {
            for (int j = 0; j < baseRule[0].length; j++) {
                if (baseRule[i][j] == 0 || baseRule[i][j] == minimumSolek) {
                    for (int k = 0; k < baseRule.length; k++) {
                        if ((i != k && baseRule[k][j] == 0) || (i != k && baseRule[k][j] == minimumSolek)) {
                            baseNodes[i][j].cNumberOfX.addFirst(new SolekPoint(k, j));

                        }
                    }

                    for (int k = 0; k < baseRule[0].length; k++) {
                        if ((j != k && baseRule[i][k] == 0) || (j != k && baseRule[i][k] == minimumSolek)) {
                            baseNodes[i][j].rNumberOfX.addFirst(new SolekPoint(i, k));
                        }
                    }
                    baseNodes[i][j].value = baseRule[i][j];
                }
            }
        }

        return minimumSolekCoordinates;
    }

    private static boolean alfaArrayIsNotFull(int[] alfaArray) {
        for (int i = 0; i < alfaArray.length; i++) {
            if (alfaArray[i] == Integer.MAX_VALUE)
                return true;
        }
        return false;
    }

    public static class Field {
        public int kosztDostawy;
        public int zapewnionyPopyt;

        public Field() {
            kosztDostawy = 0;
            zapewnionyPopyt = 0;
        }
    }

    public class NodeField {
        public int value;
        public boolean isBaseNode;

        public NodeField() {
            value = 0;
            isBaseNode = true;
        }
    }

    public static class BaseNode {
        public int value;
        public Deque<SolekPoint> rNumberOfX;
        public Deque<SolekPoint> cNumberOfX;
        public int becameToMainArray;

        BaseNode() {
            value = Integer.MAX_VALUE;
            rNumberOfX = new ArrayDeque<>();
            cNumberOfX = new ArrayDeque<>();
            becameToMainArray = -1;
        }

        @Override
        public String toString() {
            return "BaseNode{" +
                    "value=" + value +
                    ", rNumberOfX=" + rNumberOfX +
                    ", cNumberOfX=" + cNumberOfX +
                    ", sign=" + becameToMainArray +
                    "}\n";
        }
    }

    public static class SolekPoint {
        public int x;
        public int y;

        SolekPoint(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            SolekPoint that = (SolekPoint) o;
            return x == that.x &&
                    y == that.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "SolekPoint{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
package org.zhouhy.structure.algorithms.sparesearray.demo01;


import com.sun.istack.internal.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class SparseArray {

    private static final Logger LOGGER = LoggerFactory.getLogger(SparseArray.class);

    public static void main(String[] args) {
        int[][] chessArray = initOriginalArray();
        printArray(chessArray);
        LOGGER.info("***************************************************");
        int[][] sparseArray = createSparseArray(chessArray);
        if (sparseArray != null) {
            printArray(sparseArray);
            int[][] array = restoreArrayFromSparseArray(sparseArray);
            LOGGER.info("***************************************************");
            printArray(array);
        }
    }

    public static int[][] initOriginalArray() {
        int[][] chessArray = new int[19][19];
        chessArray[1][2] = 1;
        chessArray[2][3] = 2;
        chessArray[4][5] = 2;
        return chessArray;
    }

    public static void printArray(int[][] array) {
        for (int[] row : array) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }

    public static int[][] createSparseArray(int[][] array) {
        List<int[]> arrayItems = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] != 0) {
                    int[] item = new int[3];
                    item[0] = i;
                    item[1] = j;
                    item[2] = array[i][j];
                    arrayItems.add(item);
                }
            }
        }

        if (arrayItems.size() > 0) {
            int[][] sparseArray = new int[arrayItems.size() + 1][3];
            sparseArray[0][0] = array.length;
            sparseArray[0][1] = array[0].length;
            sparseArray[0][2] = arrayItems.size();
            int index = 1;
            for (int[] item : arrayItems) {
                sparseArray[index][0] = item[0];
                sparseArray[index][1] = item[1];
                sparseArray[index][2] = item[2];
                index++;
            }
            return sparseArray;
        }
        return null;
    }

    public static int[][] restoreArrayFromSparseArray(@NotNull int[][] sparseArray) {
        int[][] array = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {
            array[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        return array;
    }
}

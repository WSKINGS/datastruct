package com.ws.sort;

import com.ws.Main;

import java.util.Random;

/**
 * Created by Administrator on 2015/9/12 0012.
 */
public class TestSort {
    private static final int caseNum = 20;
    private static final int sampleNum = 20;

    static Sorter sorter = new InsertSort();

    public static void main( String[] args ) {
        for (int i=0; i<caseNum; i++) {
            int[] sequence = generateRandomSequence(sampleNum,0,100);
            sorter.sort(sequence);
            testSequence(sequence);
        }
    }

    private static void testSequence(int[] sequence) {
        if (sequence == null) {
            return;
        }
        for (int i=1; i<sequence.length; i++) {
            if (sequence[i] < sequence[i-1]) {
                System.out.println("sequence not in order");
                for (int temp : sequence) {
                    System.out.print(temp+" ");
                }
                System.out.println();
                break;
            }
        }
    }

    private static int[] generateRandomSequence(int size, int min, int max) {
        int absMin = Math.abs(min);
        int range = absMin+Math.abs(max)+1;
        Random random = new Random();
        int[] result = new int[size];
        for (int i=0; i<size; i++) {
            int num = random.nextInt(range);
            result[i] = num-absMin;
        }
        return result;
    }
}

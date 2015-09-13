package com.ws.sort;

/**
 * Created by Administrator on 2015/9/12 0012.
 */
public class InsertSort implements Sorter {

    public int[] commonInsertSort(int[] origin) {
        for (int i=1;i<origin.length;i++) {
            int j = i-1;
            for ( ;j>=0;j--) {
                if (compare(origin[i],origin[j]) >= 0){
                    insert(origin,j+1,i);
                    break;
                }
            }
            if (j == -1) {
                insert(origin,0,i);
            }
        }
        return origin;
    }

    public int[] binaryInsertSort(int[] origin){
        for (int i=1;i<origin.length;i++){
            int index = binarySearch(origin,0,i-1,origin[i]);
            if (index == -1){
                return null;
            }
            insert(origin,index,i);
        }
        return origin;
    }

    private int binarySearch(int[] origin, int start, int end, int elem) {
        if (origin == null || start>end || start>origin.length){
            return -1;
        }
        while (start<=end) {
            int media = (start+end)/2;
            if (origin[media]>elem) {
                end = media-1;
            }
            else if (origin[media]<elem){
                start = media+1;
            }
            else {
                return media+1;
            }
        }
        return start;
    }

    private void insert(int[] origin, int position, int originPosition) {
        if (origin == null || position>= originPosition || originPosition>=origin.length) {
            return;
        }
        int temp = origin[originPosition];
        for (int i=originPosition-1; i>=position; i--) {
            origin[i+1] = origin[i];
        }
        origin[position] = temp;
        return;
    }

    private int compare(int num1, int num2) {
        return num1-num2;
    }

    @Override
    public int[] sort(int[] sequence) {
        return binaryInsertSort(sequence);
        //return commonInsertSort(sequence);
    }
}

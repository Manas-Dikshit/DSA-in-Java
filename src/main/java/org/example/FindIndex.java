package org.example;

import java.util.ArrayList;

public class FindIndex {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 4, 5, 5};
        System.out.println(findAllIndex(arr,4,0));
    }
    static ArrayList<Integer> findAllIndex(int[] arr, int target, int index){
        ArrayList<Integer> list = new ArrayList<>();

        if(index == arr.length){
            return list;
        }
        if(arr[index] == target){
            list.add(index);
        }
        ArrayList<Integer> ansFromBelowCalls = findAllIndex(arr, target, index+1);
        list.addAll(ansFromBelowCalls);
        return list;
    }
}

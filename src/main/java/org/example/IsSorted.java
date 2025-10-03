package org.example;

public class IsSorted {
    public static void main(String[] args) {
        int[] MRD = {10,20,30,40,50,60,70,80,90,100};
        System.out.println(sort(MRD,0));
    }
    static boolean sort(int[] arr, int index){
        if(index == arr.length-1){
            return true;
        }
        return arr[index]<arr[index+1] && sort(arr, index+1);
    }
}

package org.example;

public class CountStepsToGetZero {
    public static void main(String[] args) {
        System.out.println(countSteps(34));
    }
    // rule is if the number is even then divide by 2 and count it as one step
    // if the number is odd then number-1 and count it as step one
    // do it continuously until you get zero
    static int countSteps(int n){
        return helper(n,0);
    }
    private static int helper(int n, int steps){
        if(n==0){
            return steps;
        }
        if(n%2 == 0){
            return helper(n/2, steps+1);
        }
        return helper(n-1, steps+1);
    }
}

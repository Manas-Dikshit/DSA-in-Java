package org.example.Stack;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class InBuiltExamples {
    public static void main(String[] args) {
        Stack<Integer> example = new Stack<>();
        example.push(12);
        example.push(234);
        System.out.println(example);
        example.pop();
        System.out.println(example);
        System.out.println(example.peek());

        Queue<Integer> ex2 = new LinkedList<>();
        ex2.add(12);
        ex2.add(556);
        ex2.add(234);
        ex2.add(34);
        System.out.println(ex2.remove());
        System.out.println(ex2.remove());
    }
}

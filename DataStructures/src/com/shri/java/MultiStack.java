//Q6:Implements multistack solution for a fixed sized stack beyond which it should create a new stack.
package com.shri.java;

import java.util.EmptyStackException;

public class MultiStack {
    private int[] stackArray;   
    private int[] stackTop;     
    private int stackCapacity;  
    private int numberOfStacks;
    private int[] stackStart;   
 
    public MultiStack(int totalSize, int stackCapacity) {
        this.stackArray = new int[totalSize];
        this.stackTop = new int[totalSize / stackCapacity];
        this.stackStart = new int[stackTop.length];
        this.stackCapacity = stackCapacity;
        this.numberOfStacks = stackTop.length;
 
        for (int i = 0; i < numberOfStacks; i++) {
            stackStart[i] = i * stackCapacity;
            stackTop[i] = stackStart[i] - 1;
        }
    }
 
    public void push(int stackIndex, int value) {
        if (stackIndex < 0 || stackIndex >= numberOfStacks) {
            throw new IllegalArgumentException("Invalid stack index");
        }
        int start = stackStart[stackIndex];
        int top = stackTop[stackIndex];
        if (top >= start + stackCapacity - 1) {
            throw new StackOverflowError("Stack " + stackIndex + " is full");
        }
        stackTop[stackIndex]++;
        stackArray[stackTop[stackIndex]] = value;
    }
 
    public int pop(int stackIndex) {
        if (stackIndex < 0 || stackIndex >= numberOfStacks) {
            throw new IllegalArgumentException("Invalid stack index");
        }
        int start = stackStart[stackIndex];
        int top = stackTop[stackIndex];
        if (top < start) {
            throw new EmptyStackException();
        }
        int value = stackArray[top];
        stackTop[stackIndex]--;
        return value;
    }
 
    public int peek(int stackIndex) {
        if (stackIndex < 0 || stackIndex >= numberOfStacks) {
            throw new IllegalArgumentException("Invalid stack index");
        }
        int start = stackStart[stackIndex];
        int top = stackTop[stackIndex];
        if (top < start) {
            throw new EmptyStackException();
        }
        return stackArray[top];
    }
 
    public boolean isEmpty(int stackIndex) {
        if (stackIndex < 0 || stackIndex >= numberOfStacks) {
            throw new IllegalArgumentException("Invalid stack index");
        }
        int start = stackStart[stackIndex];
        return stackTop[stackIndex] < start;
    }
 
    public void printStacks() {
        for (int i = 0; i < numberOfStacks; i++) {
            System.out.print("Stack " + i + ": ");
            int start = stackStart[i];
            for (int j = start; j <= stackTop[i]; j++) {
                System.out.print(stackArray[j] + " ");
            }
            System.out.println();
        }
    }
 
    public static void main(String[] args) {
        int totalSize = 30;
        int stackCapacity = 10;
        MultiStack multiStack = new MultiStack(totalSize, stackCapacity);
 
        multiStack.push(0, 1);
        multiStack.push(0, 2);
        multiStack.push(1, 10);
        multiStack.push(1, 20);
 
        multiStack.printStacks();
 
        System.out.println("Pop from stack 0: " + multiStack.pop(0));
        System.out.println("Pop from stack 1: " + multiStack.pop(1));
 
        multiStack.printStacks();
 
        System.out.println("Peek at stack 0: " + multiStack.peek(0));
        System.out.println("Peek at stack 1: " + multiStack.peek(1));
    }
}
 


package it.lovejazz.calculator;

public interface Stack {
    void push(float value);

    float pop() throws StackException;

    boolean isEmpty();

    int getLength();

}

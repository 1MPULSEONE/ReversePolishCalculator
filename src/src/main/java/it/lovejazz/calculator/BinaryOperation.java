package it.lovejazz.calculator;

public interface BinaryOperation extends Operation {
    float apply(float left, float right);

    String getName();
}

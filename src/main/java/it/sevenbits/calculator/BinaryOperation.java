package it.sevenbits.calculator;

public interface BinaryOperation extends Operation {
    float apply(float left, float right);

    String getName();
}

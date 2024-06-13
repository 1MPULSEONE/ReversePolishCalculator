package it.lovejazz.calculator.operations;

import it.lovejazz.calculator.BinaryOperation;
import it.lovejazz.calculator.Operation;

public class AddOperation implements BinaryOperation {
    @Override
    public float apply(final float left, final float right) {
        return left + right;
    }

    @Override
    public String getName() {
        return "+";
    }
}

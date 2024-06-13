package it.lovejazz.calculator.operations;

import it.lovejazz.calculator.BinaryOperation;

public class DivOperation implements BinaryOperation {
    @Override
    public float apply(final float left, final float right) {
        return right / left;
    }

    @Override
    public String getName() {
        return "/";
    }
}

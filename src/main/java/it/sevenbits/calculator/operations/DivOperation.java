package it.sevenbits.calculator.operations;
import it.sevenbits.calculator.BinaryOperation;

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

package it.sevenbits.calculator.operations;
import it.sevenbits.calculator.BinaryOperation;
public class MulOperation implements BinaryOperation {
    @Override
    public float apply(final float left, final float right) {
        return left * right;
    }

    @Override
    public String getName() {
        return "*";
    }
}

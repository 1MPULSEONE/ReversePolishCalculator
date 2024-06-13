package it.lovejazz.calculator.operations;

import it.lovejazz.calculator.*;

import java.util.ArrayList;

public class SumOperation implements NaryOperation {

    @Override
    public float apply(ArrayList<Float> numbers) {
        float sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            float element = numbers.get(i);
            sum += element;
        }
        return sum;
    }

    @Override
    public String getName() {
        return "sum";
    }
}

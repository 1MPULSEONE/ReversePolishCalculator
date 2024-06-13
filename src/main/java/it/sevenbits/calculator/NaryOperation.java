package it.sevenbits.calculator;

import java.util.ArrayList;

public interface NaryOperation extends Operation {
    float apply(ArrayList<Float> numbers);

    String getName();
}

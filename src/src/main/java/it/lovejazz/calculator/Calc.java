package it.lovejazz.calculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class Calc {
    private final Map<String, Operation> operations;
    private final Tokenizer tokenizer;
    private final Supplier<Stack> stackBuilder;

    public Calc(
            final Tokenizer tokenizer,
            final Supplier<Stack> stackBuilder,
            final OperationsLoader loader
    ) {
        this.tokenizer = tokenizer;
        this.stackBuilder = stackBuilder;
        this.operations = new HashMap<>();
        for (final Operation op : loader.load()) {
            operations.put(op.getName(), op);
        }
    }

    public float eval(String expression) throws CalcException {
        List<String> tokens = tokenizer.tokenize(expression);
        Stack numbers = stackBuilder.get();
        for (String token : tokens) {
            if (isNumber(token)) {
                numbers.push(Float.parseFloat(token));
            } else {
                try {
                    Operation operation = operations.get(token);
                    if (operation == null)
                        throw new CalcException(String.format("Cannot eval expression '%s', unknown operation: '%s'", expression, token));
                    if (operation instanceof BinaryOperation) {
                        BinaryOperation binaryOperation = (BinaryOperation) operation;
                        numbers.push(binaryOperation.apply(numbers.pop(), numbers.pop()));
                    } else {
                        NaryOperation naryOperation = (NaryOperation) operation;
                        ArrayList<Float> operands = new ArrayList<>();
                        while (!numbers.isEmpty()) {
                            operands.add(numbers.pop());
                        }
                        numbers.push(naryOperation.apply(operands));
                    }
                } catch (StackException e) {
                    throw new CalcException("Can't eval expression: " + expression, e);
                }
            }
        }

        try {
            if (numbers.isEmpty()) return 0f;
            return numbers.pop();
        } catch (StackException e) {
            throw new CalcException("Can't get calculation result", e);
        }
    }

    private boolean isNumber(String s) {
        try {
            Float.parseFloat(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

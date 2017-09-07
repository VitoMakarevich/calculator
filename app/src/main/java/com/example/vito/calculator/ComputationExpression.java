package com.example.vito.calculator;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class ComputationExpression {
    private String computationString;

    public ComputationExpression() {
        super();
        computationString = "";
    }

    public String add(String text, int position) {
        if (isComputeable()) {
            //todo add adding logic check
            computationString = new StringBuilder(computationString).insert(position, text).toString();
        }
        return computationString;
    }

    public void clear() {
        computationString = "";
    }

    public String computate() {
        //todo add computation logic, use for this library which parses string and gets int
        Double result;
        try {
            Expression e = new ExpressionBuilder(computationString).build();
            result = e.evaluate();
        } catch (Exception e) {
            throw e;
        }
        return String.valueOf(result);
    }

    public String delete() {
        //todo add deletion logic
        if (computationString.length() > 0) {
            computationString = computationString.substring(0, computationString.length() - 1);
            return computationString;
        } else {
            return computationString;
        }
    }

    public String getComputationString() {
        return computationString;
    }

    private boolean isComputeable() {
        //todo add preComputation logic check
        return true;
    }
}

package com.example.vito.calculator;

public class ComputationExpression {
    private String computationString;

    public ComputationExpression() {
        super();
        computationString = "";
    }

    public String add(String text) {
        if (isComputeable()) {
            //todo add adding logic check
            computationString += text;
        }
        return computationString;
    }

    public void clear() {
        computationString = "";
    }

    public String computate() {
        //todo add computation logic, use for this library which parses string and gets int
        return computationString;
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

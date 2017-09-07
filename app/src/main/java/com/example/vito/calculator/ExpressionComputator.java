package com.example.vito.calculator;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class ExpressionComputator {
    private String expression;

    public ExpressionComputator(String expression) {
        this.expression = expression;
    }

    public String add(String operand, int position) {
        expression = new StringBuilder(expression).insert(position, operand).toString();
        return expression;
    }

    public String delete(int position) {
        expression = new StringBuilder(expression).delete(position - 1, position).toString();
        return expression;
    }

    public String computate() {
        Double result;
        try {
            Expression e = new ExpressionBuilder(expression).build();
            result = e.evaluate();
        } catch (Exception e) {
            throw e;
        }
        return String.valueOf(result);
    }

    public String getExpression() {
        return expression;
    }

    public void clear() {
        expression = "";
    }
}

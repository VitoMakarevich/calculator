package com.example.vito.calculator;

import android.widget.EditText;

public class ViewPrinter {
    private EditText computationView;
    private ExpressionComputator expressionComputator;
    private int cursorPosition;

    public ViewPrinter(EditText computationView) {
        this.computationView = computationView;
        initialiseComputation();
    }

    private void initialiseComputation() {
        expressionComputator = new ExpressionComputator(computationView.getText().toString());
        cursorPosition = computationView.getText().toString().length();
    }

    public String computate() {
        String result;
        try {
            result = expressionComputator.computate();
        } catch (Exception e) {
            initialiseComputation();
            throw e;
        }
        return result;
    }

    public void delete() {
        cursorPosition = getCursorPosition();
        if (cursorPosition > 0) {
            expressionComputator.delete(cursorPosition);
            cursorPosition -= 1;
            print();
        }

    }

    private int getCursorPosition() {
        return computationView.getSelectionStart();
    }

    private void setCursorPosition(int position) {
        computationView.setSelection(position);
    }

    public void add(String input) {
        cursorPosition = getCursorPosition();
        if (input.matches("[a-z]+\\(")) {
            expressionComputator.add(input + ")", cursorPosition);
        } else {
            expressionComputator.add(input, cursorPosition);
        }
        cursorPosition += input.length();
        print();
    }

    private void print() {
        computationView.setText(expressionComputator.getExpression());
        setCursorPosition(cursorPosition);
    }

    public void clear() {
        expressionComputator.clear();
        computationView.setText(expressionComputator.getExpression());
    }
}

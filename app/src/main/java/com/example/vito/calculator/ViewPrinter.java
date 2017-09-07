package com.example.vito.calculator;

import android.widget.EditText;
import android.widget.TextView;

public class ViewPrinter<T extends TextView> {
    private T computationTextView;
    private int cursorPosition;

    public ViewPrinter(T computationTextView) {
        this.computationTextView = computationTextView;
        cursorPosition = 0;
    }

    public void print(String computationExpression, int cursorPosition) {
        clear();
        computationTextView.setText(computationExpression);
        if (computationTextView instanceof EditText)
            setCursorPosition(cursorPosition);
    }

    public void print(String computationExpression) {
        clear();
        computationTextView.setText(computationExpression);
    }

    public void clear() {
        computationTextView.setText("");
    }

    public int getCursorPosition() {
        return computationTextView.getSelectionStart();
    }

    private void setCursorPosition(int position) {
        ((EditText) computationTextView).setSelection(position);
    }
}

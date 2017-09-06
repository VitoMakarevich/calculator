package com.example.vito.calculator;

import android.widget.TextView;

public class ViewPrinter {
    private TextView computationTextView;

    public ViewPrinter(TextView computationTextView) {
        this.computationTextView = computationTextView;
    }

    public void print(String computationExpression) {
        clear();
        computationTextView.append(computationExpression);
    }

    public void clear() {
        computationTextView.setText("");
    }
}

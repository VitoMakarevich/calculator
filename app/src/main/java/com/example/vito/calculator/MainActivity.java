package com.example.vito.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonZero = (Button) findViewById(R.id.zero_button);
        Button buttonOne = (Button) findViewById(R.id.one_button);
        Button buttonTwo = (Button) findViewById(R.id.two_button);
        Button buttonThree = (Button) findViewById(R.id.three_button);
        Button buttonFour = (Button) findViewById(R.id.four_button);
        Button buttonFive = (Button) findViewById(R.id.five_button);
        Button buttonSix = (Button) findViewById(R.id.six_button);
        Button buttonSeven = (Button) findViewById(R.id.seven_button);
        Button buttonEight = (Button) findViewById(R.id.eight_button);
        Button buttonNine = (Button) findViewById(R.id.nine_button);
        Button buttonPlus = (Button) findViewById(R.id.plus_button);
        Button buttonMinus = (Button) findViewById(R.id.minus_button);
        Button buttonDivide = (Button) findViewById(R.id.divide_button);
        Button buttonMultiply = (Button) findViewById(R.id.multiply_button);
        Button buttonDot = (Button) findViewById(R.id.dot_button);
        Button buttonComputate = (Button) findViewById(R.id.computate_button);
        Button buttonBackspace = (Button) findViewById(R.id.backspace_button);
        Button buttonClear = (Button) findViewById(R.id.clear_button);
        Button buttonOpenBracket = (Button) findViewById(R.id.open_bracket_button);
        Button buttonCloseBracket = (Button) findViewById(R.id.close_bracket_button);
        Button buttonBackward = (Button) findViewById(R.id.backward_button);
        Button buttonSinus = (Button) findViewById(R.id.sinus_button);
        Button buttonCosinus = (Button) findViewById(R.id.cosinus_button);
        Button buttonTangens = (Button) findViewById(R.id.tangens_button);
        Button buttonFactorial = (Button) findViewById(R.id.factorial_button);
        Button buttonAcosinus = (Button) findViewById(R.id.acosinus_button);
        Button buttonAsinus = (Button) findViewById(R.id.asinus_button);
        Button buttonAtangens = (Button) findViewById(R.id.atangens_button);


        final TextView computationTextView = (TextView) findViewById(R.id.computation_text_view);
        TextView resultTextView = (TextView) findViewById(R.id.result_text_view);

        final ViewPrinter resultViewPrinter = new ViewPrinter(resultTextView);
        final ViewPrinter computationViewPrinter = new ViewPrinter(computationTextView);

        final ComputationExpression computationExpression = new ComputationExpression();

        buttonZero.setOnClickListener(getSimpleOnClickListener("0", computationExpression, computationViewPrinter));
        buttonOne.setOnClickListener(getSimpleOnClickListener("1", computationExpression, computationViewPrinter));
        buttonTwo.setOnClickListener(getSimpleOnClickListener("2", computationExpression, computationViewPrinter));
        buttonThree.setOnClickListener(getSimpleOnClickListener("3", computationExpression, computationViewPrinter));
        buttonFour.setOnClickListener(getSimpleOnClickListener("4", computationExpression, computationViewPrinter));
        buttonFive.setOnClickListener(getSimpleOnClickListener("5", computationExpression, computationViewPrinter));
        buttonSix.setOnClickListener(getSimpleOnClickListener("6", computationExpression, computationViewPrinter));
        buttonSeven.setOnClickListener(getSimpleOnClickListener("7", computationExpression, computationViewPrinter));
        buttonEight.setOnClickListener(getSimpleOnClickListener("8", computationExpression, computationViewPrinter));
        buttonNine.setOnClickListener(getSimpleOnClickListener("9", computationExpression, computationViewPrinter));
        buttonDot.setOnClickListener(getSimpleOnClickListener(".", computationExpression, computationViewPrinter));
        buttonPlus.setOnClickListener(getSimpleOnClickListener("+", computationExpression, computationViewPrinter));
        buttonMinus.setOnClickListener(getSimpleOnClickListener("-", computationExpression, computationViewPrinter));
        buttonDivide.setOnClickListener(getSimpleOnClickListener("/", computationExpression, computationViewPrinter));
        buttonMultiply.setOnClickListener(getSimpleOnClickListener("*", computationExpression, computationViewPrinter));
        buttonOpenBracket.setOnClickListener(getSimpleOnClickListener("(", computationExpression, computationViewPrinter));
        buttonCloseBracket.setOnClickListener(getSimpleOnClickListener(")", computationExpression, computationViewPrinter));
        buttonBackward.setOnClickListener(getSimpleOnClickListener("1/", computationExpression, computationViewPrinter));
        buttonSinus.setOnClickListener(getSimpleOnClickListener("sin(", computationExpression, computationViewPrinter));
        buttonCosinus.setOnClickListener(getSimpleOnClickListener("cos(", computationExpression, computationViewPrinter));
        buttonTangens.setOnClickListener(getSimpleOnClickListener("tan(", computationExpression, computationViewPrinter));
        buttonFactorial.setOnClickListener(getSimpleOnClickListener("!", computationExpression, computationViewPrinter));
        buttonAcosinus.setOnClickListener(getSimpleOnClickListener("acos(", computationExpression, computationViewPrinter));
        buttonAsinus.setOnClickListener(getSimpleOnClickListener("asin(", computationExpression, computationViewPrinter));
        buttonAtangens.setOnClickListener(getSimpleOnClickListener("atan(", computationExpression, computationViewPrinter));

        buttonBackspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String computationString = computationExpression.delete();
                computationViewPrinter.print(computationString);
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computationExpression.clear();
                computationViewPrinter.clear();
            }
        });

        buttonComputate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = computationExpression.computate();
                computationViewPrinter.clear();
                computationExpression.clear();
                resultViewPrinter.print(result);
            }
        });
    }

    //here is factory method
    private View.OnClickListener getSimpleOnClickListener(final String text, final ComputationExpression expression, final ViewPrinter viewPrinter) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String computationString = expression.add(text);
                viewPrinter.print(computationString);
            }
        };
    }
}

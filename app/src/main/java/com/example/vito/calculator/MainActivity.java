package com.example.vito.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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


        final EditText computationEditText = (EditText) findViewById(R.id.computation_edit_text);
        computationEditText.setShowSoftInputOnFocus(false);
        final TextView resultTextView = (TextView) findViewById(R.id.result_text_view);

        final ViewPrinter computationViewPrinter = new ViewPrinter(computationEditText);

        buttonZero.setOnClickListener(getSimpleOnClickListener("0", computationViewPrinter));
        buttonOne.setOnClickListener(getSimpleOnClickListener("1", computationViewPrinter));
        buttonTwo.setOnClickListener(getSimpleOnClickListener("2", computationViewPrinter));
        buttonThree.setOnClickListener(getSimpleOnClickListener("3", computationViewPrinter));
        buttonFour.setOnClickListener(getSimpleOnClickListener("4", computationViewPrinter));
        buttonFive.setOnClickListener(getSimpleOnClickListener("5", computationViewPrinter));
        buttonSix.setOnClickListener(getSimpleOnClickListener("6", computationViewPrinter));
        buttonSeven.setOnClickListener(getSimpleOnClickListener("7", computationViewPrinter));
        buttonEight.setOnClickListener(getSimpleOnClickListener("8", computationViewPrinter));
        buttonNine.setOnClickListener(getSimpleOnClickListener("9", computationViewPrinter));
        buttonDot.setOnClickListener(getSimpleOnClickListener(".", computationViewPrinter));
        buttonPlus.setOnClickListener(getSimpleOnClickListener("+", computationViewPrinter));
        buttonMinus.setOnClickListener(getSimpleOnClickListener("-", computationViewPrinter));
        buttonDivide.setOnClickListener(getSimpleOnClickListener("/", computationViewPrinter));
        buttonMultiply.setOnClickListener(getSimpleOnClickListener("*", computationViewPrinter));
        buttonOpenBracket.setOnClickListener(getSimpleOnClickListener("(", computationViewPrinter));
        buttonCloseBracket.setOnClickListener(getSimpleOnClickListener(")", computationViewPrinter));
        buttonBackward.setOnClickListener(getSimpleOnClickListener("1/", computationViewPrinter));
        buttonSinus.setOnClickListener(getSimpleOnClickListener("sin(", computationViewPrinter));
        buttonCosinus.setOnClickListener(getSimpleOnClickListener("cos(", computationViewPrinter));
        buttonTangens.setOnClickListener(getSimpleOnClickListener("tan(", computationViewPrinter));
        buttonFactorial.setOnClickListener(getSimpleOnClickListener("!", computationViewPrinter));
        buttonAcosinus.setOnClickListener(getSimpleOnClickListener("acos(", computationViewPrinter));
        buttonAsinus.setOnClickListener(getSimpleOnClickListener("asin(", computationViewPrinter));
        buttonAtangens.setOnClickListener(getSimpleOnClickListener("atan(", computationViewPrinter));

        buttonBackspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computationViewPrinter.delete();
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computationViewPrinter.clear();
            }
        });

        buttonComputate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = null;
                try {
                    result = computationViewPrinter.computate();
                } catch (Exception e) {
                    resultTextView.setText(getString(R.string.invalid_expression_error));
                }
                if (result != null) {
                    resultTextView.setText(result);
                }
            }
        });
    }

    //here is factory method
    private View.OnClickListener getSimpleOnClickListener(final String text, final ViewPrinter viewPrinter) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPrinter.add(text);
            }
        };
    }
}


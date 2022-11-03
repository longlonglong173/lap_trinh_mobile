package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView resultView;
    String oldResultTextView = "";
    String oldOperatorView = "";
    boolean isGetResult = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultView = findViewById(R.id.result);
    }

    public void clickToNumber(View view) {
        isGetResult = false;
        final Button button = findViewById(view.getId());
        final String buttonValue = button.getText().toString();
        final String oldTextResult = resultView.getText().toString();
        String newTextResult = "";
        if (oldTextResult.equals("0") || !isNumeric(oldTextResult)) {
            newTextResult = buttonValue;
        } else {
            newTextResult = oldTextResult + buttonValue;
        }
        resultView.setText(newTextResult);
    }

    public void clearAll(View view) {
        resultView.setText("0");
        oldOperatorView = "";
        oldResultTextView = "";
        isGetResult = false;
    }

    public void clearLastChar(View view) {
        isGetResult = false;
        String oldRes = resultView.getText().toString();
        if (oldRes.length() == 1) {
            resultView.setText("0");
            return;
        }
        resultView.setText(oldRes.substring(0, oldRes.length() - 1));
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble((strNum));
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public void handleOperator(View view) {
        final Button button = findViewById(view.getId());
        final String buttonText = button.getText().toString();
        final String oldResultText = resultView.getText().toString();
        if (isNumeric(oldResultText)) {
            if (oldResultTextView.equals("=")) {
                return;
            }
            if (!isGetResult) {
                if (buttonText.equals("=")) {
                    String res = "";
                    Double a = Double.parseDouble(oldResultTextView);
                    Double b = Double.parseDouble(oldResultText);
                    switch (oldOperatorView) {
                        case "/":
                            res = String.valueOf(a / b);
                            break;
                        case "X":
                            res = String.valueOf(a * b);
                            break;
                        case "-":
                            res = String.valueOf(a - b);
                            break;
                        case "+":
                            res = String.valueOf(a + b);
                            break;
                        default:
                            break;
                    }
                    isGetResult = true;
                    if (Double.parseDouble(res) % 1 == 0) {
                        resultView.setText(res);
                        return;
                    }
                    resultView.setText(res);
                    return;
                }
            }
            oldResultTextView = oldResultText;
            resultView.setText(buttonText);
            oldOperatorView = buttonText;
            return;
        }
        resultView.setText(oldResultTextView);
        oldResultTextView = "";
        oldOperatorView = "";
        isGetResult = false;
    }
}
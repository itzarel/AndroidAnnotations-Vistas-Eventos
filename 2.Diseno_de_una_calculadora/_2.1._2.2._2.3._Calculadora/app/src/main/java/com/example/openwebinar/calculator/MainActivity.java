package com.example.openwebinar.calculator;

import android.annotation.SuppressLint;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;

import org.androidannotations.annotations.AfterExtras;
import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterTextChange;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.LongClick;
import org.androidannotations.annotations.SeekBarProgressChange;
import org.androidannotations.annotations.Touch;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.res.AnimationRes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@SuppressLint("Registered")
@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewById(R.id.tv_operations)
    TextView tvOperations;
    @ViewById
    TextView tv_results;
    @ViewById
    Button b_dot, b_equal;
    @ViewById
    ConstraintLayout c_main_view;

    @AnimationRes
    Animation blink;

    @AfterExtras
    void a() {
        System.out.println("********************************************************************: (1) AfterExtras");
    }
    @AfterInject
    void b() {
        System.out.println("********************************************************************: (2) AfterInject");
    }
    @AfterViews
    void c() {
        System.out.println("********************************************************************: (3) AfterViews");
    }

    void setMultipleInitViews(@ViewById TextView tv_results, @ViewById(R.id.tv_operations) TextView tvOperations){
        System.out.println("********************************************************************: (4) setMultipleInitViews");
        tvOperations.setText("");
        tv_results.setText("");
    }

    @Click(R.id.b_dot)
    void buttonDotClicked() {
        final String DOT = ".";
        String writeInTvOperations = tvOperations.getText().toString();
        if (!writeInTvOperations.contains(DOT)) {
            writeInTvOperations = writeInTvOperations + DOT;
            tvOperations.setText(writeInTvOperations);
        }
    }

    @Click
    void b_equal() {
        String toRemoveZeros = tvOperations.getText().toString();
        String writeInTvResult = "", finalResult;

        if ( isThereNumbers(toRemoveZeros) ) {
            writeInTvResult = removeInitialZeros(toRemoveZeros);
            writeInTvResult = removeLastDecimalsZero(writeInTvResult);
        }
        finalResult = executeOperations(writeInTvResult);

        tv_results.setText(finalResult);
    }

    @Click({R.id.b_0, R.id.b_1, R.id.b_2, R.id.b_3, R.id.b_4, R.id.b_5, R.id.b_6, R.id.b_7, R.id.b_8, R.id.b_9, R.id.b_0})
    void bDigitalButtons(View clickedView) {
        String buttonValue = getValue(clickedView.getId());
        String writeInTvOperations = tvOperations.getText() + buttonValue;
        tvOperations.setText(writeInTvOperations);
    }

    @Click
    void b_del(View v) {
        String actualText = tvOperations.getText().toString();
        if (!actualText.isEmpty()) {
            String removedLastElement = actualText.substring(0, actualText.length() - 1);
            tvOperations.setText(removedLastElement);
        }
    }

    @LongClick
    void b_del() {
        tv_results.setText("");
    }

    @Touch({R.id.b_div, R.id.b_mul, R.id.b_min, R.id.b_plus})
    void bOperationsButtons(View v, MotionEvent event) {
        if (MotionEvent.ACTION_DOWN == event.getAction()) {
            v.startAnimation(blink);
        }
        if (MotionEvent.ACTION_UP == event.getAction()) {
            String writeInTvOperations = tvOperations.getText().toString();
            writeInTvOperations = writeInTvOperations + getOperation(v.getId());
            tvOperations.setText(writeInTvOperations);
            v.clearAnimation();
        }
    }

    @AfterTextChange
    void tv_results() {
        String tvResults = tv_results.getText().toString();
        tvOperations.setText(tvResults);
    }

    @SeekBarProgressChange
    void sb_color_selector(int progress) {
        final int OPAQUE_COLOR = 0xFF000000;
        b_dot.setBackgroundColor( OPAQUE_COLOR+progress );
        b_equal.setBackgroundColor( OPAQUE_COLOR+progress );
        c_main_view.setBackgroundColor( OPAQUE_COLOR+progress );
    }


    private boolean isThereNumbers(String stringToEvaluate) {
        return stringToEvaluate != null && ( stringToEvaluate.contains("0") ||
                stringToEvaluate.contains("1") ||
                stringToEvaluate.contains("2") ||
                stringToEvaluate.contains("3") ||
                stringToEvaluate.contains("4") ||
                stringToEvaluate.contains("5") ||
                stringToEvaluate.contains("6") ||
                stringToEvaluate.contains("7") ||
                stringToEvaluate.contains("8") ||
                stringToEvaluate.contains("9") );
    }

    private String removeInitialZeros(String toRemove) {
        final char ZERO = '0';
        final char DOT = '.';
        String toReturn;

        if ( (toRemove != null) &&
                (toRemove.length() > 0) &&
                (ZERO == toRemove.charAt(0)) ) {

            toReturn = removeInitialZeros(toRemove.substring(1));
        } else {
            if ( (toRemove == null) || (toRemove.isEmpty()) ) {
                toReturn = String.valueOf(ZERO);
            } else {
                toReturn = toRemove;
            }
            if ((DOT == toReturn.charAt(0))) {
                toReturn = "0" + toReturn;
            }
        }

        return toReturn;
    }

    private String removeLastDecimalsZero(String toRemove) {
        final String ZERO = "0";
        final String DOT = ".";
        String toReturn;

        if (toRemove.contains(DOT)) {
            String[] splittedDecimal = toRemove.split("\\.");
            String decimals = splittedDecimal[1];
            String revertedDecimals = reverseString(decimals);
            String withoutZeros = removeInitialZeros(revertedDecimals);
            if (ZERO.equals(withoutZeros)) {
                toReturn = splittedDecimal[0];
            } else {
                toReturn = splittedDecimal[0] + DOT + reverseString(withoutZeros);
            }
        } else {
            toReturn = toRemove;
        }

        return toReturn;
    }

    private String reverseString(String value) {
        return new StringBuilder(value).reverse().toString();
    }

    private String getValue(int id) {
        String value;

        switch (id) {
            case R.id.b_1:
                value = "1";
                break;
            case R.id.b_2:
                value = "2";
                break;
            case R.id.b_3:
                value = "3";
                break;
            case R.id.b_4:
                value = "4";
                break;
            case R.id.b_5:
                value = "5";
                break;
            case R.id.b_6:
                value = "6";
                break;
            case R.id.b_7:
                value = "7";
                break;
            case R.id.b_8:
                value = "8";
                break;
            case R.id.b_9:
                value = "9";
                break;
            default:
                value = "0";
                break;
        }

        return value;
    }

    private String getOperation(int id) {
        String value;

        switch (id) {
            case R.id.b_div:
                value = "/";
                break;
            case R.id.b_mul:
                value = "*";
                break;
            case R.id.b_min:
                value = "-";
                break;
            default:
                value = "+";
                break;
        }

        return value;
    }

    private String executeOperations(String operations) {
        String finalResult = "";
        List<String> recoveredOperations = recoverOperations(operations);
        recoveredOperations = removeOperatorsFromStart(recoveredOperations);
        Collections.reverse(recoveredOperations);
        recoveredOperations = removeOperatorsFromStart(recoveredOperations);
        Collections.reverse(recoveredOperations);

        if (!recoveredOperations.isEmpty()) {
            BigDecimal firstValue = new BigDecimal( recoveredOperations.get(0) );
            recoveredOperations.remove(0);
            for (int c = 0; c < recoveredOperations.size(); c = c + 2) {
                try {
                    firstValue = operate(firstValue,
                            new BigDecimal( recoveredOperations.get(c+1) ),
                            recoveredOperations.get(c));
                } catch (NumberFormatException | ArithmeticException e) {
                    e.printStackTrace();
                    tvOperations.setText("");
                }
            }
            finalResult = removeLastDecimalsZero( firstValue.toString() );
        }

        return finalResult;
    }

    private List<String> recoverOperations(String operations) {
        final String DOT = ".";
        List<String> values = new ArrayList<>();
        StringBuilder tmpNumber = new StringBuilder();

        for (int c = 0; c < operations.length(); c++) {
            String anValueFromOperations = String.valueOf(operations.charAt(c));
            if ( isThereNumbers(anValueFromOperations) || DOT.equals(anValueFromOperations) ) {
                tmpNumber.append(anValueFromOperations);
            } else {
                values.add( tmpNumber.toString() );
                values.add(anValueFromOperations);
                tmpNumber.setLength(0);
            }
        }
        values.add( tmpNumber.toString() );

        return values;
    }

    private List<String> removeOperatorsFromStart(List<String> in) {
        if (in != null && !in.isEmpty())
            if ( !isNumeric( in.get(0) ) ) {
                String a = in.remove(0);
                removeOperatorsFromStart(in);
            }

        return in;
    }

    private BigDecimal operate(BigDecimal firstOperator, BigDecimal secondOperator, String operation) throws ArithmeticException {
        BigDecimal toReturn = BigDecimal.valueOf(0);

        switch (operation) {
            case "/":
                final int SCALE = 5;
                toReturn = firstOperator.divide(secondOperator, SCALE, BigDecimal.ROUND_HALF_UP);
                break;
            case "*":
                toReturn = firstOperator.multiply(secondOperator);
                break;
            case "-":
                toReturn = firstOperator.subtract(secondOperator);
                break;
            case "+":
                toReturn = firstOperator.add(secondOperator);
                break;
        }

        return toReturn;
    }

    private boolean isNumeric(String strNum) {
        try {
            Double.parseDouble(strNum);
            return true;
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
    }
}

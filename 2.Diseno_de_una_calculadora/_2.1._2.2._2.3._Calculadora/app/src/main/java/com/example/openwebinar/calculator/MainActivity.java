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





// CLICK ///////////////////////////////////////////////////////////////////////////////////////////
    @Click({R.id.b_1, R.id.b_2, R.id.b_3, R.id.b_4, R.id.b_5,
            R.id.b_6, R.id.b_7, R.id.b_8, R.id.b_9, R.id.b_0})
    void bDigitalButtons(View clickedView) {
        String buttonValue = getValue(clickedView.getId());
        String writeInTvOperations = tvOperations.getText() + buttonValue;
        tvOperations.setText(writeInTvOperations);
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

/*
    @Click
    void b_1() {
        Log.i("OK", "Hemos ejecutado un simple click");
    }

    // LONG CLICK //////////////////////////////////////////////////////////////////////////////////
    @LongClick
    void b_1(View longClick) {
        Log.i("OK", "Hemos ejecutado un LongClick");
    }


    // TOUCH ///////////////////////////////////////////////////////////////////////////////////////
    @Touch
    void b_1(MotionEvent motionEvent) {
        if (MotionEvent.ACTION_UP == motionEvent.getAction()) {
            Log.i("KO", "No podemos combinar Touch con Click y LongClick. Estos ultimos son absorvidor por Touch");
        }
    }*/





    // AfterTextChange /////////////////////////////////////////////////////////////////////////////
    @AfterTextChange
    void tv_results() {
        String tvResults = tv_results.getText().toString();
        tvOperations.setText(tvResults);
    }





////////////////////////////////////////////////////////////////////////////////////////////////////
// ESTO ES PARA LAS PRÁCTICAS //////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////

/**
    /////////////////
    // PRACTICA #1 //
    /////////////////
*/
    @LongClick
    void b_del() {
        tv_results.setText("");
    }

    @Click
    void b_del(View v) {
        String actualText = tvOperations.getText().toString();
        if (!actualText.isEmpty()) {
            String removedLastElement = actualText.substring(0, actualText.length() - 1);
            tvOperations.setText(removedLastElement);
        }
    }




/**
    /////////////////
    // PRACTICA #2 //
    /////////////////
*/
    @Touch({R.id.b_div, R.id.b_mul, R.id.b_min, R.id.b_plus})
    void bOperationsButtons(View button, MotionEvent event) {
        if (MotionEvent.ACTION_DOWN == event.getAction()) {
            button.startAnimation(blink);
        }
        if (MotionEvent.ACTION_UP == event.getAction()) {
            String writeInTvOperation = tvOperations.getText().toString() +
                    ((Button) button).getText().toString();
            tvOperations.setText(writeInTvOperation);
            button.clearAnimation();
        }
    }




/**
    /////////////////
    // PRACTICA #3 //
    /////////////////
*/
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




/**
    /////////////////
    // PRACTICA #4 //
    /////////////////
*/
    @SeekBarProgressChange
    void sb_color_selector(int progress) {
        final int OPAQUE_COLOR = 0xFF000000;
        final  int OPAQUE_COLOR_WHITE = 0xFFFFFFFF;

        b_dot.setBackgroundColor( OPAQUE_COLOR+progress );
        b_equal.setBackgroundColor( OPAQUE_COLOR+progress );
        c_main_view.setBackgroundColor( OPAQUE_COLOR+progress );

        tvOperations.setTextColor(OPAQUE_COLOR_WHITE-progress);
        tv_results.setTextColor(OPAQUE_COLOR_WHITE-progress);
        b_dot.setTextColor(OPAQUE_COLOR_WHITE-progress);
        b_equal.setTextColor(OPAQUE_COLOR_WHITE-progress);
    }


    /**
     * Asegura que haya al menos un numero
     * @param stringToEvaluate La información recuperada del TextView
     * @return booleano: Hay la menos un numero
     */
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

    /**
     * Permite eliminar todos los ceros iniciales
     * @param toRemove String con los numeros a evaluar y eliminar los ceros iniciales
     * @return string sin ceros inicales
     */
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

    /**
     * Permite eliminar todos los ceros finales detras de la coma
     * @param toRemove String con los numeros a evaluar y eliminar los ceros finales
     * @return string sin ceros finales tras la coma
     */
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

    /**
     * Invierte el string pasado por parametro al metodo
     * @param value string a invertir
     * @return string invertido
     */
    private String reverseString(String value) {
        return new StringBuilder(value).reverse().toString();
    }

    /**
     * Permite recuperar el valor que tiene el botón pulsado
     * @param id Identificador del botón
     * @return Valor del botón
     */
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

    /**
     * Hace el calculo general de todas la operaciones compuestas por numero-operacion-numero
     * @param operations String con las operaciones
     * @return Stringcon el resultado final
     */
    private String executeOperations(String operations) {
        String finalResult = "";
        //Elimina las operaciones de inicio y final
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
                    //Realiza la operacion de numero-operacion-numero
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

    /**
     * Creará una lista de numero-operacion-numero, teniendo en cuenta que los numeros pueden ser decimales
     * @param operations String que contiene los numeros y operaciones
     * @return Lista con numero-operacion-numero
     */
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

    /**
     * Permite eliminar al inicio lo que no sean numeros
     * @param in Lista numero-operacion-numero
     * @return Lista asegurada que comienza por un numero
     */
    private List<String> removeOperatorsFromStart(List<String> in) {
        if (in != null && !in.isEmpty())
            if ( !isNumeric( in.get(0) ) ) {
                String a = in.remove(0);
                removeOperatorsFromStart(in);
            }

        return in;
    }

    /**
     * Realiza la operacion aritmetica
     * @param firstOperator Primer operador
     * @param secondOperator Segundo operador
     * @param operation Operacion
     * @return Resultado de la operacion
     * @throws ArithmeticException Controla posibles excepciones al convertir in String a un numero
     */
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

    /**
     * Valida que sea un numero
     * @param strNum Strin numerico
     * @return boolean: si es numero
     */
    private boolean isNumeric(String strNum) {
        try {
            Double.parseDouble(strNum);
            return true;
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
    }
}

# Mostrar la operación al hacer click sobre su botón

Esta práctica consiste en que al hacer click sobre la operación se deberá iniciar un parpadeo del botón (una animación blink, la cual deberá finalizar cuando se levante el botón) y muestre la operación realizada sobre la pantalla de la calculadora.

```
    @AnimationRes
    Animation blink;

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
```

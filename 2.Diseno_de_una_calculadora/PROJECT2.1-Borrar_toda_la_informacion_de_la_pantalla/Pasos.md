# Borrar toda la informacion de la pantalla

```
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
```
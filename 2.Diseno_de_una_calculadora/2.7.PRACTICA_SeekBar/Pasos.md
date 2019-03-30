# SeekBar

Cuando se mueva el widget del SeekBar, deberá cambiar el color de fondo de la vista y de los botones DOT y EQUALS.

```
    @SeekBarProgressChange
    void sb_color_selector(int progress) {
        final int OPAQUE_COLOR = 0xFF000000;
        b_dot.setBackgroundColor( OPAQUE_COLOR+progress );
        b_equal.setBackgroundColor( OPAQUE_COLOR+progress );
        c_main_view.setBackgroundColor( OPAQUE_COLOR+progress );
    }
```
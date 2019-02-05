# Tests

## Pregunta 1

#### ¿Qué nos permite la anotación ViewById?

1. Instanciar una animación

2. Instanciar un recurso

3. Instanciar un objeto de UI

4. Instanciar un API REST

> Respuesta [ 3 ]

## Pregunta 2

#### ¿Qué instanciación no es correcta?

1.
```
        @ViewById(R.id.tv_view)
        TextView tvView;
```

2.
```
        @ViewById
        void setViews(@ViewById TextView tv_results){
          // do something with tv_results
        }
```

3.
```
        @ViewById
        TextView tv_view;
```

4. Todas con correctas, por lo que ninguna

> Respuesta [ 2 ]

## Pregunta 3

#### ¿Cuál es la instanciación correcta?

1.
        @ViewById
        TextView tv_results;`

```

2.
```
        @ViewById
        void setOneView(EditText myEditText){
          // do something with myEditText
        }
```

3.
```
        void setMultipleInitViews(@ViewById(R.id.tv_operations) TextView tvOperations){
          // do something with tvOperations
        }
```

4.
```
        void setMultipleInitViews(@ViewById TextView tv_results){
          // do something with tv_results
        }
```

> Respuesta [ 1, 2, 3, 4 ]

## Pregunta 4

#### Qué anotación no es un evento de UI?

1. Click

2. Touch

3. ShortClick

4. LongClick

> Respuesta [ 3 ]

## Pregunta 5

#### ¿Qué instanciación no es correcta?

1.
```
        @Click({R.id.b_0, R.id.b_1, R.id.b_2, R.id.b_3, R.id.b_4, R.id.b_5, R.id.b_6, R.id.b_7, R.id.b_8, R.id.b_9, R.id.b_0})
        void bDigitalButtons(@Click View clickedView)

2.
```
        @Click({R.id.b_0, R.id.b_1, R.id.b_2, R.id.b_3, R.id.b_4, R.id.b_5, R.id.b_6, R.id.b_7, R.id.b_8, R.id.b_9, R.id.b_0})
        void bDigitalButtons(View clickedView)
```

3.
```
        @Click(R.id.b_0)
        void bDigitalButtons(View clickedView)
```

4. Todas con correctas, por lo que ninguna

> Respuesta [ 1 ]

## Pregunta 6

#### ¿Cuál es la instanciación correcta?

1.
```
        @Click(R.id.b_dot)
        void buttonDotClicked()
```

2.
```
        @Click
        void b_equal()
```

3.
```
        @Click
        void yetAnotherButton(View clickedView)
```

4.
```
        @Click({R.id.b_0, R.id.b_1, R.id.b_2, R.id.b_3, R.id.b_4, R.id.b_5, R.id.b_6, R.id.b_7, R.id.b_8, R.id.b_9, R.id.b_0})
        void bDigitalButtons()
```

> Respuesta [ 1, 2, 3, 4 ]

## Pregunta 7

#### ¿Qué instanciación no es correcta?

1.
```
        @Touch
        void bOperationsButtons(MotionEvent event)
```

2.
```
        @Touch
        void bOperationsButtons(View v, MotionEvent event)
```

3.
```
        @Touch
        void bOperationsButtons()
```

4. Todas con correctas, por lo que ninguna

> Respuesta [ 4 ]

## Pregunta 8

#### ¿Cuál es la instanciación correcta?

1.
```
        @Touch
        View bOperationsButtons
```

2.
```
        @Touch
        void bOperationsButtons(View v, MotionEvent event)
```

3.
```
        @Touch
        MotionEvent bOperationsButtons
```

4.
```
        @Touch
        Object bOperationsButtons(View v, MotionEvent event)
```

> Respuesta [ 2 ]

## Pregunta 9

#### ¿Con la anotación Click puedo saber cuando el usuario a pulsado el objeto y cuando ha levantado el dedo?

1. Sí, siempre

2. Sí, pero añadiendo el parámetro de entrada MotionEvent

3. Según como se haya escribo el objeto en la UI (en el XML, si se le ha añadido la opción MotionEvent)

4. No, nunca

> Respuesta [ 4 ]

## Pregunta 10

#### ¿Puedo tener un mismo objeto de UI con el evento LongClick y Touch?

1. Sí, siempre

2. Sí, pero añadiendo el parámetro de entrada Long en el evento de Touch

3. Según como se haya escribo el objeto en la UI (en el XML, si se le ha añadido la opción LongClick)

4. No, nunca

> Respuesta [ 4 ]

## Pregunta 11

#### ¿Puedo tener un mismo objeto de UI con el evento Click y Touch?

1. Sí, siempre

2. Sí, pero añadiendo el parámetro de entrada Click en el evento de Touch

3. Según como se haya escribo el objeto en la UI (en el XML, si se le ha añadido la opción Click)

4. No, nunca

> Respuesta [ 4 ]

## Pregunta 12

#### ¿Puedo tener un mismo objeto de UI con el evento Click y LongClick?

1. Sí, siempre

2. Sí, pero añadiendo el parámetro de entrada LongClick en el evento de Click

3. Según como se haya escribo el objeto en la UI (en el XML, si se le ha añadido la opción LongClick)

4. No, nunca

> Respuesta [ 1 ]

## Pregunta 13

#### ¿Cómo puedo saber si el usuario está moviendo o desplazando el dedo?

1. Con la anotación Touch y MotionEvent.ACTION_UP

2. Con la anotación Touch y MotionEvent.ACTION_DOWN

3. Con la anotación Touch y MotionEvent.ACTION_MOVE

4. No se puede saber

> Respuesta [ 3 ]

## Pregunta 14

#### ¿Cómo podemos detectar un evento de LongClick?

1. Con la anotación Click

2. Con la anotación LongClick

3. Con la anotación Touch y el MotionEvent

4. Con la anotación Touch y la View

> Respuesta [ 2, 3 ]

## Pregunta 15

#### ¿Puedo tener varios métodos con el mismo nombre y diferentes anotaciones?

1. Sí

2. Sí, pero sólo cuando llueven ranas con pelo

3. Sí, pero sólo si hago un fix

4. No, nunca

> Respuesta [ 3 ]

## Pregunta 16

#### ¿Qué anotación nos permite capturar el evento de antes de la modificación de código?

1. TextChange

2. BeforeTextChange

3. AfterTextChange

4. No existe una anotación así

> Respuesta [ 2 ]

## Pregunta 17

#### ¿Qué instanciación no es correcta?

1.
```
       @AfterTextChange(R.id.helloTextView)
       void afterTextChangedOnHelloTextView(Editable text, TextView hello)
```

2.
```
       @AfterChange(R.id.helloTextView)
       void afterTextChangedOnHelloTextView(TextView hello)
```

3.
```
       @AfterTextChange(R.id.helloTextView)
       void afterTextChangedOnHelloTextView()
```

4. Todas con correctas, por lo que ninguna

> Respuesta [ 2 ]

## Pregunta 18

#### ¿Cuál es la instanciación correcta?

1.
```
       @AfterTextChange(R.id.helloTextView)
       void afterTextChangedOnHelloTextView()
```

2.
```
       @AfterTextChange({R.id.editText, R.id.helloTextView})
       void afterTextChangedOnSomeTextViews(TextView tv, Editable text)
```

3.
```
       void afterTextChangedOnHelloTextView(@AfterTextChange Editable text)
```

4.
```
       @AfterTextChange(R.id.helloTextView)
       void afterTextChangedOnHelloTextView(Editable text, TextView hello)
```

> Respuesta [ 1, 2, 3, 4 ]

## Pregunta 19

#### ¿Qué anotación detecta el evento de inicio del movimiento de una Seekbar?

1. SeekBarProgressChange

2. SeekBarTouchStart

3. SeekBarTouchStop

4. No hay anotación que haga esta operación

> Respuesta [ 2 ]

## Pregunta 20

#### ¿Qué anotación detecta el evento de movimiento de una Seekbar?

1. SeekBarProgressChange

2. SeekBarTouchStart

3. SeekBarTouchStop

4. No hay anotación que haga esta operación

> Respuesta [ 1 ]

## Pregunta 21

#### ¿Qué anotación me permite eliminar el texto de un Textview?

1. ClearTextView

2. CleanTextView

3. TextView

4. No hay anotación que haga esta operación, por lo que lo haré empleando `TextView.setText("");` por ejemplo

> Respuesta [ 4 ]

## Pregunta 22

#### Si defino un método cuya anotación de Click funciona para varios objetos de UI, es decir tiene múltiples parámetros de entrada la anotación ¿Cómo puedo detectar el objeto que ha desencadenado el evento?

1. No se puede

2. Poniendo como parámetro de entrada al método un `int` que captura el id del objeto

3. Poniendo como parámetro de entrada al método una `View` y luego evaluando el id con `v.getId`

4. La anotación lo hace de forma inteligente, AndroidAnnotations es muy potente

> Respuesta [ 3 ]

## Pregunta 23

#### ¿Donde puedo consultar información sobre la anotación ViewById?

1. <https://github.com/androidannotations/androidannotations/wiki/Injecting-Views#viewbyid>

2. <https://github.com/androidannotations/androidannotations/wiki/ClickEvents#other-events>

3. <https://github.com/androidannotations/androidannotations/wiki/ClickEvents#click>

4. <https://github.com/androidannotations/androidannotations/wiki/TextChangeEvents#aftertextchange>

> Respuesta [ 1 ]

## Pregunta 24

#### ¿Donde puedo consultar información sobre la anotación Click?

1. <https://github.com/androidannotations/androidannotations/wiki/Injecting-Views#viewbyid>

2. <https://github.com/androidannotations/androidannotations/wiki/ClickEvents#other-events>

3. <https://github.com/androidannotations/androidannotations/wiki/ClickEvents#click>

4. <https://github.com/androidannotations/androidannotations/wiki/TextChangeEvents#aftertextchange>

> Respuesta [ 3 ]

## Pregunta 25

#### ¿Donde puedo consultar información sobre la anotación Touch?

1. <https://github.com/androidannotations/androidannotations/wiki/Injecting-Views#viewbyid>

2. <https://github.com/androidannotations/androidannotations/wiki/ClickEvents#other-events>

3. <https://github.com/androidannotations/androidannotations/wiki/ClickEvents#click>

4. <https://github.com/androidannotations/androidannotations/wiki/TextChangeEvents#aftertextchange>

> Respuesta [ 2 ]

## Pregunta 26

#### ¿Donde puedo consultar información sobre la anotación AfterTextChange?

1. <https://github.com/androidannotations/androidannotations/wiki/Injecting-Views#viewbyid>

2. <https://github.com/androidannotations/androidannotations/wiki/ClickEvents#other-events>

3. <https://github.com/androidannotations/androidannotations/wiki/ClickEvents#click>

4. <https://github.com/androidannotations/androidannotations/wiki/TextChangeEvents#aftertextchange>

> Respuesta [  ]

## Pregunta 27

#### ¿Donde puedo consultar información sobre la anotación LongClick?

1. <https://github.com/androidannotations/androidannotations/wiki/Injecting-Views#viewbyid>

2. <https://github.com/androidannotations/androidannotations/wiki/ClickEvents#other-events>

3. <https://github.com/androidannotations/androidannotations/wiki/ClickEvents#click>

4. <https://github.com/androidannotations/androidannotations/wiki/TextChangeEvents#aftertextchange>

> Respuesta [ 2 ]

## Pregunta 28

#### ¿Donde puedo consultar información sobre la anotación SeekBarProgressChange?

1. <https://github.com/androidannotations/androidannotations/wiki/SeekBarEvents#seekbarprogresschange>

2. <https://developer.android.com/reference/android/widget/SeekBar.OnSeekBarChangeListener>

3. <http://androidannotations.org/>

4. <https://github.com/androidannotations/androidannotations/wiki/FAQ>

> Respuesta [ 1 ]

## Pregunta 29

#### ¿Donde puedo consultar información del evento SeekBar.OnSeekBarChangeListener?

1. <https://github.com/androidannotations/androidannotations/wiki/SeekBarEvents#seekbarprogresschange>

2. <https://developer.android.com/reference/android/widget/SeekBar.OnSeekBarChangeListener>

3. <http://androidannotations.org/>

4. <https://github.com/androidannotations/androidannotations/wiki/FAQ>

> Respuesta [ 2 ]

## Pregunta 30

#### ¿Si al compilar obtienes el siguiente error `error: The AndroidManifest.xml file contains the original component, and not the AndroidAnnotations generated component. Please register MainActivity_ instead of MainActivity` qué deberemos modificar?

1. AndroidAnnotations, Tag: category

2. AndroidAnnotations, Tag: intent-filter

3. Hay que cambiar el nombre de la actividad MainActivity

4. AndroidAnnotations, Tag: activity

> Respuesta [ 4 ]

## Pregunta 31

#### ¿Qué anotación se ejecuta antes del onCreate?

1. AfterInject, AfterViews

2. AfterViews

3. AfterExtras

4. AfterExtras, AfterInject

> Respuesta [ 4 ]

## Pregunta 32

#### ¿Con que anotación podemos recibir un mensaje de la clase llamante?

1. Bean

2. Extra

3. App

4. StringRes

> Respuesta [ 2 ]

## Pregunta 33

#### ¿Cuál es el orden correcto de ejecución?

1. AfterInject, AfterExtras, onCreate, AfterView, onStart, onResume

2. AfterExtras, AfterInject, onCreate, AfterView, onResume, onStart

3. AfterExtras, AfterInject, onCreate, AfterView, onStart, onResume

4. AfterExtras, AfterView, AfterInject

> Respuesta [ 3 ]

## Pregunta 34

#### ¿Asegura @AfterExtras y @AfterInject asegura que esté todo inicializado?

1. No

2. Sí

3. Podría ser

4. Está todo inicializado, menos objetos de UI

> Respuesta [ 4 ]

## Pregunta 35

#### ¿Con qué anotación podemos podemos recuperar la información del contexto?

1. GetContext

2. RootContext

3. Context

4. GetRoot

## Pregunta 36

#### ¿Qué permite recuperar un booleano desde los recursos?

1. StringRes

2. ColorRes

3. BooleanRes

4. AnimationRes

> Respuesta [ 3 ]

## Pregunta 37

#### ¿Con que anotación podemos crear un bean?

1. EBean

2. EApplication

3. EView

4. EActivity

> Respuesta [ 1 ]

## Pregunta 38

#### ¿Con qué anotación podemos crear una subaplicación?

1. EBean

2. EApplication

3. EView

4. EActivity

> Respuesta [ 2 ]

## Pregunta 39

#### ¿Qué permite recuperar una animación?

1. StringRes

2. ColorRes

3. BooleanRes

4. AnimationRes

> Respuesta [ 4 ]

## Pregunta 40

#### ¿Qué método asegura la inicialización de los objetos de UI?

1. AfterInject

2. AfterViews

3. AfterExtras

4. Los objetos de UI están inicializados desde el comienzo de la app

> Respuesta [ 2 ]
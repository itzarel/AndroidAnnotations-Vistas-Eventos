# Pantalla de la calculadora: Anotación ViewById

En este tema veremos la anotación `ViewById` y trataremos las 5 diferentes maneras de usar a ésta.
Podemos ver la documentación de esta anotación en <https://github.com/androidannotations/androidannotations/wiki/Injecting-Views#viewbyid>.

- Anotación con parámetro de entrada (es decir, especificando el recurso):

```
	    @ViewById(R.id.tv_operations)
	    TextView tvOperations;
```

- Anotación sin parámetro de entrada: El nombre de la variable Java será la referencia:

```
	    @ViewById
	    TextView tv_results;
```

- Anotando un método:

```
	    @ViewById
	    void setOneView(EditText myEditText){
	      // do something with myEditText
	    }
```

- Anotando el/los parámetro(s) de entrada de un método e indicando a la anotación el recurso:

```
	    void setMultipleInitViews(@ViewById(R.id.tv_operations) TextView tvOperations){
	      // do something with tvOperations
	    }
```

- Anotando el/los parámetro(s) de entrada de un método pero sin indicar a la anotación el recurso ya que lo coge directamente del nombre de la variable Java:

```
	    void setMultipleInitViews(@ViewById TextView tv_results){
	      // do something with tv_results
	    }
```

Por lo general la metodología más empleada es la segunda, es decir la anotación sin parámetro de entrada.

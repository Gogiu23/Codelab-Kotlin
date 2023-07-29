# Kotlin

## Ques es `kotlin`
Kotlin es un lenguaje de programación estático de código abierto que admite la programación funcional y orientada a objetos. Proporciona una sintaxis y conceptos similares a los de otros lenguajes, como C#, Java y Scala, entre muchos otros. No pretende ser único, sino que se inspira en décadas de desarrollo del lenguaje. Cuenta con variantes que se orientan a la JVM (Kotlin/JVM), JavaScript (Kotlin/JS) y el código nativo (Kotlin/Native).


Kotlin es administrado por Kotlin Foundation, un grupo que creó JetBrains y Google, que se ocupa de continuar el desarrollo del lenguaje. Google es compatible oficialmente con Kotlin para el desarrollo de Android, lo cual significa que la documentación y las herramientas de Android se diseñaron para admitir Kotlin.

Algunas APIs de Android, como Android KTX, son específicas de Kotlin, pero la mayoría están escritas en Java y se pueden llamar desde Java o Kotlin. La interoperabilidad de Kotlin con Java es fundamental para su crecimiento. Eso quiere decir que puedes llamar al código Java desde Kotlin, y viceversa, y de esa manera aprovechar todas tus bibliotecas de Java existentes. La popularidad de Kotlin da como resultado una experiencia de desarrollo más agradable en Android, aunque continuamos desarrollando el marco de trabajo de Android con Kotlin y Java en la mente.

La interoperabilidad de Kotlin con Java implica que no tienes que implementar Kotlin de una sola vez. Puedes tener proyectos con código Kotlin y Java. Para obtener más información sobre la incorporación de Kotlin a una app existente, consulta Cómo agregar Kotlin a una app existente. Si formas parte de un equipo más grande, es posible que el tamaño de tu organización y tu base de código necesiten un enfoque especial. Si deseas obtener sugerencias y más información, consulta Cómo implementar Kotlin para equipos grandes.

Si deseas comenzar a usar Kotlin desde cero, ofrecemos un curso intensivo de 30 minutos para ayudarte a empezar. Puedes encontrar la documentación oficial de Kotlin en https://kotlinlang.org. Si deseas obtener acceso a libros recomendados, consulta Libros.

Para ver ejemplos de Kotlin específicos de Android, consulta Patrones de Kotlin comunes en Android.

## Jet Compose

Jet compose es un kit de herramientas moderno para crear IU de Android.

> Funciones de componibilidad

**Las funciones que admiten composicion cumplen con lo siguiente:**

1. Describe alguna parte de tu IU.

2. No muestra nada

3. Toma información y genera lo que se muestra en pantalla

4. Puede emitir varios elementos de la IU.

## Anotaciones
Son una forma de adjuntar informacion adicional al codigo. 
Para aplicar una anotacion, se agrega un prefijo al nombre (anotacion) con el caracter `@` al comienzo de la declaracion.

<img src="https://github.com/Gogiu23/Codelab-Kotlin/blob/main/images/jetcompose.png" width="1500" height="500">
__________________________________________________________________________________________


### Se pueden anotar diferentes elementos de codigo, incluidas propiedades, funciones y clases.
Por ejemplo:

<img src="https://github.com/Gogiu23/Codelab-Kotlin/blob/main/images/anotaciones_sin_param.png" width="1000" height="300">

- Anotaciones sin parametros

<img src="https://github.com/Gogiu23/Codelab-Kotlin/blob/main/images/anotaciones_con_param.png" width="1000" height="300">

- Anotaciones con parametros

<img src="https://github.com/Gogiu23/Codelab-Kotlin/blob/main/Codelab-Kotlin/images/anotaciones_varios_param.png" width="1500" height="500">

- Anotaciones con varios parametros;

### Ejemplo de una función de componibilidad
La función de componibilidad tiene la anotación @Composable. Todas estas funciones deben tener esta anotación. La anotación informa al compilador de Compose que esta función está diseñada para convertir datos en IU. Te recordamos que un compilador es un programa especial que toma el código que escribiste, lo analiza línea por línea y lo traduce a algo que la computadora puede comprender (lenguaje automático).

Este fragmento de código es un ejemplo de una función simple de componibilidad a la que le pasan datos (el parámetro de la función name) y los usa para procesar un elemento de texto en la pantalla.
```kotlin
@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}
```

### Nombres de funciones de componibilidad
La función de Compose que no muestra nada y lleva la anotación @Composable DEBE tener un nombre con letra mayúscula inicial. Esta es una convención de nomenclatura según la cual la primera letra de cada palabra de una palabra compuesta lleva mayúsculas. La diferencia entre este formato y el de mayúsculas y minúsculas es que, en el primer caso, todas las palabras se escriben con mayúscula inicial. En el segundo caso, la primera palabra no lleva mayúsculas.

La función de Compose tiene las siguientes características:

- DEBE ser un sustantivo: DoneButton().
- NO debe ser un verbo ni una frase verbal: DrawTextField().
- NO debe ser una preposición convertida en sustantivo: TextFieldWithLink().
- NO debe ser un adjetivo: Bright().
- NO debe ser un adverbio: Outside().
- Los sustantivos PUEDEN estar precedidos por adjetivos descriptivos: RoundIcon().

## Como agregar un nuevo elemento de texto

### Cómo agregar una nueva función de componibilidad
```kotlin
@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}
```
```kotlin
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview(){
    HappyBirthdayTheme {
    }
}

@Composable
fun BirthdayGreetingWithText() {
}

@Composable
fun BirthdayGreetingWithText(modifier: Modifier = Modifier) {
}

@Composable
fun BirthdayGreetingWithText(message: String, modifier: Modifier = Modifier) {
}
```
En la función BirthdayGreetingWithText(), agrega un elemento Text que admite composición que pase el mensaje de texto como un argumento con nombre.
```kotlin
@Composable
fun BirthdayGreetingWithText(message: String, modifier: Modifier = Modifier) {
    Text(
       text = message
    )
}
```
Esta función BirthdayGreetingWithText() muestra texto en la IU. Para ello, llama a la función de componibilidad Text().

Cómo obtener una vista previa de la función
En esta tarea, obtendrás una vista previa de la función BirthdayGreetingWithText() en el panel Design.

Llama a la función BirthdayGreetingWithText() dentro de la función BirthdayCardPreview().
Pasa un argumento de tipo String a la función BirthdayGreetingWithText(), un saludo de cumpleaños a tu amigo. Si lo deseas, puedes personalizarlo con su nombre, como "Happy Birthday Sam!".

```kotlin
@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    HappyBirthdayTheme {
        BirthdayGreetingWithText(message = "Happy Birthday Sam!")
    }
}
```

## Como cambiar el tamaño de la fuente
Los píxeles escalables (SP) son una unidad de medida para el tamaño de fuente. Los elementos de la IU en apps para Android usan dos unidades de medición diferentes: los píxeles independientes de la densidad (DP), que usarás más tarde para el diseño, y los píxeles escalables (SP). De forma predeterminada, la unidad de SP tiene el mismo tamaño que la unidad de DP, pero cambia según el tamaño de texto que prefiera el usuario en la configuración del teléfono.
```kotlin
Text(
   text = message,
   fontSize = 36.sp
)
```
### Como Organizar los elementos de texto en una fila y columna

#### Jerarquia de la IU

La jerarquía de la IU se basa en la contención, es decir, un componente puede contener uno o más componentes. A veces, se usan los términos superior y secundario.
El caso es que los elementos superiores de la IU pueden contener elementos secundarios de la IU.
Los tres elementos basicos en `Compose` son:

- Column
- Row
- Box

<h1 align="center">

![](https://github.com/Gogiu23/Codelab-Kotlin/blob/main/images/elements1.png)

</h1>

Asi se expressa en codigo:
```kotlin
Row {
    Text("First Column")
    Text("Second Column")
}
```

Son funciones que admiten composicion y toman contenido de este tipo como argumentos.

### Sintaxis de expression lambda final
En el fragmento de codigo anterior observa que se usan llaves en lugar de parentesis con la funcion `Row`.
Esto se llama ***sintaxi de expression lambda***

Kotlin ofrece una sintaxis especial para pasar funciones como parámetros a funciones cuando el último parámetro es una función.

![](https://github.com/Gogiu23/Codelab-Kotlin/blob/main/images/elements2.png)

Si quieres pasar una función como ese parámetro, puedes usar la sintaxis de expresión lambda final. En lugar de colocar el cuerpo de la función junto con el nombre de la función entre paréntesis ({}), debes colocar los paréntesis junto con el cuerpo de la función después de su nombre. Esta práctica es común en Compose, por lo que debes familiarizarte con la apariencia del código.

Por ejemplo, el último parámetro en la función de componibilidad Row() es el parámetro content, una función que emite los elementos secundarios de la IU. Supongamos que deseas crear una fila que contenga tres elementos de texto. Este código funciona, pero es muy engorroso:
```kotlin
Row(
    content = {
        Text("Some text")
        Text("Some more text")
        Text("Last text")
    }
)
```
Como el parámetro content es el último de la firma de la función y pasas su valor como una expresión lambda (por ahora, no hay problema si no sabes qué es una lambda; solo familiarízate con la sintaxis), puedes quitar el parámetro content y los paréntesis de la siguiente manera:
```kotlin
Row {
    Text("Some text")
    Text("Some more text")
    Text("Last text")
}
```
## Pequeño resumen

- Jetpack Compose es un kit de herramientas moderno para crear IU de Android. Jetpack Compose simplifica y acelera el desarrollo de IU en Android con menos código, herramientas potentes y API intuitivas de Kotlin.
- La interfaz de usuario (IU) de una app es lo que ves en la pantalla: texto, imágenes, botones y muchos otros tipos de elementos.
- Las funciones que admiten composición son los componentes fundamentales de Compose. Una función de este tipo es aquella que describe alguna parte de tu IU.
- La función de componibilidad tiene la anotación @Composable. Esta anotación informa al compilador de Compose que esta función está diseñada para convertir datos en IU.
- Los tres elementos de diseño estándar básicos de Compose son Column, Row, y Box. Son funciones Composable y que toman contenido de este tipo, por lo que puedes colocar elementos dentro de ellas. Por ejemplo, cada elemento secundario dentro de un Row se ubicará de forma horizontal uno al lado del otro.

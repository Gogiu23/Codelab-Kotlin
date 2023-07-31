# Cuadrante

**Los imports se han omitido para facilitar la consulta de codigo**

```kotlin
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CuadranteTheme {
                // A surface container using the 'background' color from the theme
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    CuadranteText_app()
                }
            }
        }
    }
}

@Composable
fun CuadranteText_app(){
    Column (Modifier.fillMaxWidth()) {
        Row (Modifier.weight(1f)) {
            CuadranteTexto(
                title = stringResource(id = R.string.Cuadrante_1a),
                description = stringResource(id = R.string.Cuadrante_1b),
                backgroundColor = Color.Green,
                modifier = Modifier.weight(1f)
            )
            CuadranteTexto(
                title = stringResource(id = R.string.Cuadrante_2a),
                description = stringResource(id = R.string.Cuadrante_2b),
                backgroundColor = Color.Yellow,
                modifier = Modifier.weight(1f)
            )
        }
        Row (Modifier.weight(1f)){
            CuadranteTexto(
                title = stringResource(id = R.string.Cuadrante_3a),
                description = stringResource(id = R.string.Cuadrante_3b),
                backgroundColor = Color.Cyan,
                modifier = Modifier.weight(1f))
            CuadranteTexto(
                title = stringResource(id = R.string.Cuadrante_4a),
                description = stringResource(id = R.string.Cuadrante_4b),
                backgroundColor = Color.LightGray,
                modifier = Modifier.weight(1f))
        }
    }
}

@Composable
private fun CuadranteTexto(
    title: String,
    description: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier
){
    Column (
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        Text(
            text = title,
            modifier = Modifier.padding(bottom = 16.dp),
            fontWeight = FontWeight.Bold)
        Text(text = description,
            textAlign = TextAlign.Justify)
    }
}
```

# Happy Birthday

**Los import se han omitido para facilitar la consulta de codigo**

```kotlin
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    BirthdayGreetingWhithImage(
                        message = stringResource(R.string.Compleanno_text),
                        from = stringResource(R.string.Firma_txt)
                    )
                   // BirthdayGreetingWithText(message = "Buon Compleanno Giuli", from = "- da tutti")
                }
            }
        }
    }
}

@Composable
fun BirthdayGreetingWhithImage(message: String, from: String, modifier: Modifier = Modifier){
    val image = painterResource(id = R.drawable.androidparty)
    Box {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
    }
    BirthdayGreetingWithText(message = message, from = from)
}

@Composable
fun BirthdayGreetingWithText(message: String, from: String, modifier: Modifier = Modifier) {
    Column (
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = message,
            fontSize = 36.sp,
            modifier = Modifier
                .padding(top = 16.dp)
        )
        Text(
            text = from,
            fontSize = 26.sp,
            modifier = Modifier
                .padding(
                    top = 16.dp,
                    end = 16.dp)
                .align(alignment = Alignment.End)
        )
    }
}

@Preview(showBackground = false)
@Composable
fun BirthdayCardPreview() {
    HappyBirthdayTheme {
        BirthdayGreetingWhithImage(
            stringResource(id = R.string.Compleanno_text),
            stringResource(id = R.string.Firma_txt)
            )
    }
}
```

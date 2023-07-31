# Administrador de Tareas

**Tener en cuenta que los imports se han omitido en el readme.**
```kotlin
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AdministradorDeTareasTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = Color.White
                ) {
                    TaskCompleteImage(
                        message = stringResource(id = R.string.title),
                        second = stringResource(id = R.string.second_mess))
                }
            }
        }
    }
}

@Composable
fun TaskCompleteImage(message: String, second: String, modifier: Modifier = Modifier){
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val image = painterResource(id = R.drawable.ic_task_completed)
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )
        Text(
            text = message,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(
                    top = 24.dp,
                    bottom = 8.dp
                )
        )
        Text(
            text = second,
            fontSize = 16.sp,
            modifier = Modifier
            )
    }
}


@Preview(showBackground = true)
@Composable
fun TaskCompletePreview() {
    AdministradorDeTareasTheme {
        TaskCompleteImage(
            stringResource(id = R.string.title),
            stringResource(id = R.string.second_mess)
        )
    }
}
```


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Practice_composeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
//                    BasicPracticeComposite(message = stringResource(id = R.string.title_app))
                    BasicPracticeImage(
                        message = stringResource(id = R.string.title_app),
                        second = stringResource(id = R.string.second_title),
                        third = stringResource(id = R.string.third_title))
                }
            }
        }
    }
}

@Composable
fun BasicPracticeImage(message: String, second: String, third: String, modifier: Modifier= Modifier) {
    val image = painterResource(id = R.drawable.bg_compose_background)
    Box {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Fit)
    }
    BasicPracticeComposite(message = message, second = second, third = third)
}

@Composable
fun BasicPracticeComposite(message: String, second: String, third: String, modifier: Modifier = Modifier) {
    Column (
        modifier = modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = message,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(
                    top = 130.dp,
                    end = 16.dp,
                    start = 16.dp,
                    bottom = 16.dp
                )
                .align(alignment = Alignment.Start),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = second,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    end = 16.dp)
        )
        Text(
            text = third,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 16.dp,
                    top = 16.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun BasicPracticeCompositePreview() {
    Practice_composeTheme {
        BasicPracticeComposite(
            stringResource(id = R.string.title_app),
            stringResource(id = R.string.second_title),
            stringResource(id = R.string.third_title)
        )
    }
}


package com.example.administradordetareas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.expandHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.administradordetareas.ui.theme.AdministradorDeTareasTheme

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
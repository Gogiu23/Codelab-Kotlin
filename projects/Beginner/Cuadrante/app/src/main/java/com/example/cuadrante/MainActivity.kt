package com.example.cuadrante

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cuadrante.ui.theme.CuadranteTheme

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
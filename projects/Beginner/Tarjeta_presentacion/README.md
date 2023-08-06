```kotlin
package com.example.tarjeta_de_present

import android.graphics.Paint.Align
import android.os.Build
import android.os.Bundle
import android.view.RoundedCorner
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.tarjeta_de_present.ui.theme.Tarjeta_de_presentTheme
import java.security.AllPermission
import javax.xml.transform.SourceLocator

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Tarjeta_de_presentTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier,
                ) {
                    PictureStart(modifier = Modifier)
                    TarjetaImg("Giulian",
                        modifier = Modifier
                    )
                    TarjetaInferior(name = "Hola",
                        modifier = Modifier)
                }
            }
        }
    }
}

@Composable
fun PictureStart(modifier: Modifier = Modifier){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.linearGradient(listOf(Color(0xFF0FE4AD), Color(0xFF112277)))),
//            //.border(3.dp, Color.Yellow),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .fillMaxHeight(0.3f)
                //.border(3.dp, Color.Red)
        ) {
            TarjetaPrimeraImagen(
                name = "Android Developer",
                second = "Giuliano Dominici",
                modifier = Modifier
            )
        }
    }
}

@Composable
fun TarjetaImg(name: String, modifier: Modifier = Modifier) {
    Column (modifier = Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Box(modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .padding(top = 140.dp)
        ) {
            val image =
                painterResource(id = R.drawable.captura_de_pantalla_2023_08_05_a_las_2_20_00_modified)
            Image(painter = image, contentDescription = null, contentScale = ContentScale.Fit)
        }
    }
}

@Composable
fun TarjetaInferior(name: String, modifier: Modifier = Modifier){
    Column (modifier = Modifier
        .fillMaxSize()
        .padding(bottom = 10.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally

    ){
        Box(modifier = Modifier
            //.border(3.dp, Color.Red)
            .fillMaxWidth(0.85f)
            .fillMaxHeight(0.2f)
        ){
            TarjetaSegundaImagen(
                name = "none",
                modifier = Modifier
            )
        }
    }
}
@Composable
fun TarjetaSegundaImagen(name: String, modifier: Modifier = Modifier){
   Column(modifier = Modifier
       .fillMaxSize(),
       verticalArrangement = Arrangement.SpaceAround,
       horizontalAlignment = Alignment.CenterHorizontally
   ) {
       Box(modifier = Modifier
           .fillMaxWidth(0.95f)
           .fillMaxHeight(0.35f)
           //.border(3.dp, Color.Cyan)
       ){
           Telefono(name = "(+34)-664050124", modifier = Modifier )
       }
       Box(modifier = Modifier
           .fillMaxWidth(0.95f)
           .fillMaxHeight(0.46f)
           //.border(3.dp, Color.Cyan)
       ){
           Linkedin(name = "linkedin/es/Gogiu23", modifier = Modifier)
       }
       Box(modifier = Modifier
           .fillMaxWidth(0.95f)
           .fillMaxHeight(0.8f)
           //.border(3.dp, Color.Cyan)
       ){
           Email(name = "giuliandominici@gmail.com", modifier = Modifier)
       }
   }
}

@Composable
fun Telefono(name: String, modifier: Modifier = Modifier){
    Row (modifier = Modifier
        .fillMaxSize()
        .border(2.dp, brush = Brush.linearGradient(listOf(Color.Yellow, Color.Cyan)), shape = RoundedCornerShape(12.dp)),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ){
        Box(modifier = Modifier
            .fillMaxWidth(0.1f)
            .fillMaxHeight(0.5f))
//            //.border(3.dp, Color.Magenta))
        {
            val icon = painterResource(id = R.drawable.baseline_phone_android_black_24dp)
            Icon(painter = icon, contentDescription = null, modifier = Modifier
                .size(30.dp))
        }
        Box(modifier = Modifier
            .fillMaxWidth(0.7f)
            .fillMaxHeight(0.5f))
            //.border(3.dp, Color.Magenta))
        {
           Text(text = name, modifier = Modifier
               .padding(start = 10.dp),
               fontSize = 18.sp,
               fontWeight = FontWeight.Black
           )}
    }
    
}
@Composable
fun Linkedin(name: String, modifier: Modifier = Modifier){
    Row (modifier = Modifier
        .fillMaxSize()
        .border(2.dp, brush = Brush.linearGradient(listOf(Color.Yellow, Color.Cyan)), shape = RoundedCornerShape(12.dp)),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ){
        Box(modifier = Modifier
            .fillMaxWidth(0.1f)
            .fillMaxHeight(0.5f))
            //.border(3.dp, Color.Magenta))
        {
            val icon = painterResource(id = R.drawable.baseline_person_add_black_24dp)
            Icon(painter = icon, contentDescription = null, modifier = Modifier
                .size(30.dp))
        }
        Box(modifier = Modifier
            .fillMaxWidth(0.7f)
            .fillMaxHeight(0.5f)
            //.border(3.dp, Color.Magenta)
        ) {
            Text(text = name, modifier = Modifier
                .padding(start = 10.dp),
                fontSize = 18.sp,
                fontWeight = FontWeight.Black
            )
        }
    }
}
@Composable
fun Email(name: String, modifier: Modifier = Modifier){
    Row (modifier = Modifier
        .fillMaxSize()
        .border(2.dp, brush = Brush.linearGradient(listOf(Color.Yellow, Color.Cyan)), shape = RoundedCornerShape(12.dp)),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ){
        Box(modifier = Modifier
            .fillMaxWidth(0.1f)
            .fillMaxHeight(0.5f))
//            .border(3.dp, Color.Magenta))
        {
            val icon = painterResource(id = R.drawable.baseline_contact_mail_black_24dp)
            Icon(painter = icon,
                contentDescription = null,
                modifier = Modifier
                    .size(30.dp))
        }
        Box(modifier = Modifier
            .fillMaxWidth(0.7f)
            .fillMaxHeight(0.5f))
            //.border(3.dp, Color.Magenta))
        {
            Text(text = name, modifier = Modifier
                .padding(start = 10.dp),
                fontSize = 18.sp,
                fontWeight = FontWeight.Black
            )}
    }
}

@Composable
fun TarjetaPrimeraImagen(name: String, second: String, modifier: Modifier = Modifier){
    Column (modifier = Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Box(modifier = Modifier
            .fillMaxWidth(0.5f)
            .fillMaxHeight(0.5f)
            .clip(shape = RoundedCornerShape(size = 20.dp))
            .background(Brush.linearGradient(listOf(Color(0xFF25ECDA), Color(0xFF154360))))
            .clickable { },
            //.border(3.dp, Color.Cyan),
            contentAlignment = Alignment.Center
        ){
            val image = painterResource(id = R.drawable.android_logo)
            Image(painter = image,
                contentDescription = null,
                contentScale = ContentScale.Fit)
        }
        Box(modifier = Modifier
            .fillMaxWidth(0.95f)
            .fillMaxHeight(0.4f)
            .border(3.dp, brush = Brush.linearGradient(listOf(Color.Cyan, Color.Yellow)), shape = RoundedCornerShape(30.dp)),
            contentAlignment = Alignment.Center
        )
        {
            Text(text = second, modifier = Modifier, fontSize = 28.sp, fontWeight = FontWeight.Bold)
        }
        Box(modifier = Modifier
            .fillMaxWidth(0.95f)
            .fillMaxHeight(0.5f),
            //.border(3.dp, Color.Cyan),
            contentAlignment = Alignment.Center
        )
        {
            Text(text = name, modifier = Modifier, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        }
    }
}
```

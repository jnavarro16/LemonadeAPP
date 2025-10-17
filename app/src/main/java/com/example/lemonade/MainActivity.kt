package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                    LemonadeApp()

                }
            }
        }
    }

@Preview
@Composable
fun LemonadeApp()
{
    // A surface container using the 'background' color from the theme
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ){}

    // declaramos variables
    var paso by remember { mutableStateOf(1) }
    var exprimir by remember { mutableStateOf(0) }
    var clicks by remember { mutableStateOf(0) }

    // imagen que se mostraran segun el paso
    val imageResource = when (paso)
    {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }

    // se mostrara un texto/titulo segun el paso
    val titulo = when (paso)
    {
        1 -> R.string.Descripcion1
        2 -> R.string.Descripcion2
        3 -> R.string.Descripcion3
        else -> R.string.Descripcion4
    }

    // descripcion que tendra que hacer el usuario dependiendo el paso
    val descripcion = when (paso)
    {
        1 -> R.string.Paso1
        2 -> R.string.Paso2
        3 -> R.string.Paso3
        else -> R.string.Paso4
    }

    //interfaz
    Column (horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize())
    {
        Text(
            text = stringResource(titulo),
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.padding(16.dp))

        Image(
            painter = painterResource(imageResource),
            contentDescription = stringResource(descripcion),
            modifier = Modifier
                .wrapContentSize()
                .clickable
                {
                    when (paso)
                    {
                        1 -> {
                            paso = 2
                            exprimir = (2..4).random()
                            clicks = 0
                        }
                        2 -> {
                            clicks++
                            if (clicks == exprimir)
                            {
                                paso = 3
                            }
                        }
                        3 -> {
                            paso = 4
                        }
                        4 -> {
                            paso = 1
                        }
                    }
                }
        )
    }
}


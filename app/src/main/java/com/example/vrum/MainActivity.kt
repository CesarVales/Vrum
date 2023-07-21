package com.example.vrum

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vrum.ui.theme.VrumTheme
import okhttp3.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import java.io.File
import java.io.IOException
import java.util.Properties


class x :Callback{
         override fun onFailure(call: Call, e: IOException) {
             println("ERRO NA API")
         }

         override fun onResponse(call: Call, response: Response) {
             println(response.body.toString())
         }
    }
fun chamadaApi(callback: Callback) {
    val client = OkHttpClient()
    val rootDir = File(".")
    val localPropertiesFile = File(rootDir, "local.properties")
    val properties = Properties().apply {
        load(localPropertiesFile.inputStream())
    }
    val apiKey = properties.getProperty("API_KEY")
    val TOKEN = properties.getProperty("TOKEN")

    val request = Request.Builder()

        .url("https://api.themoviedb.org/3/discover/movie")
        .get()
        .addHeader("accept", "application/json")
        .addHeader("Authorization", "Bearer $TOKEN")
        .build()
    /*Chamada utilizando Classe anonima*/
    client.newCall(request).enqueue(object :Callback{
        override fun onFailure(call: Call, e: IOException) {
            println("ERRO NA API")
        }

        override fun onResponse(call: Call, response: Response) {
            println(response.body.toString())
        }
    })
    /* Chamada Utilizando a Classe instanciada*/
    client.newCall(request).enqueue(x())
}

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            VrumTheme {
                // A surface container using the 'background' color from the theme
                Surface(

                    tonalElevation= 2f.dp,


                    modifier = Modifier.alpha(0.8f),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
                Box {

                    Modifier.align(androidx.compose.ui.Alignment.Center).fillMaxSize().width(200.dp)
                    Image(painter = painterResource(R.drawable.logo_chumbinho), contentDescription = null, contentScale = ContentScale.Crop)
                }
            }

            Column(content = {
                Text(text = "sdsdsd")



                    Text(text = "sdsdsd", fontSize = 42.sp)


                Text(text = "sdsdsd")
                Text(text = "sdsdsd")

            })
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val client = OkHttpClient()

    val request = Request.Builder()
        .url("https://api.themoviedb.org/3/account/20163417/rated/movies")
        .get()
        .addHeader("accept", "application/json")
        .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJiMTRmNGY2ODZlNDM3NzFkOWIwYTBiMzAyODJkN2EyZCIsInN1YiI6IjY0YjVhYmYwMTIxOTdlMDBlMjBjNTQyMiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.x0pZpSCOPVAWLnp_1QwIDMyhFnZD2ghWp1MnbmLIOwQ")
        .build()

   /* var response :Response?  = runBlocking {
        OkHttpClient().newCall(request).execute()
    }
    */
    Text(
        text = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA",
        modifier = modifier,
        fontSize = 36.sp

    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    VrumTheme {
        Greeting("Android")
    }
}


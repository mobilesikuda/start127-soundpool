package com.example.start127_soundpool

import android.media.AudioAttributes
import android.media.SoundPool
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.start127_soundpool.ui.theme.Start127soundpoolTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Start127soundpoolTheme {

                val sp = SoundPool.Builder().build()
                val soundIdExplosion = sp.load(getAssets().openFd("explosion.mp3"), 1);
                
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting( sp, soundIdExplosion)
                }
            }
        }
    }
}

@Composable
fun Greeting(soundPool: SoundPool? = null, soundID: Int = 0, modifier: Modifier = Modifier) {
    Column {
        Text(
            text = "Hello Sound!",
            modifier = modifier
        )
        Button(
            onClick = {
                soundPool?.play( soundID,1f, 1f, 0,0, 1f)
            }) {
            Text(text = "Click Me!")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Start127soundpoolTheme {
        Greeting()
    }
}
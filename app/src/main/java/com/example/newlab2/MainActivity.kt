package com.example.newlab2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontVariation.width
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.newlab2.ui.theme.Newlab2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Newlab2Theme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ImageSlider(
                        imagesWithText = listOf(
                            painterResource(R.drawable.java) to "Java",
                            painterResource(R.drawable.csh) to "C#",
                            painterResource(R.drawable.kotlin) to "Kotelok"
                        ))

                }
            }
        }
    }
}

@Composable
fun ImageSlider(imagesWithText: List<Pair<Painter, String>>) {
    var currentIndex by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Image(
            painter = imagesWithText[currentIndex].first,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 100.dp)
                .size(width = 250.dp, height = 250.dp)
        )

       Column (modifier = Modifier.fillMaxWidth().background(color = Color.Gray),
           verticalArrangement = Arrangement.Center,
           horizontalAlignment = Alignment.CenterHorizontally) {
           Text(
               text = imagesWithText[currentIndex].second,
               modifier = Modifier.padding(vertical = 8.dp)
           )
       }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = {
                currentIndex = (currentIndex - 1 + imagesWithText.size) % imagesWithText.size},
                modifier = Modifier.size(width = 120.dp, height = 45.dp)
            ) {
                Text("Previous")
            }
            Button(onClick = {
                currentIndex = (currentIndex + 1) % imagesWithText.size},
                modifier = Modifier.size(width = 120.dp, height = 45.dp)
            ) {
                Text("Next")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    Newlab2Theme {
        ImageSlider(
            imagesWithText = listOf(
                painterResource(R.drawable.java) to "Java",
                painterResource(R.drawable.csh) to "C#",
                painterResource(R.drawable.kotlin) to "Kotelok"
            ))
    }
}
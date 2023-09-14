package com.example.foodapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodapp.ui.theme.FoodAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainContent()
                }
            }
        }
    }
}

@Composable
fun MainContent() {
    Column(
        modifier = Modifier
            .background(Color.Black)
    ) {
        Image(
            painter = painterResource(id = R.drawable.img),
            contentDescription ="",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
        )
        MainContentInfo()
    }
}

@Composable
fun MainContentInfo(){
   Column(
       modifier = Modifier
           .padding(horizontal = 24.dp)
   ) {
       Text(
           text="Get Started",
           fontSize = 20.sp,
           color=Color.Yellow
       )
       Spacer(modifier = Modifier.height(10.dp))
       Text(
           text="Find the best coffee",
           fontSize = 26.sp,
           color=Color.White
       )
       Spacer(modifier = Modifier.height(10.dp))
       Text(
           text="for you",
           fontSize = 26.sp,
           color=Color.White
       )
   }
}

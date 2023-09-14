package com.example.foodapp

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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
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
                .height(520.dp)
        )
        MainContentInfo()
    }
}

@Composable
fun MainContentInfo(){
   Column(
       modifier = Modifier
           .padding(horizontal = 38.dp, vertical = 20.dp)
   ) {
       Text(
           text="Get Started",
           fontSize = 20.sp,
           color=Color( 0xFFffa500)
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
       Spacer(modifier = Modifier.height(10.dp))
       Row {
           Button(
               onClick = {  },
               shape=RoundedCornerShape(10.dp),
               colors = ButtonDefaults.buttonColors(Color.Black),
               modifier = Modifier


           ) {
               Text(
                   text ="Skip Now",
                   fontSize = 14.sp,
                   color= Color.White

               )
           }
      Row (
          horizontalArrangement = Arrangement.End,
          modifier = Modifier
              .padding(start=100.dp)
      ){
          Button(
              onClick = {  },
              shape=RoundedCornerShape(17.dp),
              colors = ButtonDefaults.buttonColors(Color(0xFFffa500)),
              modifier = Modifier
                  .width(110.dp)
                  .height(50.dp)


          ) {
              Text(
                  text ="Next",

                  )
          }
      }
       }

   }
}

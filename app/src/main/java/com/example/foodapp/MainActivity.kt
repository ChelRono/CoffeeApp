package com.example.foodapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodapp.ui.theme.FoodAppTheme
import kotlinx.coroutines.launch

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

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainContent() {

    val pagerState = rememberPagerState()
    HorizontalPager(state = pagerState,pageCount = 3, pageSize = PageSize.Fill) { page ->
        when(page) {

            0 -> {

                Column(
                    modifier = Modifier
                        .background(Color.Black)

                ) {
                    Image(
                        painter = painterResource(id = R.drawable.img),
                        contentDescription = "",
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier
                            .height(550.dp)
                    )
                    MainContentInfo()

                }
            }
            1 -> {
                PagerTwo()
            }
        }}
}
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainContentInfo(){
   Column(
       modifier = Modifier
           .padding(horizontal = 38.dp, vertical = 20.dp)
   ) {
       Text(
           text="Get Started",
           fontSize = 18.sp,
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
              onClick = {},
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

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun PagerTwo(){
    var text by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

        Column(
            modifier = Modifier
                .fillMaxSize(),
                //.background(Color(0xFFffa500)),


        ) {
            Text(
                text = "Sign Up",
                color=Color.Black,
                fontSize = 23.sp,
                modifier = Modifier
                    .padding( horizontal = 24.dp, vertical = 140.dp)
            )
        }
       Column(
           modifier = Modifier
               .fillMaxSize(),
       ) {
            TextField(
                value = text, onValueChange = { text = it },
                modifier = Modifier
                    .padding(top = 190.dp)
                    .padding(horizontal = 24.dp)
                    .fillMaxWidth(),
                singleLine = true,

                placeholder = {
                    Text(
                        text = "Name",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )}
            )
            Spacer(modifier = Modifier.height(10.dp))
            TextField(
                value = email, onValueChange = { text = it },
                modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .fillMaxWidth(),
                placeholder = {
                    Text(
                        text = "Email",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )}
            )
            Spacer(modifier = Modifier.height(10.dp))
            TextField(
                value = password, onValueChange = { text = it },
                modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .fillMaxWidth(),
                placeholder = {
                    Text(
                        text = "Create Password",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )}
            )
           Spacer(modifier = Modifier.height(40.dp))

           Button(
               onClick = {  },
               shape=RoundedCornerShape(10.dp),
               modifier= Modifier
                   .fillMaxWidth()
                   .padding(horizontal = 24.dp),
               colors = ButtonDefaults.buttonColors(Color.Black)


               ) {
               Text(
                   text = "Sign Up",
                   )
           }
           Spacer(modifier = Modifier.height(10.dp))
           BottomText()
        }
    }
@Composable
fun BottomText(){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier=Modifier
            .padding(horizontal = 70.dp)
    ) {
        Text(
            text = "By signing up you agree to our",
            )
        Text(
            text = "Terms and privacy policy.",
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "or",
        )
    }
}
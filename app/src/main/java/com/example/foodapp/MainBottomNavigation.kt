package com.example.foodapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.teal_700))
            .wrapContentSize(Alignment.Center)
    ) {
        MainContent()
    }
}

@Composable
fun CartScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.teal_700))
            .wrapContentSize(Alignment.Center)
    ) {
        OrderPage()
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen() {
    var text by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .background(Color.Black)
            .fillMaxSize(),
        //.background(Color(0xFFffa500)),


    ) {
        Text(
            text = "Sign Up",
            color=Color(0xFFffa500),
            fontSize = 23.sp,
            modifier = Modifier
                .padding( horizontal = 24.dp, vertical = 110.dp)
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
            shape= RoundedCornerShape(10.dp),
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
            shape= RoundedCornerShape(10.dp),
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
            shape= RoundedCornerShape(10.dp),
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
            shape= RoundedCornerShape(10.dp),
            modifier= Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFFffa500))


        ) {
            Text(
                text = "Sign Up",
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        BottomText()
    }
}







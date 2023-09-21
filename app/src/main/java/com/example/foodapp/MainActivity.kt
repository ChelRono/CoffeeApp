package com.example.foodapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
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

                    MainScreenView()
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainContent() {


                Column(
                    modifier = Modifier
                        .background(Color.Black)
                        .fillMaxSize()

                ) {
                    Image(
                        painter = painterResource(id = R.drawable.img),
                        contentDescription = "",
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier
                            .height(570.dp)
                    )
                    MainContentInfo()

                }
            }

@Composable
fun MainScreenView(){
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigation(navController = navController) }
    ) {paddingValues ->

        NavigationGraph(navController = navController, modifier=Modifier.padding(paddingValues ) )
    }
}

@Composable
fun NavigationGraph(navController: NavHostController,modifier: Modifier=Modifier) {
    NavHost(navController, startDestination = BottomNavItem.Home.screen_route) {
        composable(BottomNavItem.Home.screen_route) {
            HomeScreen()
        }
        composable(BottomNavItem.Cart.screen_route) {
            CartScreen()
        }
        composable(BottomNavItem.Settings.screen_route) {
          SettingsScreen()
        }


    }
}

@Composable
fun BottomNavigation(navController: NavController) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Cart,
        BottomNavItem.Settings

    )
    androidx.compose.material.BottomNavigation(
        backgroundColor = colorResource(id = R.color.black),
        contentColor = Color.Black
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title, tint = Color.White) },

                label = {
                    Text(
                        text = item.title,
                        fontSize = 16.sp,
                        color = Color.White
                    )
                },
                selectedContentColor = Color.Black,
                unselectedContentColor = Color.Black.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == item.screen_route,
                onClick = {
                    navController.navigate(item.screen_route) {

                        navController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(screen_route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Composable
fun MainContentInfo(){
   Column(
       modifier = Modifier
           .padding(horizontal = 38.dp, vertical = 20.dp)
   ) {
       Text(
           text="Coffee&Cookies",
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

      Row (
          horizontalArrangement = Arrangement.End,
          modifier = Modifier
              .padding(start=180.dp)
      ){

      }
       }

   }



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PagerTwo(){
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
                shape=RoundedCornerShape(10.dp),
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
                shape=RoundedCornerShape(10.dp),
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
                shape=RoundedCornerShape(10.dp),
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
            fontSize = 16.sp,
            color = Color.White
            )
        Text(
            text = "Terms and privacy policy.",
            fontSize = 16.sp,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(130.dp))
       Row {
           Text(
               text = "Already have an account?",
               color = Color.White
           )
           Text(
               text = "Login",
               color=Color(0xFFffa500),
           )
       }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderPage(){
    Column(
        modifier = Modifier
            .background(Color.Black)
            .fillMaxWidth()



    ) {
        Row (
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier

        ){
            OutlinedTextField(
                value = "Search for coffee",
                onValueChange = {},
                modifier = Modifier

                    .padding(horizontal = 24.dp, vertical = 38.dp)
                    .background(Color.Black),
                shape= RoundedCornerShape(60.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color.Black,
                    textColor = Color(0xFFffa500),
                    cursorColor = Color(0xFFffa500)
                ),
                trailingIcon = { Icon(Icons.Filled.Search, contentDescription = "",) }
            )
            Image(
                painter = painterResource(R.drawable.img_1),
                contentDescription = "avatar",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(vertical = 38.dp,)
                    .size(54.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.Gray, CircleShape),
            )

        }

        IntroText()

        Spacer(modifier = Modifier.height(30.dp))

        FilterOptions()

        Spacer(modifier = Modifier.height(50.dp))

        MenuLayout()
    }

}

@Composable
fun IntroText(){
    Column (
        modifier=Modifier
            .padding(horizontal = 24.dp)
    ){
        Text(
            text = "Good Morning",
            fontSize = 34.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
            )
        Text(
            text = "Grab your first coffee this morning",
            fontSize = 14.sp,
            color = Color.White
        )
    }
}

@Composable
fun FilterOptions(){
    val list: List<String> = listOf(
        "Espresso",
        "Cappuccino",
        "Latte",
        "Espresso",
        "Cappuccino",
        "Latte",
        "Espresso",
        "Cappuccino",
        "Latte",
    )
    Row (
        modifier = Modifier
            .height(40.dp)
            .fillMaxHeight()
            .padding(horizontal = 24.dp),
    ){
        Button(
            onClick = {},
            shape=RoundedCornerShape(9.dp),
            colors = ButtonDefaults.buttonColors(Color.DarkGray),
            modifier = Modifier.size(width = 130.dp, height = 40.dp)

        ) {
            Image(
                painter = painterResource(id = R.drawable.filter_list) ,
                contentDescription =""
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text ="Filter",
                )
        }
        Spacer(modifier = Modifier.width(24.dp))

        LazyHorizontalGrid(
            rows = GridCells.Fixed(1),
            verticalArrangement = Arrangement.spacedBy(space = 28.dp),
            horizontalArrangement = Arrangement.spacedBy(space = 26.dp),
        ){
            items(list.size) {

                    Spacer(modifier = Modifier.width(26.dp))
                    
                    FilterOptionsButton(title = list[it])

            }
        }
    }

}

@Composable
fun FilterOptionsButton(title :String){
    Button(
        onClick = {},
        shape=RoundedCornerShape(9.dp),
        colors = ButtonDefaults.buttonColors(Color.DarkGray),
        modifier = Modifier
            .size(width = 110.dp, height = 40.dp)

    ) {
        Text(
            text =title,
            )
    }
}

@Composable
fun MenuLayout(){
    val cappuccino = listOf(
        "with milk",
        "with chocolate",
        "with milk",
        "with chocolate",
        "with milk",
        "with chocolate",
    )
    LazyVerticalGrid(
        columns =  GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(space = 20.dp),


            )
        {

            items(cappuccino.size) {



               CardLayout(title = cappuccino[it])

            }

    }


}

@Composable
fun CardLayout(title:String){
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.DarkGray,
        ),
        modifier = Modifier
            .size(width = 230.dp, height = 200.dp)
            .padding(horizontal = 24.dp),
        shape = RoundedCornerShape(22.dp)
    ) {
        Column {
            Image(
                painter = painterResource(id = R.drawable.img_1), 
                contentDescription = "",
                modifier = Modifier
                    .padding(13.dp)

                
                )
            Text(
                text = "Cappuccino",
                modifier = Modifier
                    .padding(horizontal = 24.dp),
                textAlign = TextAlign.Center,
                color = Color.White
            )
            Text(
                text = title,
                modifier = Modifier
                    .padding(horizontal = 24.dp),
                textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 14.sp
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(1.dp)
            ) {
                Text(
                    text = "$4.20",
                    modifier = Modifier
                        .clip(RoundedCornerShape(30.dp))
                        .padding(horizontal = 24.dp),
                    textAlign = TextAlign.Center,
                    color = Color(0xFFffa500)
                )
                Image(
                    painter = painterResource(id = R.drawable.add),
                    contentDescription = "",
                    modifier = Modifier
                        .clip(RoundedCornerShape(30.dp))
                )
            }

        }

    }
}
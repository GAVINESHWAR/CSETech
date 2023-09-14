package com.example.jntuacea

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jntuacea.ui.theme.JntuaCeaTheme
import kotlin.random.Random

// table context deatils list

val year1 = listOf("1","2","3","4")
val sem1 = listOf("1","2")
val subject12 = listOf("Differential Equations and Calculus","Python Programming","Chemistry","Electrical","Electronics","Environmental Science")
val subject11 = listOf("Linear Algebra and Calculus","Engineering drawing","English","Problem solving with c programing","Physics")
val subject21 = listOf("Discrete mathematics and Graph Theory","Digital Systems","OOPS through Java","Human Values","Data Structures","Managerial Economics Financial Analysis")
val subject22 = listOf("Probability and statistical methods","Database Management System","Computer Organization","Operating System","Software Engineering")
val subject31 = listOf("Design and Analysis of Algorithms","Computer Networks","Formal Language and Automation Theory","Open elective","Professional Elective","Intellectual property Rights")
val subject32 = listOf("Compiler Design","Machine Learning","Cryptograph and Network Security","Indian Constitution","Full Stack Development","Open Elective","Professional Elective")
val options= listOf("Subjects","Previous Year Question Paper")



//variables for the year sem subjects and options

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JntuaCeaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainApp()
                }
            }
        }
    }
}
@Composable
fun MainApp(){
    val navController= rememberNavController()
    NavHost(navController = navController, startDestination = "Main_Page", ){
        composable("Main_Page"){
            mainPage(navController=navController)
        }
        composable("Details"){
            details(navController=navController )
        }
        composable("about"){
           Aboutus(navController = navController)
        }
        composable("contact"){
            contact(navController = navController)
        }
    }
}
//Main App Navigation details
//Main page of the app consists oof details of app
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun mainPage(navController: NavController) {
    val context = LocalContext.current
        Scaffold(
            bottomBar = {
                BottomAppBar(
                    backgroundColor = Color.Blue
                ) {
                    BottomNavigationItem(
                        icon = { Icon(imageVector = Icons.Filled.Home, contentDescription = "Home") },
                        label = { Text(
                            text="Home" , color = Color.Black
                        )},
                        selected = true, // Set to true for the active tab
                        onClick = {navController.navigate("Main_Page")}
                    )
                    BottomNavigationItem(
                        icon = { Icon(imageVector = Icons.Default.Search, contentDescription = "Search") },
                        label = { Text(text="Materials" , color = Color.White)},
                        selected = false,
                        onClick = {navController.navigate("Details")}
                    )
                    BottomNavigationItem(
                        icon = { Icon(imageVector = Icons.Default.Person, contentDescription = "Profile") },
                        label = { Text(
                            text="About us" , color = Color.White
                        )},
                        selected = false,
                        onClick = {navController.navigate("about")}
                    )
                    BottomNavigationItem(
                        icon = { Icon(imageVector = Icons.Default.Call, contentDescription = "Contact") },
                        label = { Text(
                            text="Contact us" , color = Color.White
                        )},
                        selected = false,
                        onClick = {navController.navigate("contact")}
                    )
                }
            },
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = "JntuaCea E-Library", color = Color.White , modifier = Modifier)
                    },
                    backgroundColor = Color.Blue
                )
            }
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.b22),
                    contentDescription = " back ground Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxSize()
                        .fillMaxHeight()
                        ,
                    contentScale = ContentScale.Crop
                )
            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    , verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(painter = painterResource(id = R.drawable.avi1), contentDescription = null,
                    modifier = Modifier
                        .size(250.dp, 250.dp)
                        .padding(20.dp, 10.dp, 0.dp, 0.dp)
                        .clip(RoundedCornerShape(35.dp))
                        .clickable {
                            Toast
                                .makeText(context, "JNTUACEA SYMBOL", Toast.LENGTH_SHORT)
                                .show()
                        },
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(10.dp))
                val shadowOffset = Offset(x=4f,y=6f)
                    val color = Color(red = Random.nextInt(256),
                        green = Random.nextInt(256),
                        blue = Random.nextInt(256))
                Text(
                    text = "Computer Science And Engineering",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier,
                    style =
                    TextStyle(
                        fontStyle = FontStyle.Normal,
                        shadow = Shadow(color,shadowOffset,13f)
                    )
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "About App",
                    color = Color.Black,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    style = TextStyle(
                        fontStyle = FontStyle.Normal,
                        shadow = Shadow(color,shadowOffset,10f)
                    )
                )
                Spacer(modifier = Modifier.height(30.dp))

                val b =
                    "Our app is a comprehensive resource for computer science students, providing a vast collection of PDFs for various subjects related to the field. With easy access to the app, students can conveniently browse and study materials covering a wide range of topics, including programming languages, algorithms, data structures, software engineering, and more. In addition to the subject PDFs, our app  also features a dedicated section that offers previous year question papers specifically tailored to the JNTUACEA curriculum. This allows students to familiarize themselves with the exam format, gain insights into the types of questions asked, and practice effectively for their upcoming examinations. By offering a centralized platform for accessing study materials and question papers, our app aims to enhance the learning experience and support students in their academic journey, ultimately helping them achieve success in their computer science studies."
                Text(
                    modifier = Modifier
                        .animateContentSize(),
                    text = b,
                    fontSize = 15.sp,
                    color = Color.White,
                    textAlign = TextAlign.Justify
                )
                Spacer(modifier = Modifier.height(110.dp))
            }
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview1() {
    JntuaCeaTheme(darkTheme = false){
        MainApp()
    }
}

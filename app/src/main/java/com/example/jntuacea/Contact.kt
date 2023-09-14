package com.example.jntuacea

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.input.key.Key.Companion.Home
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.launch

@Composable
fun contact(navController: NavController) {

    val uriHandler = LocalUriHandler.current
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current

    Scaffold(
        bottomBar = {
            BottomAppBar(
                backgroundColor = Color.Blue
            ) {
                BottomNavigationItem(
                    icon = { Icon(imageVector = Icons.Outlined.Home, contentDescription = "Home") },
                    label = {
                        Text(
                            text = "Home", color = White
                        )
                    },
                    selected = false, // Set to true for the active tab
                    onClick = { navController.navigate("Main_Page") }
                )
                BottomNavigationItem(
                    icon = {
                        Icon(imageVector = Icons.Outlined.Search,
                            contentDescription = "Search")
                    },
                    label = { Text(text = "Materials", color = White) },
                    selected = false,
                    onClick = { navController.navigate("Details") }
                )
                BottomNavigationItem(
                    icon = {
                        Icon(imageVector = Icons.Outlined.Person,
                            contentDescription = "Profile")
                    },
                    label = {
                        Text(
                            text = "About us", color = Color.White
                        )
                    },
                    selected = false,
                    onClick = { navController.navigate("about") }
                )
                BottomNavigationItem(
                    icon = {
                        Icon(imageVector = Icons.Filled.Call,
                            contentDescription = "Contact")
                    },
                    label = {
                        Text(
                            text = "Contact us", color = Black
                        )
                    },
                    selected = true,
                    onClick = { navController.navigate("contact") }
                )
            }
        },
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Contact", color = Color.White, modifier = Modifier)
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
                        .fillMaxHeight(),
                    contentScale = ContentScale.Crop
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    val senderEmail = remember {
                        mutableStateOf(TextFieldValue())
                    }
                    val emailSubject = remember {
                        mutableStateOf(TextFieldValue())
                    }
                    val emailBody = remember {
                        mutableStateOf(TextFieldValue())
                    }
                    Text(text="Contact Form", fontWeight = FontWeight.Bold, fontSize = 20.sp, color = Color.Green)
                    Spacer(modifier = Modifier.height(25.dp))
                    // on the below line, we are creating a text field.
                    TextField(
                        // on below line we are specifying
                        // value for our  text field.
                        value = emailSubject.value,
                        // on below line we are adding on value change
                        // for text field.
                        onValueChange = { emailSubject.value = it },
                        label = {
                            Text("Email Subject", color = White)}
                                ,
                        // on below line we are adding modifier to it
                        // and adding padding to it and filling max width
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                            .background(color = Black, shape = MaterialTheme.shapes.medium),

                        // on below line we are adding text style
                        // specifying color and font size to it.

                        // on below line we are
                        // adding single line to it.
                        singleLine = true,
                    )

                    // on below line adding a spacer.
                    Spacer(modifier = Modifier.height(10.dp))

                    // on the below line, we are creating a text field.
                    TextField(
                        // on below line we are specifying
                        // value for our  text field.
                        value = emailBody.value,

                        // on below line we are adding on value
                        // change for text field.
                        onValueChange = { emailBody.value = it },
                                        label = {
                                          Text("Email Body" , color = White)
                                        },

                        // on below line we are adding modifier to it
                        // and adding padding to it and filling max width
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                            .background(color = Black, shape = MaterialTheme.shapes.medium),

                        // on below line we are adding text style
                        // specifying color and font size to it.

                        // on below line we are
                        // adding single line to it.
                        singleLine = true,
                    )

                    // on below line adding a spacer.
                    Spacer(modifier = Modifier.height(20.dp))

                    // on below line adding a
                    // button to send an email
                    Button(onClick = {

                        // on below line we are creating
                        // an intent to send an email
                        val i = Intent(Intent.ACTION_SEND)

                        // on below line we are passing email address,
                        // email subject and email body
                        val emailAddress = arrayOf("codersnexusjntua@gmail.com")
                        i.putExtra(Intent.EXTRA_EMAIL,emailAddress)
                        i.putExtra(Intent.EXTRA_SUBJECT,emailSubject.value.text)
                        i.putExtra(Intent.EXTRA_TEXT,emailBody.value.text)

                        // on below line we are
                        // setting type of intent
                        i.setType("message/rfc822")

                        // on the below line we are starting our activity to open email application.
                        context.startActivity(Intent.createChooser(i,"Choose an Email client : "))

                    }) {
                        // on the below line creating a text for our button.
                        Text(
                            // on below line adding a text ,
                            // padding, color and font size.
                            text = "Send Email",
                            color = White,
                            fontSize = 15.sp
                        )
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(text="OR",fontWeight = FontWeight.Bold, fontSize = 20.sp, color = Color.Green)
                    Spacer(modifier = Modifier.height(20.dp))
                    Button(onClick = {
                        coroutineScope.launch {
                            uriHandler.openUri("https://forms.gle/gdpdaQ6CVSvrnxyA9")
                        }
                    }) {
                        Text(text="Fill Form" , color = White, fontSize = 15.sp)
                    }
            }

        }
    }
}
package com.example.tweetsy.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tweetsy.R
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun LoginScreen(navController: NavController) {
    Column(
        Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(color = Color(android.graphics.Color.parseColor("#FFFFFF"))),
    horizontalAlignment = Alignment.CenterHorizontally)
    {
        Image(painterResource(id = R.drawable.top_background) ,
            contentDescription =null, contentScale = ContentScale.FillBounds )
        Image(painter = painterResource(id = R.drawable.logo ),
            contentDescription = null, modifier = Modifier.height(150.dp)
                )
        Text(text = "Welcome to Compose",
            fontSize = 30.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
            color = Color(android.graphics.Color.parseColor("#7d32a8"))
        )
        var user by rememberSaveable { mutableStateOf("Username") }
        var pass by rememberSaveable { mutableStateOf("Password") }
        var passwordVisible by rememberSaveable() {
            mutableStateOf(false)
        }
        TextField(value = user,{text->user=text}, modifier =
        Modifier
            .fillMaxWidth()
            .height(66.dp)
            .padding(start = 64.dp, end = 64.dp, top = 8.dp, bottom = 8.dp)
            .border(
                1.dp, Color(android.graphics.Color.parseColor("#7d32a8")),
                shape = RoundedCornerShape(50)
            ),
            shape = RoundedCornerShape(50),
            textStyle = TextStyle(textAlign = TextAlign.Center,
                color = Color(android.graphics.Color.parseColor("#7d32a8")),
                fontSize = 14.sp
            ),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
            )
        TextField(value = pass,{text->pass=text}, modifier =
        Modifier
            .fillMaxWidth()
            .height(66.dp)
            .padding(start = 64.dp, end = 64.dp, top = 8.dp, bottom = 8.dp)
            .border(
                1.dp, Color(android.graphics.Color.parseColor("#7d32a8")),
                shape = RoundedCornerShape(50)
            ),
            shape = RoundedCornerShape(50),
            textStyle = TextStyle(textAlign = TextAlign.Center,
                color = Color(android.graphics.Color.parseColor("#7d32a8")),
                fontSize = 14.sp
            ),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            visualTransformation = if(passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        Button(onClick = { navController.navigate("category")}
        ,
            Modifier
                .fillMaxWidth()
                .height(66.dp)
                .padding(
                    start = 64.dp, end = 64.dp, top = 8.dp,
                    bottom = 8.dp
                ),
        colors = ButtonDefaults.buttonColors(
            Color(android.graphics.Color.parseColor("#7d32a8"))
        ) ,
            shape = RoundedCornerShape(50)
        ) {
           Text(text = "Login",
               color = Color.White,
               fontSize = 18.sp,
               fontWeight = FontWeight.Bold
           )
        }
        Text(text = "Don't remember password? click here",
            Modifier.padding(top=8.dp, bottom = 8.dp),
            fontSize = 14.sp,
            color = Color(android.graphics.Color.parseColor("#7d32a8"))
        )
        Row(Modifier.padding(top = 16.dp)) {
            Image(painter = painterResource(id = R.drawable.google), contentDescription ="",Modifier.padding(8.dp) )
            Image(painter = painterResource(id = R.drawable.twitter), contentDescription ="",Modifier.padding(8.dp) )
            Image(painter = painterResource(id = R.drawable.facebook), contentDescription ="",Modifier.padding(8.dp) )
        }
        Image(painter = painterResource(id = R.drawable.bottom_background), contentDescription ="", contentScale = ContentScale.FillBounds )
    }

}



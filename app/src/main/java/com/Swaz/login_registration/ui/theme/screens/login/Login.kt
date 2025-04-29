package com.Swaz.login_registration.ui.theme.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Magenta
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.Swaz.login_registration.R

@Composable

fun Login(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize(),

    )
    {
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        Text(
            text = "Welcome Back",
            color = Color.Black,
            fontSize = 50.sp,
            fontFamily = FontFamily.Serif
        )
        Spacer(modifier = Modifier.height(20.dp))
        Image(
            painter = painterResource(id = R.drawable.cat2),
            contentDescription = "Logo",
            modifier = Modifier
                .size(150.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Already have an Account ",
            color = Color.Black,
            fontSize = 20.sp,
        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = email,
            onValueChange = {email=it},
            label = { Text("Email") },
            singleLine = true,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "Email Icon"

                )
            }
        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = password,
            onValueChange = {password=it},
            label = { Text("Password") },
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "Password Icon"
                )
            }
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {navController.navigate("")},
            modifier = Modifier
                .padding(10.dp),
            shape = RoundedCornerShape(12.dp),
            colors =ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Magenta
            )
        )
        {
            Text(
                "Login" ,
                fontSize = 20.sp ,
                fontWeight = FontWeight.Bold
            )
        }
        TextButton(
            onClick = {navController.navigate("")}
        )
        {
            Text(
                text = "Don't have an account? Register ",
                fontSize = 20.sp
            )
        }



    }
}
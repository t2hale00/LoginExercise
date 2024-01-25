package com.example.loginform

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginform.ui.theme.LoginFormTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginFormTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Login()
                }
            }
        }
    }
}

@Composable
fun Login() {
    var usernameInput: String by remember { mutableStateOf("") }
    var passwordInput: String by remember { mutableStateOf("") }

    //val username = usernameInput.toString()
    //val password = passwordInput.toString()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        Text(
            fontSize = 30.sp,
            text = "Login",
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Left,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 16.dp)
        )
        OutlinedTextField(
            value = usernameInput,
            onValueChange = { usernameInput = it.replace(',', newChar = '.') },
            label = { Text(stringResource(R.string.usernameInput), color = MaterialTheme.colorScheme.primary) },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .height(56.dp),
            trailingIcon = {
                Icon(imageVector = Icons.Default.Email, contentDescription = null)
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Email
            )
        )

        OutlinedTextField(
            value = passwordInput,
            onValueChange = { passwordInput = it.replace(',', newChar = '.') },
            label = { Text(stringResource(R.string.passwordInput), color = MaterialTheme.colorScheme.primary) },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .height(56.dp),
            trailingIcon = {
                Icon(imageVector = Icons.Default.Lock, contentDescription = null)
            },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password
            )
        )

        Button(
            onClick = {
                // Handle login here
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .height(56.dp)
        ) {
            Text(stringResource(R.string.login))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LoginFormTheme {
        Login()
    }
}
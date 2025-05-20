package com.example.mydocs

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mydocs.ui.theme.MyDocsTheme

class SignupScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyDocsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize().padding(WindowInsets.statusBars.asPaddingValues()),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Signup()
                }
            }
        }
    }
}

@Composable
fun Signup() {
    Column {
        var username by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        val context = LocalContext.current
        val intent = Intent(context, DocumentCategories::class.java)
        Text(
            text = "My Docs",
            Modifier.padding(8.dp)
        )
        Text(
            text = "Seja bem-vindo!",
            Modifier.padding(8.dp)
        )
        TextField(
            value = username,
            onValueChange = { newValue ->
                username = newValue
            },
            Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            label = {
                Text("Usuário")
            }
        )
        TextField(
            value = password,
            onValueChange = {
                password = it
            },
            Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation(),
            label = {
                Text("Senha")
            }
        )
        Button(
            onClick = { context.startActivity(intent) },
            Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Entrar"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignupPreview() {
    MyDocsTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            SignupScreen()
        }
    }
}
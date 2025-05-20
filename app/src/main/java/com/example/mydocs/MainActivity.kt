package com.example.mydocs

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mydocs.ui.theme.MyDocsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyDocsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize().padding(WindowInsets.statusBars.asPaddingValues()),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AuthScreen()
                }
            }
        }
    }
}
@Composable
fun AuthScreen() {
    Column {
        var username by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        val context = LocalContext.current
        val intent = Intent(context, SignupScreen::class.java)
        Text(
            text = "My Docs",
            Modifier.padding(8.dp)
        )
        Text(
            text = stringResource(R.string.welcome),
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
                Text(stringResource(R.string.user))
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
                Text(stringResource(R.string.password))
            }
        )
        Text(
            text = stringResource(R.string.dont_have_account),
            Modifier
                .padding(8.dp)
                .clickable {
                    context.startActivity(intent)
                }
        )
        Button(
            onClick = {/**/ },
            Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = stringResource(R.string.signin)
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun AuthScreenPreview() {
    MyDocsTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            AuthScreen()
        }
    }
}
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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.mydocs.ui.theme.MyDocsTheme

class AddCategoryActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyDocsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize().padding(WindowInsets.statusBars.asPaddingValues()),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AddCategory()
                }
            }
        }
    }
}
@Composable
fun AddCategory() {
    Column(modifier = Modifier.padding(horizontal = 10.dp)) {
        var title by remember { mutableStateOf("") }
        var description by remember { mutableStateOf("") }
        val context = LocalContext.current
        val intent = Intent(context, DocumentCategories::class.java)
        Text(
            text = "My Docs",
            Modifier.padding(8.dp),
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            text = "Preencha os campos para criar uma categoria de documentos.",
            Modifier.padding(8.dp)
        )
        OutlinedTextField(
            value = title,
            onValueChange = { newValue ->
                title = newValue
            },
            Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            label = {
                Text("Categoria")
            }
        )
        OutlinedTextField(
            value = description,
            onValueChange = {
                description = it
            },
            Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            label = {
                Text("Descrição")
            }
        )
        Button(
            onClick = { context.startActivity(intent) },
            Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Criar categoria"
            )
        }
    }
}

package com.example.mydocs

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExposedDropdownMenuDefaults.textFieldColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mydocs.data.DataProvider.category
import com.example.mydocs.ui.theme.MyDocsTheme

class EditCategoryActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyDocsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize().padding(WindowInsets.statusBars.asPaddingValues()),
                    color = MaterialTheme.colorScheme.background
                ) {
                    EditCategory()
                }
            }
        }
    }
}

@Composable
fun EditCategory() {
    Column(modifier = Modifier.padding(horizontal = 10.dp)) {
        var title by remember { mutableStateOf(category.title) }
        var description by remember { mutableStateOf("") }
        val context = LocalContext.current
        val intent = Intent(context, DocumentCategories::class.java)
        val receivedData = intent.getStringExtra("EditId")
        Text(
            text = "My Docs",
            Modifier.padding(8.dp),
            fontWeight = FontWeight.Bold,
            style = typography.titleLarge
        )
        Text(
            text = "Você está editando a categoria ${category.title}.",
            Modifier.padding(8.dp)
        )
        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 8.dp)
                .fillMaxWidth()
                .background(Color.White)
        ) {
            Row{
                Column (
                    modifier = Modifier
                        .padding(horizontal = 10.dp, vertical = 10.dp)
                ) {
                    Text(
                        text = title,
                        style = typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                    Text(text = description)
                }
            }
        }
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
                text = "Salvar edição"
            )
        }
    }
}

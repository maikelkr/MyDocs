package com.example.mydocs

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mydocs.data.DataProvider
import com.example.mydocs.ui.theme.MyDocsTheme

class DocumentCategories : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyDocsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize().padding(WindowInsets.statusBars.asPaddingValues()),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AddDocument()
                }
            }
        }
    }
}
@Composable
fun AddDocument(){
    val context = LocalContext.current
    val intent = Intent(context, AddCategoryActivity::class.java)
    Column (
        horizontalAlignment = Alignment.End
    ){
        Button(
            onClick = {
                context.startActivity(intent)
            },
            Modifier
                .padding(8.dp)
                .width(150.dp)
        ) {
            Text(
                text = stringResource(R.string.add)
            )
        }
        CategoryList()
    }
}
@Composable
fun CategoryList() {
    val categories = remember { DataProvider.categoryList }
    LazyColumn (
        contentPadding = PaddingValues(horizontal = 10.dp, vertical = 8.dp)
    ){
        items(
            items = categories,
            itemContent = {
                CategoryListItem(category = it)
            },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CategoryListPreview() {
    MyDocsTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            AddDocument()
            CategoryList()
        }
    }
}
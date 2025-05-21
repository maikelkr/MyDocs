package com.example.mydocs

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.mydocs.data.Category

@Composable
fun CategoryListItem(category: Category){
    val context = LocalContext.current
    val intent = Intent(context, EditCategoryActivity::class.java).apply{
        putExtra("EditId",category.id)
    }
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),

        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth()
            .background(Color.White),
    ) {
        Row{
            Column (
                modifier = Modifier
                    .padding(horizontal = 10.dp, vertical = 10.dp)
            ) {
                Text(
                    text = category.title,
                    style = typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
                Text(text = category.description)
            }
            Column (

            ) {
                Image(
                    painter = painterResource(id = R.drawable.edit_square_24px),
                    contentDescription = "null",
                    modifier = Modifier
                        .clickable{
                            context.startActivity(intent)
                        }
                        .size(40.dp),
                    colorFilter = ColorFilter.colorMatrix(
                        colorMatrix = ColorMatrix().apply{android.R.color.black}
                    )
                )
            }
        }
    }

}
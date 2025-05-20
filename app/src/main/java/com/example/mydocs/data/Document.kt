package com.example.mydocs.data

data class Document(
    val id: Int,
    val category: Int,
    val name: String,
    val description: String,
    val imageId: Int = 0
)

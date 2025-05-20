package com.example.mydocs.data

object DataProvider {
    val category = Category(
        id = 1,
        title = "Maikel",
        description = "Documentos"
    )
    val categoryList = listOf(
        category,
        Category(
            id = 2,
            title = "Hadassa",
            description = "Documentos"
        ),
    )

}

package com.silver.lessononeexercises.model

import java.io.Serializable

data class ProductEntity(
    val id: Int,
    val name: String,
    val price : String,
    val image : Int,
    val description: String
): Serializable{}
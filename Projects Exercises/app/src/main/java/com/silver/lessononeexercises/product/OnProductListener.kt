package com.silver.lessononeexercises.product

import com.silver.lessononeexercises.model.ProductEntity

interface OnProductListener {
    fun onSendMessage(msg:String)
    fun selectedItemProduct(productEntity: ProductEntity)
    fun renderFirst(productEntity: ProductEntity?)
}
package com.silver.lessononeexercises.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.silver.lessononeexercises.R
import com.silver.lessononeexercises.model.ProductEntity
import kotlinx.android.synthetic.main.card_product.view.*


class ProductAdapter(private  val context: Context, private val products: List<ProductEntity>): BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater = LayoutInflater.from(context)
        val container = inflater.inflate(R.layout.card_product, null)
        val imgProduct = container.findViewById<ImageView>(R.id.iv_product)
        val tvName = container.findViewById<TextView>(R.id.tv_name)
        val tvPrice = container.findViewById<TextView>(R.id.tv_price)

        // Extraer la entidad
        val productEntity = products[position]

        // Asociar la entidad con el XML
        tvName.text = productEntity.name
        tvPrice.text = productEntity.price.toString()
        imgProduct.setImageResource(productEntity.image)

        return container
    }

    override fun getItem(position: Int): Any = products[position]

    override fun getItemId(position: Int): Long = 0

    override fun getCount(): Int = products.size

}
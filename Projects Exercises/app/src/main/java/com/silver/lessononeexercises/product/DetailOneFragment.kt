package com.silver.lessononeexercises.product


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.silver.lessononeexercises.R
import com.silver.lessononeexercises.model.ProductEntity
import kotlinx.android.synthetic.main.fragment_detail_one.*
import java.lang.RuntimeException

/**
 * A simple [Fragment] subclass.
 */
class DetailOneFragment : Fragment() {

    private var listener: OnProductListener?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_one, container, false)
    }

    fun renderProduct(productEntity: ProductEntity){
        val name = productEntity.name
        val price = productEntity.price
        val description  = productEntity.description

        tv_name.text = name
        tv_price.text = price
        tv_description.text = description
        iv_product.setImageResource(productEntity.image)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnProductListener){
            listener = context
        }else{
            throw RuntimeException("$context must implement OnProductListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }
}

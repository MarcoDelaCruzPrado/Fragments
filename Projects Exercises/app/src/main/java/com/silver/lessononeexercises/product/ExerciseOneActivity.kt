package com.silver.lessononeexercises.product

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.silver.lessononeexercises.R
import com.silver.lessononeexercises.model.ProductEntity

class ExerciseOneActivity : AppCompatActivity() , OnProductListener {

    private lateinit var productFragment: BoxOneFragment
    private lateinit var productDetailFragment: DetailOneFragment
    private lateinit var fragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise_one)

        fragmentManager = supportFragmentManager
        productFragment = fragmentManager.findFragmentById(R.id.fg_products) as BoxOneFragment
        productDetailFragment =
            fragmentManager.findFragmentById(R.id.fg_detail_product) as DetailOneFragment
    }

    override fun onSendMessage(msg: String) {
    }

    override fun selectedItemProduct(productEntity: ProductEntity) {
        productDetailFragment.renderProduct(productEntity)
    }

    override fun renderFirst(productEntity: ProductEntity?) {
        productEntity?.let {
            selectedItemProduct(it)
        }
    }
}

package com.silver.lessononeexercises

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.silver.lessononeexercises.contact.ExerciseTwoActivity
import com.silver.lessononeexercises.product.ExerciseOneActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnExerciseOne.setOnClickListener {
            val intent : Intent = Intent(this, ExerciseOneActivity::class.java)
            startActivity(intent)
        }

        btnExerciseTwo.setOnClickListener {
            val intent: Intent = Intent(this, ExerciseTwoActivity::class.java)
            startActivity(intent)
        }
    }
}

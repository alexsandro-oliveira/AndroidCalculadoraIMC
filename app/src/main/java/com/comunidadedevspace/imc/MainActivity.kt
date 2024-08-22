package com.comunidadedevspace.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtWeight = findViewById<TextInputEditText>(R.id.edt_weight)
        val edtHeight = findViewById<TextInputEditText>(R.id.edt_height)

        val btnCalc = findViewById<Button>(R.id.btn_calc)

        btnCalc.setOnClickListener {
            val peso: Float = edtWeight.text.toString().toFloat()
            val altura: Float = edtHeight.text.toString().toFloat()

            val imc = peso / (altura*2)
            println(imc)


        }
    }
}
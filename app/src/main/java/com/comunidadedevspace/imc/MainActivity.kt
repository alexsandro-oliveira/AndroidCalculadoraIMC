package com.comunidadedevspace.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtWeight = findViewById<TextInputEditText>(R.id.edt_weight)
        val edtHeight = findViewById<TextInputEditText>(R.id.edt_height)

        val btnCalc = findViewById<Button>(R.id.btn_calc)

        btnCalc.setOnClickListener {

            val pesoStr: String = edtWeight.text.toString()
            val alturaStr: String = edtHeight.text.toString()

            if (pesoStr == "" || alturaStr == "") {

                Snackbar.make(
                    edtWeight,
                    "Preencha todos os campos",
                    Snackbar.LENGTH_LONG
                ).show()

            } else {
                val peso = pesoStr.toFloat()
                val altura = alturaStr.toFloat()

                val imc = peso / (altura * 2)

                println(imc)
            }


        }
    }
}
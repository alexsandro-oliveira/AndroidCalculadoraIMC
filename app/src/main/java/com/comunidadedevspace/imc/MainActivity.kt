package com.comunidadedevspace.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

const val KEY_NAME = "MainActivity.KEY_INPUT_NAME"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtWeight = findViewById<TextInputEditText>(R.id.edt_weight)
        val edtHeight = findViewById<TextInputEditText>(R.id.edt_height)

        val btnCalc = findViewById<Button>(R.id.btn_calc)

        val inputName = intent.getStringExtra(KEY_NAME).toString()

        val tvName = findViewById<TextView>(R.id.tv_name)

        tvName.text = inputName

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

                val resultImc = peso / (altura * 2)

                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra(KEY_RESULT_IMC, resultImc)
                startActivity(intent)

            }

        }

    }
}
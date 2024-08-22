package com.comunidadedevspace.imc

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val KEY_RESULT_IMC = "ResultActivity.KEY_IMC"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val resultImc = intent.getFloatExtra(KEY_RESULT_IMC, 0f)

        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvClass = findViewById<TextView>(R.id.tv_class)


        val classificacao: String = if (resultImc <= 18.5f) {
            "MAGREZA"
        } else if (resultImc > 18.5f && resultImc < 30f) {
            "NORMAL"
        } else if (resultImc > 30f && resultImc < 40f) {
            "OBESIDADE"
        } else {
            "OBESIDADE GRAVE"
        }

        tvResult.text = resultImc.toString()
        tvClass.text = classificacao
    }
}
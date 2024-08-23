package com.comunidadedevspace.imc

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)


        val edtName = findViewById<TextInputEditText>(R.id.edt_name)
        val btnNext = findViewById<Button>(R.id.btn_next)

        btnNext.setOnClickListener {

            val helloName = edtName.text.toString()

            if (helloName == "") {

                Snackbar.make(
                    edtName,
                    "Preencha seu nome.",
                    Snackbar.LENGTH_LONG
                ).show()

            } else {

                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra(KEY_NAME, helloName)
                startActivity(intent)
            }

        }

    }
}
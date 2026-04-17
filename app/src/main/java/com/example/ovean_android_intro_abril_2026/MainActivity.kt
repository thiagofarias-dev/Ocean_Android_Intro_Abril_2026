package com.example.ovean_android_intro_abril_2026

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btEnviar = findViewById<Button>(R.id.btEnviar)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)
        val etNome = findViewById<EditText>(R.id.etNome)
        val btAbrirNovaTela = findViewById<Button>(R.id.btAbrirNovaTela)
        val btLimpar = findViewById<Button>(R.id.btLimpar)

        btEnviar.setOnClickListener {
            val nome = etNome.text.toString()

            if (nome.isBlank()) {
                etNome.error = getString(R.string.o_nome_n_o_pode_estar_vazio)
                etNome.requestFocus()
            } else {
                etNome.error = null
                tvResultado.text = getString(R.string.boas_vindas, nome)
            }
////            val novaTelaIntent = Intent(this, ResultadoActivity::class.java)
////            startActivity(novaTelaIntent)

        }

        btAbrirNovaTela.setOnClickListener {
            val nome = etNome.text.toString()
            val resultadoActivityIntent = Intent(this, ResultadoActivity::class.java)
            resultadoActivityIntent.putExtra(getString(R.string.key_resultado), nome)
            startActivity(resultadoActivityIntent)
        }

        btLimpar.setOnClickListener {
            etNome.text.clear()
            etNome.error = null
            tvResultado.text = getString(R.string.hello_world)
        }


    }
}
package br.edu.ifsp.dmo1.pesquisadeopinio.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import br.edu.ifsp.dmo1.pesquisadeopinio.databinding.ActivityMainBinding
import br.edu.ifsp.dmo1.pesquisadeopinio.ui.comprovante.ComprovanteActivity
import br.edu.ifsp.dmo1.pesquisadeopinio.ui.form.FormActivity
import br.edu.ifsp.dmo1.pesquisadeopinio.ui.resultado.ResultActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListeners()
    }

    private fun setupListeners() {
        binding.participarPesquisa.setOnClickListener{
           val intent = Intent(this, FormActivity::class.java)
            startActivity(intent)
        }

        binding.checarVoto.setOnClickListener{
            val intent = Intent(this, ComprovanteActivity::class.java)
            startActivity(intent)
        }

        binding.finalizar.setOnClickListener{
            val intent = Intent(this, ResultActivity::class.java)
            startActivity(intent)
        }
    }


}
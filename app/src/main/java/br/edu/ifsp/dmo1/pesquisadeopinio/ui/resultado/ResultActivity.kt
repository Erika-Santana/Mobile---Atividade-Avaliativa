package br.edu.ifsp.dmo1.pesquisadeopinio.ui.resultado

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import br.edu.ifsp.dmo1.pesquisadeopinio.databinding.ActivityPesquisaBinding
import br.edu.ifsp.dmo1.pesquisadeopinio.databinding.ActivityResultBinding

class ResultActivity: AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding
    private lateinit var viewModel: ResultViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this)[ResultViewModel::class.java]

        setupObservers()


    }

    private fun setupObservers() {
        viewModel.o
    }


}
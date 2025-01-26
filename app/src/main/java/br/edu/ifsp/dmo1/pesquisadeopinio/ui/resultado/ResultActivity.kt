package br.edu.ifsp.dmo1.pesquisadeopinio.ui.resultado

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.edu.ifsp.dmo1.pesquisadeopinio.databinding.ActivityResultBinding
import br.edu.ifsp.dmo1.pesquisadeopinio.ui.form.FormViewModel

class ResultActivity: AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding
    private lateinit var viewModel: ResultViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this).get(ResultViewModel::class.java)

        setupObservers()
    }

    private fun setupObservers() {
        viewModel.votes.observe(this, Observer {
            contagem -> binding.numeroParticipantes.text = "${contagem}"
        })

        viewModel.votesRuim.observe(this, Observer {
            contagem -> binding.numeroRuim.text = "${contagem}"
        })
        viewModel.votesBom.observe(this, Observer {
                contagem -> binding.numeroBom.text = "${contagem}"
        })
        viewModel.votesOtimo.observe(this, Observer {
                contagem -> binding.numeroOtimo.text = "${contagem}"
        })
        viewModel.votesRegular.observe(this, Observer {
                contagem -> binding.numeroRegular.text = "${contagem}"
        })
    }


}
package br.edu.ifsp.dmo1.pesquisadeopinio.ui.pesquisa

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.dmo1.pesquisadeopinio.databinding.ActivityPesquisaBinding
import br.edu.ifsp.dmo1.pesquisadeopinio.ui.votos.VoteActivity

class PesquisaActivity: AppCompatActivity() {

    private lateinit var binding: ActivityPesquisaBinding
    private lateinit var viewModel: PesquisaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityPesquisaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)

        setupListeners()
    }

    private fun setupListeners() {
        binding.voto.setOnClickListener{
            var getVoteRadio = binding.radioGroup.checkedRadioButtonId.toString()
            viewModel.setVote(getVoteRadio)
            var intent = Intent(this, VoteActivity::class.java )
            startActivity(intent)

        }
    }


}
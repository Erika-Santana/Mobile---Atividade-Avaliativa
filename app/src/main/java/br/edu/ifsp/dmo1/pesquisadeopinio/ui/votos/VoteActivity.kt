package br.edu.ifsp.dmo1.pesquisadeopinio.ui.votos

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import br.edu.ifsp.dmo1.pesquisadeopinio.databinding.ActivityVoteBinding


class VoteActivity: AppCompatActivity() {

    private lateinit var binding: ActivityVoteBinding
    private lateinit var viewModel: VoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityVoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[VoteViewModel::class.java]

        openExtras()
        setupObserver()
    }

    private fun openExtras() {
       val dado = intent.getStringExtra("voteType")
        if (dado != null) {
            viewModel.setVote(dado)
        }else{
            Toast.makeText(this, "Error ao salvar voto.", Toast.LENGTH_SHORT).show()
        }

    }

    private fun setupObserver() {
        viewModel.lastVote.observe(this){
         voto -> if (voto != null){
            binding.typeVote.text = voto.getType().toString()
            binding.codigoComprovanteVoto.text  = voto.getComprovante()
        }else{

            Toast.makeText(this, "Nenhum voto foi registrado.", Toast.LENGTH_SHORT).show()}
        }

    }

}
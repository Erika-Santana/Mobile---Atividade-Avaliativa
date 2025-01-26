package br.edu.ifsp.dmo1.pesquisadeopinio.ui.votos

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.edu.ifsp.dmo1.pesquisadeopinio.databinding.ActivityVoteBinding
import br.edu.ifsp.dmo1.pesquisadeopinio.ui.pesquisa.PesquisaViewModel

class VoteActivity: AppCompatActivity() {

    private lateinit var binding: ActivityVoteBinding
    private lateinit var viewModel: PesquisaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityVoteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this)[PesquisaViewModel::class.java]

        //observador
        setupObserver()
    }

    private fun setupObserver() {
        viewModel.liveData.observe(this){
            voto -> if (voto != null){
            binding.typeVote.text = voto.getType().toString()
            binding.codigoComprovanteVoto.text  = voto.getComprovante()
        }else{
            Toast.makeText(this, "No liveData não existe voto!", Toast.LENGTH_SHORT).show()            }
        }

    }

}
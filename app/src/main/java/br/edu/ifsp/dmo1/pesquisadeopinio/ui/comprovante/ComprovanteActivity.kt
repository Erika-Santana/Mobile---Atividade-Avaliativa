package br.edu.ifsp.dmo1.pesquisadeopinio.ui.comprovante

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import br.edu.ifsp.dmo1.pesquisadeopinio.databinding.ActivityComprovanteBinding
import br.edu.ifsp.dmo1.pesquisadeopinio.ui.votos.VoteActivity

class ComprovanteActivity :AppCompatActivity() {

    private lateinit var binding: ActivityComprovanteBinding
    private lateinit var viewModel: ComprovanteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComprovanteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(ComprovanteViewModel::class.java)

        setupListeners()
    }

    private fun setupListeners() {

        binding.buttonOk.setOnClickListener{

            var comprovante = binding.comprovanteUser.toString()

            if (viewModel.doesVoteExists(comprovante)){
                val intent = Intent(this, VoteActivity::class.java)
                /*Preciso salvar o comprovante??*/
                startActivity(intent)
            }else{
                Toast.makeText(this, "Comprovante inválido! Por favor insira um veridico ou faça o registro para votar.", Toast.LENGTH_SHORT)
            }
        }

    }


}
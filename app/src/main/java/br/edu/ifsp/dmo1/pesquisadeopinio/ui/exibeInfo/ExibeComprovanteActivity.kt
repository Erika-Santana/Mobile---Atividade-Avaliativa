package br.edu.ifsp.dmo1.pesquisadeopinio.ui.exibeInfo

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import br.edu.ifsp.dmo1.pesquisadeopinio.databinding.ActivityExibeComprovanteBinding

class ExibeComprovanteActivity:AppCompatActivity() {

    private lateinit var binding: ActivityExibeComprovanteBinding
    private lateinit var viewModel: ExibeComprovanteViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExibeComprovanteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(ExibeComprovanteViewModel::class.java)

        openBundle()
    }

    private fun openBundle() {
        var comprovante = intent.getStringExtra("Comprovante")
        if (comprovante != null){
            var type = viewModel.getVoteInformations(comprovante)
            Toast.makeText(this, "Tipo ${type}", Toast.LENGTH_SHORT).show()
            binding.textoComprovante.text = comprovante
            binding.textoVoto.text = type
        }else{
            Toast.makeText(this, "Erro pegar o comprovante", Toast.LENGTH_SHORT).show()
        }
    }
}
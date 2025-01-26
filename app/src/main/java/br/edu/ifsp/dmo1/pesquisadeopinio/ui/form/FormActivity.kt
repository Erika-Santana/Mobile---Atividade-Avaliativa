package br.edu.ifsp.dmo1.pesquisadeopinio.ui.form

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import br.edu.ifsp.dmo1.pesquisadeopinio.databinding.ActivityFormBinding
import br.edu.ifsp.dmo1.pesquisadeopinio.ui.pesquisa.PesquisaActivity
import br.edu.ifsp.dmo1.pesquisadeopinio.ui.votos.VoteActivity

/*Classe responsável por realizar o Login do usuário*/
class FormActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFormBinding
    private lateinit var viewModel : FormViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityFormBinding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FormViewModel::class.java)

        setupListener()
    }

    private fun setupListener() {
        binding.buttonCadastro.setOnClickListener {
            var nome = binding.editNome.text.toString().trim()
            var prontuario = binding.editProntuario.text.toString().trim()
            if (viewModel.checkUser(prontuario)){
                var usuario = viewModel.getNameUser(prontuario)
                Toast.makeText(this, "Usuário ${usuario} já votou!", Toast.LENGTH_SHORT).show()
            }else{
                var boolean = viewModel.insereUser(prontuario, nome)

                if (boolean) {
                    val intent = Intent(this, PesquisaActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(
                        this,
                        "Erro ao realizar o cadastro! Tente novamente.",
                        Toast.LENGTH_SHORT
                    )
                }
            }

        }
    }
}
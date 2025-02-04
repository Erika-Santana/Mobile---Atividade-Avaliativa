package br.edu.ifsp.dmo1.pesquisadeopinio.ui.pesquisa

import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import br.edu.ifsp.dmo1.pesquisadeopinio.databinding.ActivityPesquisaBinding
import br.edu.ifsp.dmo1.pesquisadeopinio.ui.votos.VoteActivity

class PesquisaActivity: AppCompatActivity() {

    private lateinit var binding: ActivityPesquisaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityPesquisaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)

        setupListeners()
    }

    private fun setupListeners() {
        binding.voto.setOnClickListener{
            var checkedButton : String = ""
            var idRadioGroup = binding.radioGroup.checkedRadioButtonId

            if (idRadioGroup != -1){
                var valorSelecionado = findViewById<RadioButton>(idRadioGroup)

                checkedButton = when(valorSelecionado.id){
                    binding.radioBom.id -> "BOM"
                    binding.radioRuim.id -> "RUIM"
                    binding.radioRegular.id -> "REGULAR"
                    binding.radioOtimo.id -> "OTIMO"
                    else -> ""

                }
            }

            var intent = Intent(this, VoteActivity::class.java )
            if (checkedButton.equals("")){
                Toast.makeText(this, "Por favor selecione uma opção!", Toast.LENGTH_SHORT).show()
            }else{
                intent.putExtra("voteType", checkedButton)
                startActivity(intent)
                finish()
            }


        }
    }


}
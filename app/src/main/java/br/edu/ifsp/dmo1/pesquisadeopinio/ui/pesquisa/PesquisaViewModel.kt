package br.edu.ifsp.dmo1.pesquisadeopinio.ui.pesquisa

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.edu.ifsp.dmo1.pesquisadeopinio.data.model.Votes
import br.edu.ifsp.dmo1.pesquisadeopinio.data.model.VotesType
import br.edu.ifsp.dmo1.pesquisadeopinio.data.repository.VotesRepository

class PesquisaViewModel(application: Application) : AndroidViewModel(application)  {

    private var database : VotesRepository

    /*Guarda o ultimo voto inserido no banco*/
    private val _lastVote = MutableLiveData<Votes>()
    val liveData: LiveData<Votes> get() = _lastVote

    init {
        database = VotesRepository(application)
    }

    fun setVote(vote : String) {

        val voteType = when (vote) {
            "radio_bom" -> VotesType.BOM
            "radio_regular" -> VotesType.REGULAR
            "radio_ruim" -> VotesType.RUIM
            "radio_otimo" -> VotesType.OTIMO
            else -> throw IllegalArgumentException("Tipo inválido!")
        }

        val voto = Votes(voteType)
        database.addMyVote(voto)
        _lastVote.value = voto
    }

}
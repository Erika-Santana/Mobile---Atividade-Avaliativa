package br.edu.ifsp.dmo1.pesquisadeopinio.ui.votos

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.edu.ifsp.dmo1.pesquisadeopinio.data.model.Votes
import br.edu.ifsp.dmo1.pesquisadeopinio.data.model.VotesType
import br.edu.ifsp.dmo1.pesquisadeopinio.data.repository.UserRepository
import br.edu.ifsp.dmo1.pesquisadeopinio.data.repository.VotesRepository

class VoteViewModel (application: Application) : AndroidViewModel(application){

    private lateinit var database : VotesRepository

    /*Guarda o ultimo voto inserido no banco*/
    private val _lastVote = MutableLiveData<Votes>()
    val lastVote: LiveData<Votes> get() = _lastVote


    init {
        database = VotesRepository(application)

    }

    fun setVote(vote : String) {

        val voteType = when (vote) {
            "BOM" -> VotesType.BOM
            "REGULAR" -> VotesType.REGULAR
            "RUIM" -> VotesType.RUIM
            "OTIMO" -> VotesType.OTIMO
            else -> throw IllegalArgumentException("Tipo inválido!")
        }

        val voto = Votes(voteType)
        database.addMyVote(voto)
        _lastVote.value = voto

    }
}
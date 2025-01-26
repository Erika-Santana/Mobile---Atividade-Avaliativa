package br.edu.ifsp.dmo1.pesquisadeopinio.ui.resultado

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.edu.ifsp.dmo1.pesquisadeopinio.data.model.Votes
import br.edu.ifsp.dmo1.pesquisadeopinio.data.repository.VotesRepository

class ResultViewModel (application: Application) : AndroidViewModel(application){

    /*Live Data para atualização dos dados da tela*/
    private val database: VotesRepository = VotesRepository(application)

    private val _votes = MutableLiveData<List<Votes>>()
    val votes: LiveData<List<Votes>> get() = _votes

    init {
        _votes.value = database.getAllVotes()
    }
}
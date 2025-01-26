package br.edu.ifsp.dmo1.pesquisadeopinio.ui.exibeInfo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import br.edu.ifsp.dmo1.pesquisadeopinio.data.repository.VotesRepository

class ExibeComprovanteViewModel(application: Application) : AndroidViewModel(application) {

    private var database : VotesRepository

    init {
        database = VotesRepository(application)
    }

    fun getVoteInformations(comprovante: String): String{
       var type =  database.getTypeVoteByCODE(comprovante)
        return type
    }
}
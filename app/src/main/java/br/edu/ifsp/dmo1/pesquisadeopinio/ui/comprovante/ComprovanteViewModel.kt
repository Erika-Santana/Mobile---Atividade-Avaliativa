package br.edu.ifsp.dmo1.pesquisadeopinio.ui.comprovante

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import br.edu.ifsp.dmo1.pesquisadeopinio.data.repository.VotesRepository

class ComprovanteViewModel(application: Application) : AndroidViewModel(application) {
    private var repositoryVote: VotesRepository

    init {
        repositoryVote = VotesRepository(application)
    }

    fun doesVoteExists(vote: String) : Boolean{
        if (repositoryVote.doesVoteExists(vote)){
            return true
        }

        return false

    }

}
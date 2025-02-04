package br.edu.ifsp.dmo1.pesquisadeopinio.ui.resultado

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.edu.ifsp.dmo1.pesquisadeopinio.data.model.VotesType
import br.edu.ifsp.dmo1.pesquisadeopinio.data.repository.VotesRepository

class ResultViewModel (application: Application) : AndroidViewModel(application){


    private val database: VotesRepository = VotesRepository(application)

    /*Live Data para atualização dos dados da totais tela*/
    private val _votesTotals = MutableLiveData<Int>()
    val votes: LiveData<Int> = _votesTotals

    /*Live Data para atualização dos dados do totais da opção BOM tela*/
    private val _votesTotalsBom = MutableLiveData<Int>()
    val votesBom: LiveData<Int> = _votesTotalsBom

    /*Live Data para atualização dos dados do totais da opção RUIM tela*/
    private val _votesTotalsRuim = MutableLiveData<Int>()
    val votesRuim: LiveData<Int> = _votesTotalsRuim

    /*Live Data para atualização dos dados do totais da opção OTIMO tela*/
    private val _votesTotalsOtimo = MutableLiveData<Int>()
    val votesOtimo: LiveData<Int> = _votesTotalsOtimo

    /*Live Data para atualização dos dados do totais da opção REGULAR tela*/
    private val _votesTotalsRegular = MutableLiveData<Int>()
    val votesRegular: LiveData<Int> = _votesTotalsRegular

    init {
        _votesTotals.value = database.getAllVotes()
        _votesTotalsRuim.value = database.countVotesByType(VotesType.RUIM)
        _votesTotalsOtimo.value = database.countVotesByType(VotesType.OTIMO)
        _votesTotalsRegular.value = database.countVotesByType(VotesType.REGULAR)
        _votesTotalsBom.value = database.countVotesByType(VotesType.BOM)

    }


}
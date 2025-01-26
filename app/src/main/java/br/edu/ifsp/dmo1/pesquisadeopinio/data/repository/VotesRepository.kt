package br.edu.ifsp.dmo1.pesquisadeopinio.data.repository

import android.content.Context
import br.edu.ifsp.dmo1.pesquisadeopinio.data.database.DatabaseHelper
import br.edu.ifsp.dmo1.pesquisadeopinio.data.database.VoteDAO
import br.edu.ifsp.dmo1.pesquisadeopinio.data.model.Votes

class VotesRepository(context: Context) {

    private val databaseHelper = DatabaseHelper(context)
    private val dao = VoteDAO(databaseHelper)

    fun getAllVotes(): Int = dao.countVotes()

    fun addMyVote(vote: Votes) = dao.insert(vote)

    fun doesVoteExists(vote: String) :Boolean = dao.doesVoteExists(vote)


}
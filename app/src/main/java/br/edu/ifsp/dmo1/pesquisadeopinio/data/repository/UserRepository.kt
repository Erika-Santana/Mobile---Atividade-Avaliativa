package br.edu.ifsp.dmo1.pesquisadeopinio.data.repository

import android.content.Context
import br.edu.ifsp.dmo1.pesquisadeopinio.data.database.DatabaseHelper
import br.edu.ifsp.dmo1.pesquisadeopinio.data.database.UserDAO
import br.edu.ifsp.dmo1.pesquisadeopinio.data.model.User

class UserRepository(context: Context) {

    private val databaseHelper = DatabaseHelper(context)
    private val dao = UserDAO(databaseHelper)

    fun addUser(user: User) = dao.insert(user)

    fun doesExists(prontuario:String ) = dao.doesUserExists(prontuario)


}
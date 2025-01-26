package br.edu.ifsp.dmo1.pesquisadeopinio.ui.form

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import br.edu.ifsp.dmo1.pesquisadeopinio.data.model.User
import br.edu.ifsp.dmo1.pesquisadeopinio.data.repository.UserRepository

class FormViewModel(application: Application) : AndroidViewModel(application){

    private lateinit var database : UserRepository

    init{
        database = UserRepository(application)
    }
    fun insereUser( prontuarioValor: String, nome: String): Boolean{
        val user =  User(prontuarioValor, nome)
       if (database.addUser(user) ){
           return true
       }
        return false
    }

    fun checkUser(prontuario: String): Boolean{
       return database.doesExists(prontuario)
    }

    fun getNameUser(prontuario:String): String = database.getUser(prontuario)
}
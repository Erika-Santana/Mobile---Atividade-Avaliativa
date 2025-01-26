package br.edu.ifsp.dmo1.pesquisadeopinio.data.model

class User( private val prontuario : String, private val name: String) {

    fun getProntuario() : String = prontuario
    fun getNome() : String = name

}
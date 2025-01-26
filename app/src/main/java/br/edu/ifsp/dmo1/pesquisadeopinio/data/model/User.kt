package br.edu.ifsp.dmo1.pesquisadeopinio.data.model

class User( val prontuario : String,  val name: String) {

    fun getProntuario() : String = prontuario
    fun getNome() : String = name

}
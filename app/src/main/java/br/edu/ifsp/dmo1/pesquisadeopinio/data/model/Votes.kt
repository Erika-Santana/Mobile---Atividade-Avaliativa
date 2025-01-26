package br.edu.ifsp.dmo1.pesquisadeopinio.data.model

class Votes(val type: VotesType ) {
    private var comprovante: String = ""


    init {
       comprovante =  generateReceipt()
    }

    fun getType(): VotesType {
        return type
    }

    fun generateReceipt(): String{
        val receipt = (1..10).map { (('a'..'z') + ('A'..'Z')).random() }.joinToString("")
        comprovante = receipt
        return comprovante
    }

       fun getComprovante(): String{
            return comprovante
        }
 }
enum class VotesType {
    BOM,
    RUIM,
    REGULAR,
    OTIMO
}
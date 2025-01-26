package br.edu.ifsp.dmo1.pesquisadeopinio.data.database

import android.content.ContentValues
import br.edu.ifsp.dmo1.pesquisadeopinio.data.model.Votes
import br.edu.ifsp.dmo1.pesquisadeopinio.data.model.VotesType

class VoteDAO(private val database: DatabaseHelper) {

    fun insert(vote: Votes){
        var writable = database.writableDatabase
        var valor = ContentValues().apply {
            put(DatabaseHelper.DATABASE_KEYS.COLUMN_ENUM_VOTO, vote.getType().toString())
            put(DatabaseHelper.DATABASE_KEYS.COLUMN_RECEIPT, vote.generateReceipt())
        }

        writable.insert(DatabaseHelper.DATABASE_KEYS.TABLE_NAME_VOTO, null, valor)
    }

    /* Retorna código por usuário*/
    fun getTypeVoteByCODE(code: String) : String{
        var readable = database.readableDatabase
        var columns = arrayOf(DatabaseHelper.DATABASE_KEYS.COLUMN_ENUM_VOTO)
        var where = "${DatabaseHelper.DATABASE_KEYS.COLUMN_RECEIPT} = ?"
        var livroCode = arrayOf(code)

        val cursor = readable.query(DatabaseHelper.DATABASE_KEYS.TABLE_NAME_VOTO, columns, where, livroCode, null, null, null)

        if (cursor.moveToFirst()){
            var resultado = cursor.move(0).toString()
            return resultado
        }

        return ""
    }

    /*Pega todos os votos já feitos*/
    fun countVotes(): Int {
        val readable = database.readableDatabase
        val query = "SELECT COUNT(*) FROM ${DatabaseHelper.DATABASE_KEYS.TABLE_NAME_VOTO}"

        readable.rawQuery(query, null).use { quantidade ->
                return if (quantidade.moveToFirst()){
                quantidade.getInt(0)
            }else{
                return 0
                }
        }

    }

    fun countVotesByType(votesType: VotesType): Int{

        val readable = database.readableDatabase
        val columns = arrayOf(DatabaseHelper.DATABASE_KEYS.COLUMN_RECEIPT)
        val where = "${DatabaseHelper.DATABASE_KEYS.COLUMN_ENUM_VOTO} = ?"

       val whereArgs = arrayOf(votesType.toString())
        val cursor = 0
        readable.query(
            DatabaseHelper.DATABASE_KEYS.TABLE_NAME_VOTO, columns, where, whereArgs, null,null,null ).use { contagem ->  contagem.count }

        return cursor

    }


    fun doesVoteExists(vote: String): Boolean{

        var readable = database.readableDatabase
        var columns = arrayOf(DatabaseHelper.DATABASE_KEYS.COLUMN_RECEIPT)
        var where = "${DatabaseHelper.DATABASE_KEYS.COLUMN_RECEIPT} = ?"
        var livroCode = arrayOf(vote)

        val cursor = readable.query(DatabaseHelper.DATABASE_KEYS.TABLE_NAME_VOTO, columns, where, livroCode, null, null, null)

        val exists = cursor.count > 0
        cursor.close()
        return exists

    }
}
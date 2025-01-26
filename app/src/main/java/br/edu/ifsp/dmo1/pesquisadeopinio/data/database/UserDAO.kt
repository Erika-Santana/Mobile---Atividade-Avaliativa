package br.edu.ifsp.dmo1.pesquisadeopinio.data.database

import android.content.ContentValues
import br.edu.ifsp.dmo1.pesquisadeopinio.data.model.User

/*Implementação das inserções e dos selects do banco de dados*/

class UserDAO(private val database: DatabaseHelper) {

    /*Função de inserção dos dados dos usuários no banco de dados*/
    fun insert(user: User): Boolean {
        //abre instância para inserção dos dados
        val writable = database.writableDatabase
        //guarda a coluna da tabela e qual o dado a ser inserido
        val valores = ContentValues().apply {
            put(DatabaseHelper.DATABASE_KEYS.COLUMN_TEXTO_NOME, user.getNome())
            put(DatabaseHelper.DATABASE_KEYS.COLUMN_TEXTO_PRONTUARIO, user.getProntuario())
        }

        //insere de fato no banco de dados
        writable.insert(DatabaseHelper.DATABASE_KEYS.TABLE_NAME_USER, null, valores)
        return true
    }


    /*Função responsável por pegar todos os dados associados ao user*/
    fun getAllInfoUser() {}

    fun doesUserExists(prontuario: String): Boolean {
        val banco = database.readableDatabase
        val columns = arrayOf(DatabaseHelper.DATABASE_KEYS.COLUMN_TEXTO_PRONTUARIO)
        val whereQuery = "${DatabaseHelper.DATABASE_KEYS.COLUMN_TEXTO_PRONTUARIO} = ?"
        val userProntuario = arrayOf(prontuario)

        banco.query(
            DatabaseHelper.DATABASE_KEYS.TABLE_NAME_USER,
            columns,
            whereQuery,
            userProntuario,
            null,
            null,
            null
        ).use { cursor ->
            return cursor.moveToNext()
        }
    }


    fun getUser(prontuario: String): String {
        val banco = database.readableDatabase
        val column = arrayOf(DatabaseHelper.DATABASE_KEYS.COLUMN_TEXTO_NOME)
        val where = "${DatabaseHelper.DATABASE_KEYS.COLUMN_TEXTO_PRONTUARIO} = ?"
        val userWhere = arrayOf(prontuario)

        val cursor = banco.query(
            DatabaseHelper.DATABASE_KEYS.TABLE_NAME_USER,
            column,
            where,
            userWhere,
            null,
            null,
            null
        )

        cursor.use {
            if (it.moveToNext())
                return it.getString(0)
        }


        return "vazio"
    }

}

//
//    fun getUser(prontuario: String): String{
//        val banco = database.readableDatabase
//        val column = arrayOf(DatabaseHelper.DATABASE_KEYS.COLUMN_TEXTO_NOME)
//        val where = "${DatabaseHelper.DATABASE_KEYS.COLUMN_TEXTO_PRONTUARIO} = ?"
//        val userWhere = arrayOf(prontuario)
//
//        banco.query(DatabaseHelper.DATABASE_KEYS.TABLE_NAME_USER, column, where, userWhere, null, null, null).use{
//            cursor -> cursor.moveToNext()
//            return cursor.getString(0)
//        }
//    }


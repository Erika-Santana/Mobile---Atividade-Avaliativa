package br.edu.ifsp.dmo1.pesquisadeopinio.data.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
/*Classe responsável por fazer a conexão com o banco de dados e também o upgrade quando for necessário,
 definindo as constantes do banco de dados e as querys*/

class DatabaseHelper (context: Context) : SQLiteOpenHelper(context, DATABASE_KEYS.DATABASE_NAME, null, DATABASE_KEYS.DATABASE_VERSION){

    object DATABASE_KEYS{
        const val DATABASE_NAME = "banco_opinioes"
        const val DATABASE_VERSION = 1
        const val TABLE_NAME_USER = "tb_usuario"
        const val TABLE_NAME_VOTO = "tb_voto"
        const val COLUMN_TEXTO_NOME = "nome"
        const val COLUMN_TEXTO_PRONTUARIO = "prontuario"
        const val COLUMN_ENUM_VOTO = "voto"
        const val COLUMN_RECEIPT = "comprovante"
    }

    private companion object{
        const val CREATE_TABLE_USER = "CREATE TABLE ${DATABASE_KEYS.TABLE_NAME_USER} (${DATABASE_KEYS.COLUMN_TEXTO_NOME} TEXT, " +
                "${DATABASE_KEYS.COLUMN_TEXTO_PRONTUARIO} TEXT PRIMARY KEY)"
        const val CREATE_TABLE_VOTO = "CREATE TABLE ${DATABASE_KEYS.TABLE_NAME_VOTO} (${DATABASE_KEYS.COLUMN_ENUM_VOTO} TEXT " +
                "CHECK(${DATABASE_KEYS.COLUMN_ENUM_VOTO} IN ('OTIMO', 'BOM', 'REGULAR', 'RUIM')), ${DATABASE_KEYS.COLUMN_RECEIPT} TEXT PRIMARY KEY)"
        const val DROP_TABLE_USER = "DROP TABLE IF EXISTS ${DATABASE_KEYS.TABLE_NAME_USER}"
        const val DROP_TABLE_VOTO = "DROP TABLE IF EXISTS ${DATABASE_KEYS.TABLE_NAME_VOTO}"
    }

    /*Criação das tabelas no banco SQL*/
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CREATE_TABLE_USER)
        db.execSQL(CREATE_TABLE_VOTO)
    }

    /*Upgrade*/
    override fun onUpgrade(db: SQLiteDatabase, versaoAntiga: Int, versaoNova: Int) {
        db.execSQL(DROP_TABLE_VOTO)
        db.execSQL(DROP_TABLE_USER)
        onCreate(db)
    }
}
package org.csuf.cpsc411test.Dao
import com.almworks.sqlite4java.SQLiteConnection
import java.io.File

class Database constructor(var dbName : String = ""){

    init {
        //create database, tables, keep db connections
        dbName = "C:\\Users\\Matt\\Desktop\\edits\\School\\CPSC 411 - Mobile Dev - Shen\\Project 2\\Claim_RestServer\\claimsDB.db"
        val dbConn = SQLiteConnection(File(dbName))
        dbConn.open()
        val sqlStmt = "create table if not exists claim (id text, title text, date text, isSolved int)"
        dbConn.exec(sqlStmt)
    }

    fun getDbConnection() : SQLiteConnection{
        val dbConn = SQLiteConnection(File(dbName))
        dbConn.open()
        return dbConn
    }

    // single object pattern:
    companion object { //object automatically made for this class, similar to static method
        private var dbObj : Database? = null

        fun getInstance() : Database?{
            if(dbObj == null){
                dbObj = Database()
            }
            return dbObj
        }
    }
}
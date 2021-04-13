package csuf.cpsc411.Dao.claim

import csuf.cpsc411.Dao.Dao
import org.csuf.cpsc411test.Dao.Database
import java.util.*

class ClaimDao : Dao() {

    fun addClaim(cObj : Claim) {

        val conn = Database.getInstance()?.getDbConnection()

        sqlStmt = "insert into claim (id, title, date, isSolved) values ('${cObj.id}', '${cObj.title}', '${cObj.date}', '${cObj.isSolved}')"

        conn?.exec(sqlStmt)
    }

    fun addClaim(cObj : PartialClaim) {

        val conn = Database.getInstance()?.getDbConnection()
        var uniqueID = UUID.randomUUID().toString()
        val isSolved = 0;

        sqlStmt = "insert into claim (id, title, date, isSolved) values ('${uniqueID}', '${cObj.title}', '${cObj.date}', '${isSolved}')"

        conn?.exec(sqlStmt)
    }


    fun getAll() : List<Claim> {

        val conn = Database.getInstance()?.getDbConnection()

        sqlStmt = "select id, title, date, isSolved from claim"


        var claimList : MutableList<Claim> = mutableListOf()
        val st = conn?.prepare(sqlStmt)

        while(st?.step()!!){
            val id = st.columnString(0)
            val title = st.columnString(1)
            val date = st.columnString(2)
            var isSolved = st.columnInt(3)
            claimList.add(Claim(id,title,date,isSolved))
        }

        return claimList
    }

}
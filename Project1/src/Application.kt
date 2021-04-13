package csuf.cpsc411

import com.google.gson.Gson
import csuf.cpsc411.Dao.claim.Claim
import csuf.cpsc411.Dao.claim.ClaimDao
import csuf.cpsc411.Dao.claim.PartialClaim
import io.ktor.http.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*
import io.ktor.utils.io.*
import org.csuf.cpsc411test.Dao.Database
import java.util.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    routing {
        this.get("/ClaimService/add"){
            println("Http message is using GET Method with /get")
            var uniqueID = UUID.randomUUID().toString()
            var titleVal = call.request.queryParameters["Title"]
            var dateVal = call.request.queryParameters["Date"]
            val isSolved = 0;

            val cObj = Claim(uniqueID, titleVal, dateVal, isSolved)
            val dao = ClaimDao().addClaim(cObj)
            call.respondText("Welcome", status = HttpStatusCode.OK, contentType = ContentType.Text.Plain)
        }

        get("/ClaimService/getAll"){
            val cList = ClaimDao().getAll()
            println("The number of claims is:  ${cList.size}")

            val respJsonStr = Gson().toJson(cList)
            call.respondText(respJsonStr, status = HttpStatusCode.OK, contentType = ContentType.Application.Json)
        }

        post("/ClaimService/add"){
            val contType = call.request.contentType()
            val data = call.request.receiveChannel()
            val dataLength = data.availableForRead
            val output = ByteArray(dataLength)
            data.readAvailable(output)
            val str = String(output)        //print for further testing


            //JSON deserialization
            val cObj : PartialClaim
            cObj = Gson().fromJson(str, PartialClaim::class.java)

            val dao = ClaimDao().addClaim(cObj)

            println("HTTP message is using POST method with /post ${contType}, ${str}")
            call.respondText("The POST request was successfully processed...",
                status = HttpStatusCode.OK, contentType = ContentType.Text.Plain)
        }

    }

}


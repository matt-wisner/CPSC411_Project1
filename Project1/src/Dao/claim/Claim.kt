package csuf.cpsc411.Dao.claim

data class Claim (var id:String?, var title:String?, var date:String?, val isSolved:Int)
data class PartialClaim (var title:String?, var date:String?)
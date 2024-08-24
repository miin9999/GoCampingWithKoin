package diy.camping_model


import com.google.gson.annotations.SerializedName

data class Body(
    @SerializedName("items")
    var items: Items?,
    @SerializedName("numOfRows")
    var numOfRows: Int?,
    @SerializedName("pageNo")
    var pageNo: Int?,
    @SerializedName("totalCount")
    var totalCount: Int?
)
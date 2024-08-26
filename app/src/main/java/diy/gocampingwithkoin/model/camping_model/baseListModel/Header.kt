package diy.gocampingwithkoin.model.camping_model.baseListModel


import com.google.gson.annotations.SerializedName

data class Header(
    @SerializedName("resultCode")
    var resultCode: String?,
    @SerializedName("resultMsg")
    var resultMsg: String?
)
package diy.gocampingwithkoin.model.camping_model.imageListModel


import com.google.gson.annotations.SerializedName

data class Header(
    @SerializedName("resultCode")
    var resultCode: String?,
    @SerializedName("resultMsg")
    var resultMsg: String?
)
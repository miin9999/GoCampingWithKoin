package diy.camping_model


import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("body")
    var body: Body?,
    @SerializedName("header")
    var header: Header?
)
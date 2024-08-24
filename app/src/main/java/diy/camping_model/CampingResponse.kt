package diy.camping_model


import com.google.gson.annotations.SerializedName

data class CampingResponse(
    @SerializedName("response")
    var response: Response?
)
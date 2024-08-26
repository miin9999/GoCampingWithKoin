package diy.gocampingwithkoin.model.camping_model.baseListModel


import com.google.gson.annotations.SerializedName

data class CampingResponse(
    @SerializedName("response")
    var response: Response?
)
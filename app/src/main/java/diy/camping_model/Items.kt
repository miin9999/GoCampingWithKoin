package diy.camping_model


import com.google.gson.annotations.SerializedName

data class Items(
    @SerializedName("item")
    var item: List<Item?>?
)
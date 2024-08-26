package diy.gocampingwithkoin.model.camping_model.imageListModel


import com.google.gson.annotations.SerializedName

data class Items(
    @SerializedName("item")
    var imageItem: List<ImageItem?>?
)
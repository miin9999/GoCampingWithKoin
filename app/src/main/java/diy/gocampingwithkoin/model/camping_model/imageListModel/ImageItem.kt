package diy.gocampingwithkoin.model.camping_model.imageListModel


import com.google.gson.annotations.SerializedName

data class ImageItem(
    @SerializedName("contentId")
    var contentId: String?,
    @SerializedName("createdtime")
    var createdtime: String?,
    @SerializedName("imageUrl")
    var imageUrl: String?,
    @SerializedName("modifiedtime")
    var modifiedtime: String?,
    @SerializedName("serialnum")
    var serialnum: String?
)
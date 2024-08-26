package diy.gocampingwithkoin.Repository

import diy.gocampingwithkoin.model.camping_model.imageListModel.ImageItem
import diy.gocampingwithkoin.network.CampingService

class ImageUrlRepository (private val campingService: CampingService){
    suspend fun getCampingImageApiService(numOfRows: Int, pageNo: Int,contentId:Int):List<ImageItem?>?{
        return campingService.getCampingImage(numOfRows,pageNo,contentId)
            .body()?.
            response?.
            body?.
            items?.
            imageItem
    }







}
package diy.gocampingwithkoin.Repository

import diy.gocampingwithkoin.network.CampingService
import diy.gocampingwithkoin.model.camping_model.baseListModel.Item
import diy.gocampingwithkoin.model.camping_model.imageListModel.ImageItem

class BaseInfoRepository (private val campingService: CampingService){

    suspend fun getGoCampingApiService(numOfRows: Int, pageNo: Int): List<Item?>? {
        return campingService.getCamping(numOfRows, pageNo)
            .body()
            ?.response
            ?.body
            ?.items
            ?.item
    }



}
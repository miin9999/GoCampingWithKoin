package diy.gocampingwithkoin

import diy.camping_model.Item

class Repository (private val campingService: CampingService){

    suspend fun getGoCampingApiService(numOfRows: Int, pageNo: Int): List<Item?>? {
        return campingService.getCamping(numOfRows, pageNo)
            .body()
            ?.response
            ?.body
            ?.items
            ?.item
    }

}
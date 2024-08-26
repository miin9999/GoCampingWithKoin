package diy.gocampingwithkoin.network

import diy.gocampingwithkoin.BuildConfig
import diy.gocampingwithkoin.model.camping_model.baseListModel.CampingResponse
import diy.gocampingwithkoin.model.camping_model.imageListModel.ImageResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CampingService {
    @GET("basedList?&serviceKey=${BuildConfig.goCamping_api_key}")

    suspend fun getCamping(
        @Query("numOfRows") numOfRows:Int,
        @Query("pageNo") pageNo:Int,
        @Query("MobileApp") mobileApp:String="TestApp",
        @Query("_type") type:String="JSON",
        @Query("MobileOS") mobileOS:String="ETC"
    ): Response<CampingResponse>


    @GET("imageList?&serviceKey=${BuildConfig.goCamping_api_key}")
    suspend fun getCampingImage(
        @Query("numOfRows") numOfRows:Int,
        @Query("pageNo") pageNo:Int,
        @Query("contentId") contentId:Int,
        @Query("MobileApp") mobileApp: String ="TestApp",
        @Query("_type") type:String="JSON",
        @Query("MobileOS") mobileOS:String="ETC",
    ): Response<ImageResponse>
}
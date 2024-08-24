package diy.gocampingwithkoin

import diy.camping_model.CampingResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CampingService {
    @GET("basedList?" +
            "&serviceKey=${BuildConfig.goCamping_api_key}")

    suspend fun getCamping(
        @Query("numOfRows") numOfRows:Int,
        @Query("pageNo") pageNo:Int,
        @Query("MobileApp") mobileApp:String="TestApp",
        @Query("_type") type:String="JSON",
        @Query("MobileOS") mobileOS:String="ETC"
    ): Response<CampingResponse>
}
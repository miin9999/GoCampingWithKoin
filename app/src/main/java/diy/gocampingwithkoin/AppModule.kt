package diy.gocampingwithkoin

import diy.gocampingwithkoin.Url.GOCAMPING_BASE_URL
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

val appModule = module{

    viewModel { MyViewModel(get()) }

    single{
        GsonConverterFactory.create() as Converter.Factory
    }
    single{
        Repository(get())
    }

    single{
        Retrofit.Builder()
            .baseUrl(GOCAMPING_BASE_URL)
            .addConverterFactory(get())
            .build()
            .create(CampingService::class.java)
    }
    //get<GsonConverterFactory>() < 이걸로 해도 됨 //as Converter.Factory 지우고ㅇㅇ







}
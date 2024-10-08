package diy.gocampingwithkoin.di

import diy.gocampingwithkoin.network.CampingService
import diy.gocampingwithkoin.util.Url.GOCAMPING_BASE_URL
import diy.gocampingwithkoin.Repository.BaseInfoRepository
import diy.gocampingwithkoin.Repository.ImageUrlRepository
import diy.gocampingwithkoin.ViewModel.BaseInfoViewModel
import diy.gocampingwithkoin.ViewModel.ImageUrlViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {

    viewModel { BaseInfoViewModel(get()) }
    viewModel { ImageUrlViewModel(get()) }

    single {
        GsonConverterFactory.create() as Converter.Factory
    }
    single {
        BaseInfoRepository(get())
    }
    single{
        ImageUrlRepository(get())
    }

    single {
        Retrofit.Builder()
            .baseUrl(GOCAMPING_BASE_URL)
            .addConverterFactory(get())
            .build()
            .create(CampingService::class.java)
    }
    //get<GsonConverterFactory>() < 이걸로 해도 됨 //as Converter.Factory 지우고ㅇㅇ


}
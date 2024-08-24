package diy.gocampingwithkoin.di

import android.app.Application
import diy.gocampingwithkoin.di.appModule
import org.koin.core.context.startKoin

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(appModule)
        }
    }
}
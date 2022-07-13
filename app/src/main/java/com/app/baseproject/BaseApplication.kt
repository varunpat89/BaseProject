package com.app.baseproject

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import com.app.baseproject.bottom_menu.bottomMenuConfigModule
import com.app.baseproject.utils.BBLogger
import com.app.baseproject.di.coreModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * The application class used by this app to define its various Journey configurations and other setup items.
 */
class BaseApplication : Application() {

    private val TAG = BaseApplication::class.simpleName.toString()

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate() {
        super.onCreate()

        // Set backbase log level
        setLogLevel()

        // Load koin modules
        loadKoinModules()

    }

    private fun loadKoinModules() {
        startKoin {
            androidContext(this@BaseApplication)
            modules( coreModule + bottomMenuConfigModule )
        }
    }

    private fun setLogLevel() {
        if (BuildConfig.DEBUG) {
            BBLogger.setLogLevel(BBLogger.LogLevel.DEBUG)
        } else {
            BBLogger.setLogLevel(BBLogger.LogLevel.ERROR)
        }
    }
}

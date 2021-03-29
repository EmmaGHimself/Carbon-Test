package com.emmagcarbontest.app.util.hilt.modules

import android.content.Context
import com.emmagcarbontest.restapi.Service
import com.emmagcarbontest.restapi.ApiClient
import com.emmagcarbontest.app.data.UserRepository
import com.emmagcarbontest.app.local.AppDatabase

import com.emmagcarbontest.app.util.NetworkChecker
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ActivityComponent::class)
object HiltModule {

    /***  Create UserRepository ***/
    @Provides
    fun provideUserRepository(@ApplicationContext appContext: Context): UserRepository {
        val retrofit = ApiClient.getClient()
        val service: Service = retrofit.create(Service::class.java)
        val db = AppDatabase.getDatabase(appContext)

        val repository = UserRepository()
        repository.service = service
        repository.database = db
        return repository
    }

    @Provides
    fun provideNetworkChecker(@ApplicationContext appContext: Context): NetworkChecker {
        return NetworkChecker(appContext)
    }
}
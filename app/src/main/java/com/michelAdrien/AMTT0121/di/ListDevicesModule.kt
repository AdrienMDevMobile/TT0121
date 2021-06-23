package com.michelAdrien.AMTT0121.di

import com.michelAdrien.AMTT0121.Tool.Data.IRepository
import com.michelAdrien.AMTT0121.Tool.Data.JsonRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ListDevicesModule {

    @Singleton
    @Binds
    abstract fun bindDeviceListRepository(
        list:JsonRepository
    ) : IRepository

}
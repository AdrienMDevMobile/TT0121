package com.michelAdrien.AMTT0121.di

import com.michelAdrien.AMTT0121.Tool.Data.IRepository
import com.michelAdrien.AMTT0121.Tool.Data.JsonRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class ListDevicesModule {

    @ViewModelScoped
    @Binds
    abstract fun bindDeviceListRepository(
        list:JsonRepository
    ) : IRepository

}
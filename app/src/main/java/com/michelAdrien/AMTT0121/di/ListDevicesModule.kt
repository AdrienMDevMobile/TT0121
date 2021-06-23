package com.michelAdrien.AMTT0121.di

import com.michelAdrien.AMTT0121.viewModel.tool.data.IRepository
import com.michelAdrien.AMTT0121.viewModel.tool.data.JsonRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
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
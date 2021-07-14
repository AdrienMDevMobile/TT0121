package com.michelAdrien.AMTT0121.di

import com.michelAdrien.AMTT0121.viewModel.tool.data.IRepository
import com.michelAdrien.AMTT0121.viewModel.tool.data.AssetFileRepository
import com.michelAdrien.AMTT0121.viewModel.tool.data.VolleyRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Singleton
    @Binds
    abstract fun bindDeviceListRepository(
        list: AssetFileRepository
    ) : IRepository
    //VolleyRepository

}
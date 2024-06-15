package com.haa.diagnosabullying.data.di

import android.content.Context
import com.haa.diagnosabullying.data.resource.local.room.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) : AppDatabase = AppDatabase.getDatabase(context)
}
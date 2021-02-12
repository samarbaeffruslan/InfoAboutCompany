package com.example.core.di.component

import com.example.core.di.modules.NetworkModule
import com.example.core_api.providers.NetworkProvider
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        NetworkModule::class
    ]

)
interface CoreComponent: NetworkProvider {
}
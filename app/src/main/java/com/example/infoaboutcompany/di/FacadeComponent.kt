package com.example.infoaboutcompany.di

import android.app.Application
import com.example.core.di.component.DaggerCoreComponent
import com.example.core_api.providers.NetworkProvider
import com.example.core_api.providers.ProvidersFacade
import com.example.infoaboutcompany.BaseApp
import dagger.Component


@Component(
    dependencies = [
        NetworkProvider::class],
    modules = [NavigationModule::class]
)
interface FacadeComponent: ProvidersFacade {

    companion object{
        fun init(): FacadeComponent =
            DaggerFacadeComponent.builder()
                .networkProvider(DaggerCoreComponent.builder().build())
                .build()
    }

    fun inject(app: BaseApp)
}
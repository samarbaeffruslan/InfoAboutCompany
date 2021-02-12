package com.example.infoaboutcompany

import android.app.Application
import com.example.core_api.providers.AppWithFacade
import com.example.core_api.providers.ProvidersFacade
import com.example.infoaboutcompany.di.FacadeComponent

class BaseApp : Application(), AppWithFacade {

    companion object {
        private var facadeComponent: FacadeComponent? = null
    }

    override fun onCreate() {
        super.onCreate()
        (getFacade() as FacadeComponent).inject(this)
    }


    override fun getFacade(): ProvidersFacade {
       return facadeComponent ?: FacadeComponent.init().also {
           facadeComponent = it
       }
    }
}
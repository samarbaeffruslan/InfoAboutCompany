package com.example.companymain.di

import com.example.companymain.presentation.CompanyMainFragment
import com.example.core_api.providers.AppWithFacade
import com.example.core_api.providers.ProvidersFacade
import dagger.Component


@Component(
    dependencies = [ProvidersFacade::class],
    modules = [CompanyMainFragmentModule::class]
)
interface CompanyMainComponent {

    companion object{
        fun create(providersFacade: ProvidersFacade): CompanyMainComponent{
            return DaggerCompanyMainComponent.builder()
                .providersFacade(providersFacade)
                .build()
        }

        fun injectFragment(fragment: CompanyMainFragment): CompanyMainComponent{
            val component = create((fragment.activity?.application
                    as AppWithFacade).getFacade())
            component.inject(fragment)
            return component
        }
    }

    fun inject(fragment: CompanyMainFragment)
}
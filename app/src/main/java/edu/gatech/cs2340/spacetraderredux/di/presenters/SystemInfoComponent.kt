package edu.gatech.cs2340.spacetraderredux.di.presenters

import dagger.Component
import edu.gatech.cs2340.spacetraderredux.di.AppComponent
import edu.gatech.cs2340.spacetraderredux.di.PerActivity
import edu.gatech.cs2340.spacetraderredux.ui.systempane.SystemInfoActivity

@PerActivity
@Component(dependencies = [AppComponent::class], modules = [SystemInfoModule::class])
interface SystemInfoComponent {
    fun inject(systemInfoActivity: SystemInfoActivity)
}
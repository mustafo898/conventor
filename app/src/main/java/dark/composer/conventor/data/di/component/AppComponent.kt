//package dark.composer.conventor.data.di.component
//
//import android.app.Application
//import dagger.BindsInstance
//import dagger.Component
//import dagger.android.AndroidInjector
//import dagger.android.support.AndroidSupportInjectionModule
//import dark.composer.conventor.data.di.module.ActivityBuildersModule
//import dark.composer.conventor.data.di.module.ViewModelFactoryModule
//import dark.composer.conventor.data.app.App
//import javax.inject.Singleton
//
//@Singleton
//@Component(
//    modules = [
//        AndroidSupportInjectionModule::class,
//        ActivityBuildersModule::class,
//        ViewModelFactoryModule::class,
//    ]
//)
//interface AppComponent : AndroidInjector<App> {
//
//    @Component.Builder
//    interface Builder {
//        @BindsInstance
//        fun application(application: Application): Builder
//        fun build(): AppComponent
//    }
//}

//package dark.composer.conventor.di.module
//
//import androidx.lifecycle.ViewModel
//import dagger.Binds
//import dagger.Module
//import dagger.multibindings.IntoMap
//import dark.composer.conventor.di.scopes.ViewModelKey
//import dark.composer.conventor.presentation.main.MainViewModel
//import dark.composer.conventor.presentation.second.SecondViewModel
//
//@Module
//abstract class ViewModelsModule {
//
//    @Binds
//    @IntoMap
//    @ViewModelKey(MainViewModel::class)
//    abstract fun mainViewModel(mainViewModel : MainViewModel): ViewModel
//
//    @Binds
//    @IntoMap
//    @ViewModelKey(SecondViewModel::class)
//    abstract fun secondViewModel(secondViewModel : SecondViewModel): ViewModel
//}
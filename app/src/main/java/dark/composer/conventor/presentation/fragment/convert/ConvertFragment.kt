package dark.composer.conventor.presentation.fragment.convert

import androidx.fragment.app.viewModels
import dark.composer.conventor.databinding.FragmentConvertBinding
import dark.composer.conventor.presentation.fragment.BaseFragment
import dark.composer.conventor.presentation.fragment.splash.SplashViewModel

class ConvertFragment : BaseFragment<FragmentConvertBinding>(FragmentConvertBinding::inflate) {
    val viewModel: SplashViewModel by viewModels()

    override fun onViewCreate() {

    }
}
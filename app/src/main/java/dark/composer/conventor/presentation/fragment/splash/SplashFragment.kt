package dark.composer.conventor.presentation.fragment.splash

import android.os.CountDownTimer
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import dark.composer.conventor.R
import dark.composer.conventor.databinding.FragmentSplashBinding
import dark.composer.conventor.presentation.fragment.BaseFragment

@AndroidEntryPoint
class SplashFragment : BaseFragment<FragmentSplashBinding>(FragmentSplashBinding::inflate) {
    val viewModel: SplashViewModel by viewModels()

    override fun onViewCreate() {
        object : CountDownTimer(3000, 100) {
            override fun onFinish() {
                navController.navigate(R.id.action_splashFragment_to_convertFragment)
//                activity?.findViewById<BottomNavigationView>(R.id.bottomNavigation)?.visibility =
//                    View.VISIBLE

            }

            override fun onTick(value: Long) {

            }
        }.start()
    }
}
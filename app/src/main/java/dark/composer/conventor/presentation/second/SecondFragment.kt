package dark.composer.conventor.presentation.second

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dark.composer.conventor.R
import dark.composer.conventor.databinding.FragmentSecondBinding
import dark.composer.conventor.presentation.BaseFragment
import dark.composer.conventor.presentation.main.MainViewModel
import javax.inject.Inject

class SecondFragment : BaseFragment<FragmentSecondBinding>(FragmentSecondBinding::inflate) {
    val viewModel: MainViewModel by viewModels()

    override fun onViewCreate() {

    }
}
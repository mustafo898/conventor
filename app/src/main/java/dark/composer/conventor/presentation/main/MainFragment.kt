package dark.composer.conventor.presentation.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import dark.composer.conventor.R
import dark.composer.conventor.databinding.FragmentMainBinding
import dark.composer.conventor.presentation.BaseFragment
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {
    val viewModel: MainViewModel by viewModels()

    override fun onViewCreate() {

    }
}
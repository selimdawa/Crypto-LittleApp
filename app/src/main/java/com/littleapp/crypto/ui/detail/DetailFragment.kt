package com.littleapp.crypto.ui.detail

import androidx.core.view.isVisible
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.navigation.fragment.navArgs
import com.littleapp.crypto.R
import com.littleapp.crypto.base.BaseFragment
import com.littleapp.crypto.databinding.FragmentDetailBinding
import com.littleapp.crypto.utils.DATA
import com.littleapp.crypto.utils.NetworkResult
import com.littleapp.crypto.utils.loadImage
import com.littleapp.crypto.utils.toast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment :
    BaseFragment<FragmentDetailBinding, DetailViewModel>(FragmentDetailBinding::inflate) {

    private val args: DetailFragmentArgs by navArgs()
    override val viewModel: DetailViewModel by hiltNavGraphViewModels(R.id.nav_graph)

    override fun onCreateFinished() {
        binding.toolbar.nameSpace.text = DATA.CRYPTO_DETAILS
        viewModel.getDetail(args.symbol, args.coinId)
    }

    override fun initializeListeners() {}

    override fun observeEvents() {
        collectLifecycleFlow(viewModel.localDetail) { entity ->
            entity?.let {
                with(binding) {
                    ivDetail.loadImage("${DATA.IMAGE_CRYPTO}${it.id}.png")
                    tvDetailTitle.text = it.name
                    tvDetailSymbol.text = it.symbol
                    tvDetailDescription.text = it.description
                }
            }
        }

        collectLifecycleFlow(viewModel.detailState) { state ->
            when (state) {
                is NetworkResult.Loading -> handleView(isLoading = viewModel.localDetail.value == null)
                is NetworkResult.Success -> handleView(isLoading = false)
                is NetworkResult.Error -> {
                    handleView(isLoading = false)
                    toast(state.message)
                }
            }
        }
    }

    private fun handleView(isLoading: Boolean) {
        binding.detailGroup.isVisible = !isLoading
        binding.pbDetail.isVisible = isLoading
    }
}
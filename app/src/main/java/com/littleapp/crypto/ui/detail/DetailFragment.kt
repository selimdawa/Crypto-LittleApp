package com.littleapp.crypto.ui.detail

import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.littleapp.crypto.Unit.DATA
import com.littleapp.crypto.base.BaseFragment
import com.littleapp.crypto.model.detail.CoinDetail
import com.littleapp.crypto.model.detail.DetailResponse
import com.littleapp.crypto.utils.loadImage
import com.littleapp.crypto.databinding.FragmentDetailBinding
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import org.json.JSONArray
import org.json.JSONObject
import javax.inject.Inject

@AndroidEntryPoint
class DetailFragment :
    BaseFragment<FragmentDetailBinding, DetailViewModel>(FragmentDetailBinding::inflate) {

    @Inject
    lateinit var gson: Gson

    override val viewModel by viewModels<DetailViewModel>()
    private val args by navArgs<DetailFragmentArgs>()

    override fun onCreateFinished() {
        viewModel.getDetail(DATA.API_KEY_CRYPTO, args.symbol)
        binding.toolbar.nameSpace.text = DATA.Crypto_details
    }

    override fun initializeListeners() {}

    override fun observeEvents() {
        with(viewModel) {
            detailResponse.observe(viewLifecycleOwner) { response ->
                parseData(response)
            }
            isLoading.observe(viewLifecycleOwner) { loading ->
                handleView(loading)
            }
            onError.observe(viewLifecycleOwner) { message ->
                Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun parseData(response: DetailResponse?) {
        try {
            val json = gson.toJson(response?.data)
            val jsonObject = JSONObject(json)
            val jsonArray = jsonObject.optJSONArray(args.symbol) ?: JSONArray()
            val firstObject = jsonArray.optJSONObject(0)?.toString()

            if (!firstObject.isNullOrEmpty()) {
                val coin = gson.fromJson(firstObject, CoinDetail::class.java)
                coin?.let {
                    with(binding) {
                        ivDetail.loadImage("${DATA.IMAGE_CRYPTO}${args.coinId}.png")
                        tvDetailTitle.text = it.name
                        tvDetailSymbol.text = it.symbol
                        tvDetailDescription.text = it.description
                    }
                }
            }
        } catch (_: Exception) {}
    }

    private fun handleView(isLoading: Boolean) {
        binding.detailGroup.isVisible = !isLoading
        binding.pbDetail.isVisible = isLoading
    }
}
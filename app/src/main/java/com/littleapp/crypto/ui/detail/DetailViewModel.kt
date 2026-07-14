package com.littleapp.crypto.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.littleapp.crypto.model.detail.DetailResponse
import com.littleapp.crypto.utils.DATA
import com.littleapp.crypto.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: DetailRepository
) : ViewModel() {

    var symbol: String = ""
    var coinId: Int = 0

    private val _detailState =
        MutableStateFlow<NetworkResult<DetailResponse>>(NetworkResult.Loading())
    val detailState: StateFlow<NetworkResult<DetailResponse>> = _detailState.asStateFlow()

    fun getDetail(symbol: String, coinId: Int) {
        this.symbol = symbol
        this.coinId = coinId

        viewModelScope.launch {
            if (symbol.isEmpty()) {
                _detailState.value = NetworkResult.Error(false, "Symbol is missing")
                return@launch
            }
            _detailState.value = NetworkResult.Loading()
            _detailState.value = repository.getDetail(DATA.API_KEY_CRYPTO, symbol)
        }
    }
}
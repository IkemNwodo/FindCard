package com.ikem.findcard

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ikem.domain.entities.CardInfo
import com.ikem.domain.usecases.GetCardInfoUsecase
import kotlinx.coroutines.launch

class CardViewModel @ViewModelInject constructor(val getCardInfoUsecase: GetCardInfoUsecase): ViewModel() {

    private val _cardInfo = MutableLiveData<CardInfo>()
    val cardInfo = _cardInfo as LiveData<CardInfo>

    private val _isSuccessful = MutableLiveData<Boolean>()
    val isSuccessful = _isSuccessful as LiveData<Boolean>

    fun getCardNumber(cardNumber: Int) = viewModelScope.launch{
        try {
            when(val result = getCardInfoUsecase(cardNumber)) {
                is com.ikem.domain.Result.Success -> {
                    _cardInfo.postValue(result.data)
                }
                is com.ikem.domain.Result.Error -> {
                    _isSuccessful.postValue(false)
                }

            }
        } catch (exception: Exception){
            _isSuccessful.postValue(false)
        }
    }
}
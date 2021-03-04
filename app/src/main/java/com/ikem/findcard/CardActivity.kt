package com.ikem.findcard

import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import com.ikem.findcard.databinding.ActivityCardBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CardActivity : AppCompatActivity() {

    lateinit var binding: ActivityCardBinding

    private val viewModel: CardViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.coordLayout.isVisible = false
        binding.fabClose.setOnClickListener {
            binding.coordLayout.isVisible = false
        }

        viewModel.cardInfo.observe(this, Observer { cardInfo ->
            binding.coordLayout.isVisible = true
            if (cardInfo != null) {
                with(binding){
                    cardBrand.getText(cardInfo.brand)
                    cardType.getText(cardInfo.type)
                    cardBank.getText(cardInfo.bank)
                    cardCountry.getText(cardInfo.country)
                    cardPrepaid.getText(cardInfo.prepaid)
                    cardScheme.getText(cardInfo.scheme)
                }
            }
            else
                binding.errorText.isVisible = true
        })

        binding.checkBtn.setOnClickListener {
            it.isEnabled = false
            it.hideKeyboard()
            getCard()
        }


        viewModel.isSuccessful.observe(this, Observer { successful ->
            if (!successful) {
                with(binding){
                    include.progressView.isVisible = false
                    coordLayout.isVisible = true
                    errorText.isVisible = true
                }
                Snackbar.make(binding.coordLayout, getString(R.string.snack_message),
                    Snackbar.LENGTH_LONG).setAnimationMode(Snackbar.ANIMATION_MODE_SLIDE)
                    .show()
            }
        })
    }

    private fun getCard() {
        val cardNumber = binding.cardNumberField.text.toString()
        if (cardNumber.isNotEmpty()){
            binding.include.progressView.isVisible = true
            viewModel.getCardNumber(cardNumber = cardNumber.toInt())
        } else {
            binding.cardNumberLayout.error = getString(R.string.input_error)
        }

    }

    private fun View.hideKeyboard() {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
    }

}
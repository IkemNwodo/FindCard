package com.ikem.findcard

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
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

        binding.fabClose.setOnClickListener {
            with(binding) {
                coordLayout.isVisible = false
                errorText.isVisible = false
                checkBtn.isEnabled = true
                cardNumber.clearText()
                cardBrand.clearText()
                cardType.clearText()
                cardBank.clearText()
                cardCountry.clearText()
                cardPrepaid.clearText()
                cardScheme.clearText()
                cardLength.clearText()
            }
        }

        viewModel.cardInfo.observe(this, Observer { cardInfo ->
            binding.progressView.isVisible = false

            if (cardInfo != null) {
                with(binding) {
                    coordLayout.isVisible = true
                    cardNumber.getText(cardNumberField.text.toString())
                    cardBrand.getText(cardInfo.brand)
                    cardType.getText(cardInfo.type)
                    cardBank.getText(cardInfo.bank)
                    cardCountry.getText(cardInfo.country)
                    cardPrepaid.getText(cardInfo.prepaid)
                    cardScheme.getText(cardInfo.scheme)
                    cardLength.getText(cardInfo.length)
                    cardNumberField.setText("")
                }
            } else
                Snackbar.make(
                    binding.coordLayout, getString(R.string.snack_message),
                    Snackbar.LENGTH_LONG
                ).setAnimationMode(Snackbar.ANIMATION_MODE_SLIDE)
                    .show()
        })

        binding.checkBtn.setOnClickListener {
            it.isEnabled = false
            binding.cardNumberField.clearFocus()
            it.hideKeyboard()
            getCard()
        }

        binding.cardNumberField.run {
            doOnTextChanged { _, _, _, _, ->
                binding.checkBtn.isEnabled = true
                binding.cardNumberLayout.run { error = "" }
            }
            doAfterTextChanged {
                if (it != null) {
                    val text = removeWhiteSpaces(it.toString())
                    if (text.length % 4 == 0)
                        it.append(" ")
                }
            }
        }

        viewModel.isSuccessful.observe(this, Observer { successful ->
            if (!successful) {
                with(binding) {
                    binding.progressView.isVisible = false
                    coordLayout.isVisible = true
                    errorText.isVisible = true
                }
            }
        })
    }

    private fun getCard() {
        val input = binding.cardNumberField.text.toString()
        val cardNumber = removeWhiteSpaces(input)

        if (cardNumber.isNotEmpty()) {
            binding.progressView.isVisible = true
            viewModel.getCardNumber(cardNumber = cardNumber.toInt())
        } else {
            binding.cardNumberLayout.error = getString(R.string.input_error)
        }
    }

    private fun removeWhiteSpaces(input: String): String = input.replace("\\s".toRegex(), "")



}
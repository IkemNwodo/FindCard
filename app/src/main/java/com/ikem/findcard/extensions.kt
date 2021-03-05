package com.ikem.findcard

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.core.view.isVisible

fun TextView.getText(text: String) {
    if (!text.isNullOrEmpty()){
        this.isVisible = true
        val initialText = this.text.toString()
        this.text = String.format(initialText, text)
    }
}

fun TextView.clearText(){
    if (this.text != null){
        val label = this.text.substring(0, this.text.indexOf(":") + 1)
        this.text = label + resources.getString(R.string.format)
        this.isVisible = false
    }
}

fun View.hideKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}
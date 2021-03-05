package com.ikem.findcard

import android.view.View
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
    if (this.text != null)
        this.text = ""
}
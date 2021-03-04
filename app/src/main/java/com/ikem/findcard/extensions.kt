package com.ikem.findcard

import android.view.View
import android.widget.TextView
import androidx.core.view.isVisible

fun TextView.getText(text: String) {
    if (text.isNullOrEmpty()){
        this.visibility = View.VISIBLE
        val initialText = this.text.toString()
        this.text = String.format(initialText, text)
    }
}
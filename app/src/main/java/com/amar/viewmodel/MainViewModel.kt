package com.amar.viewmodel

import androidx.lifecycle.ViewModel

class MainViewModel(private val initialValue: Int): ViewModel() {
    var count: Int = initialValue;

    fun increment(){
        count++;
    }
}
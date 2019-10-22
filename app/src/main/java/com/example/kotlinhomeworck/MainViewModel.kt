package com.example.kotlinhomeworck

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var i = 0

    private val viewStateLiveData: MutableLiveData<String> = MutableLiveData()

    fun beeRate(): LiveData<String> {
        i++
        viewStateLiveData.value = "Покормите наконец несчастного, голодного кота $i"
        return viewStateLiveData
    }

}
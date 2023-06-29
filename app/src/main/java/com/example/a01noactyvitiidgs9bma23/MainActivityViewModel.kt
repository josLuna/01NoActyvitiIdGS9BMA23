package com.example.a01noactyvitiidgs9bma23

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel:ViewModel() {
    var dice1Number: MutableLiveData<Int> = MutableLiveData<Int>().apply { value=0 }
    var dice2Number: MutableLiveData<Int> = MutableLiveData<Int>().apply { value=0 }

    fun setDice1Number(value:Int?){
        this.dice1Number.value  =   value
    }

    fun setDice2Number(value:Int?){
        this.dice2Number.value  =   value
    }

    fun getDice1Number (): Int?{
        return dice1Number.value
    }
}
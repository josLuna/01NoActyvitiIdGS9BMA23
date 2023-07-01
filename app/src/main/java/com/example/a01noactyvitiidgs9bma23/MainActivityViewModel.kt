package com.example.a01noactyvitiidgs9bma23

import android.text.Editable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel:ViewModel() {
    var dice1Number: MutableLiveData<Int> = MutableLiveData<Int>().apply { value=0 }
    var dice2Number: MutableLiveData<Int> = MutableLiveData<Int>().apply { value=0 }
    var diceNomre: MutableLiveData<String> = MutableLiveData<String>().apply { "Nombre Usuario" }
    var numero:MutableLiveData<Int> = MutableLiveData<Int>().apply { value=0 }

    fun setDice1Number(value:Int?){
        this.dice1Number.value  =   value
    }

    fun setDice2Number(value:Int?){
        this.dice2Number.value  =   value
    }

    fun userName(value: Editable?){
        this.diceNomre.value = value.toString()
    }


}
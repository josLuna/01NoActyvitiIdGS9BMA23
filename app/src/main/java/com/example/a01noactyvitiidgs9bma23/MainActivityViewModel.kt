package com.example.a01noactyvitiidgs9bma23

import android.widget.Button
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel:ViewModel() {
    var dice1Number: MutableLiveData<Int> = MutableLiveData<Int>().apply { value=0 }
    var dice2Number: MutableLiveData<Int> = MutableLiveData<Int>().apply { value=0 }
    var numero:MutableLiveData<Int> = MutableLiveData<Int>().apply { value=0 }
    var diceNombre: MutableLiveData<String> = MutableLiveData<String>().apply { value="Usuario" }
    var visible1: MutableLiveData<Int> = MutableLiveData<Int>().apply { value=0 }

    fun setDice1Number(value:Int?){
        this.dice1Number.value  =   value
    }

    fun setDice2Number(value:Int?){
        this.dice2Number.value  =   value
    }
    fun userName(value: String){
        this.diceNombre.value = value
    }
    fun setNumero(value: Int?){
        this.numero.value = value
    }
    fun setVisible(value: Int?){
        this.visible1.value = value
    }
    fun getDice1Number (): Int?{
        return dice1Number.value
    }


}
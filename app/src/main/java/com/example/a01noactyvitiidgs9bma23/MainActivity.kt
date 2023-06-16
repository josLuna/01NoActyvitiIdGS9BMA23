package com.example.a01noactyvitiidgs9bma23

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnRoll: Button=findViewById(R.id.btn_main_act)
        btnRoll.setOnClickListener{rollDice()}
    }

    /**
     * para ver todos los metodos de vida solo es precionar ctrl + o
     * */
    private fun rollDice(){
        val randomInt =(1..6).random()
        //Toast.makeText(this,"button clicked",Toast.LENGTH_SHORT).show()
        val tvNumber: TextView=findViewById(R.id.tv_main_act)
        //tvNumber.text = ((1..6).random()).toString()
        tvNumber.text = randomInt.toString()
        val diceImage:ImageView= findViewById(R.id.imageView3)
        diceImage.setImageResource(when(randomInt){
            1-> R.drawable.dice_1
            2-> R.drawable.dice_2
            3-> R.drawable.dice_3
            4-> R.drawable.dice_4
            5-> R.drawable.dice_5
            else-> R.drawable.dice_6
        })

    }
}
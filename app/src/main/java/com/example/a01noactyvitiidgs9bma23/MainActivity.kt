package com.example.a01noactyvitiidgs9bma23

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var  btnRoll:Button
    lateinit var  tvNumber: TextView
    lateinit var  tvNumber2: TextView
    lateinit var  diceImage:ImageView
    lateinit var  diceIm:ImageView
    var  numero:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnRoll: Button=findViewById(R.id.btn_main_act)
        val btnTime: Button=findViewById(R.id.time)
        val btnReset: Button=findViewById(R.id.reset)
        tvNumber=findViewById(R.id.tv_main_act)
        tvNumber2=findViewById(R.id.textView)
        diceImage = findViewById(R.id.imageView3)
        diceIm = findViewById(R.id.imageView)
        btnRoll.setOnClickListener{rollDice()}
        btnTime.setOnClickListener { time() }
        btnReset.setOnClickListener { reset() }
    }

    /**
     * para ver todos los metodos de vida solo es precionar ctrl + o
     * */
    private fun rollDice(){
        diceImage.setVisibility(View.VISIBLE)
        diceIm.setVisibility(View.VISIBLE)
        numero = numero +1
        val randomInt =(1..6).random()
        val random2 =(1..6).random()
        //Toast.makeText(this,"button clicked",Toast.LENGTH_SHORT).show()
       // val tvNumber: TextView=findViewById(R.id.tv_main_act)
        //tvNumber.text = ((1..6).random()).toString()
        tvNumber.text = (randomInt.toString())
        tvNumber2.text = (random2.toString())
        //val diceImage:ImageView= findViewById(R.id.imageView3)
        diceImage.setImageResource(when(randomInt){
            1-> R.drawable.dice_1
            2-> R.drawable.dice_2
            3-> R.drawable.dice_3
            4-> R.drawable.dice_4
            5-> R.drawable.dice_5
            else-> R.drawable.dice_6
        })
        diceIm.setImageResource(when(random2){
            1-> R.drawable.dice_1
            2-> R.drawable.dice_2
            3-> R.drawable.dice_3
            4-> R.drawable.dice_4
            5-> R.drawable.dice_5
            else-> R.drawable.dice_6
        })
    }
    private fun time(){

        Toast.makeText(this,"Has tirado ${numero} veces los dados",Toast.LENGTH_SHORT).show()
    }
    private  fun reset(){
        numero = 0
        tvNumber.setText("dice 1")
        tvNumber2.setText("dice 2")
        diceImage.setVisibility(View.INVISIBLE)
        diceIm.setVisibility(View.INVISIBLE)
    }
}
package com.example.a01noactyvitiidgs9bma23

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.a01noactyvitiidgs9bma23.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private lateinit var model: MainActivityViewModel
    private var numero:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        model= ViewModelProvider(this).get(MainActivityViewModel::class.java)
        binding= ActivityMainBinding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)

        binding.btnMainAct.setOnClickListener{rollDice()}
        binding.time.setOnClickListener{time()}

        model.dice1Number.observe(this,{
            binding.tvMainAct.text = it.toString()
            binding.imageView.setImageResource(when(it){
                1-> R.drawable.dice_1
                2-> R.drawable.dice_2
                3-> R.drawable.dice_3
                4-> R.drawable.dice_4
                5-> R.drawable.dice_5
                else-> R.drawable.dice_6
            })
        })
        model.dice2Number.observe(this,{
            binding.textView.text = it.toString()
            binding.imageView3.setImageResource(when (it) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            })
        })

    }
    /**
     * para ver todos los metodos de vida solo es precionar ctrl + o
     * */
    private fun rollDice(){
        val randomInt =(1..6).random()
        val randomInt2 = (1..6).random()
        model.setDice1Number(randomInt)
        model.setDice2Number(randomInt2)
        numero++

    }
    private fun time(){
       Toast.makeText(this,"Has tirado ${numero} veces los dados",Toast.LENGTH_SHORT).show()
    }
    private  fun reset(){
        numero = 0
    }

}
package com.example.a01noactyvitiidgs9bma23

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.a01noactyvitiidgs9bma23.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private lateinit var model: MainActivityViewModel
    private var numero:Int=0
    private var botonVisible: Boolean = false

    private var visible:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
        model.numero.observe(this,{
            numero=it.toInt()
        })
        model.diceNombre.observe(this,{
            binding.edtUserName.text = it.toString()
        })

        binding.btnUserName?.setOnClickListener{
            addUserName(it)
        }
        binding.tvUserName?.setOnClickListener{
            updateUsername(it)
        }
        binding.reset.setOnClickListener { updateUsername(it) }
       model.visible1.observe(this,{
           visible  = it.toInt()
        })



        if(visible == 0){
            if (!botonVisible) {
                binding.btnUserName.visibility = View.VISIBLE
                binding.tvUserName?.visibility=View.VISIBLE
            }
        }

    }
    /**
     * para ver todos los metodos de vida solo es precionar ctrl + o
     * */
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean("botonVisible", botonVisible)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        botonVisible = savedInstanceState.getBoolean("botonVisible")
        if(visible == 0){
            if (!botonVisible) {
                binding.btnUserName.visibility = View.VISIBLE
                binding.tvUserName?.visibility=View.VISIBLE
                binding.edtUserName?.visibility= View.GONE
            }
        }else{
            if (!botonVisible) {
                binding.btnUserName.visibility = View.GONE
                binding.tvUserName?.visibility=View.GONE
                binding.edtUserName?.visibility= View.VISIBLE
            }
        }
    }
    private fun rollDice(){
        binding.imageView.setVisibility(View.VISIBLE)
        binding.imageView3.setVisibility(View.VISIBLE)
        val randomInt =(1..6).random()
        val randomInt2 = (1..6).random()
        model.setDice1Number(randomInt)
        model.setDice2Number(randomInt2)
        numero++
        model.setNumero(numero)

    }
    private fun time(){
       Toast.makeText(this,"${binding.edtUserName.text} has tirado ${numero} veces los dados",Toast.LENGTH_SHORT).show()
    }

    private fun updateUsername(view:View?){
        numero = 0
        binding.tvMainAct.text = "0"
        binding.textView.text = "0"
        var visible2 = 0
        model.setVisible(visible2)
        binding.imageView.setVisibility(View.INVISIBLE)
        binding.imageView3.setVisibility(View.INVISIBLE)
        binding.tvUserName?.visibility=View.VISIBLE
        binding.btnUserName?.visibility=View.VISIBLE
        binding.edtUserName?.visibility=View.GONE

        //view?.visibility=View.GONE
       binding.tvUserName?.requestFocus()

        val showKbd=getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        showKbd.showSoftInput(binding.edtUserName,1)
    }
    private fun addUserName(view:View?) {
        model.userName(binding.tvUserName.text.toString())
        var visible2 = 2
        model.setVisible(visible2)
        binding.btnUserName?.visibility=View.GONE
        binding.tvUserName?.visibility=View.GONE
        //view?.visibility=View.GONE
        binding.edtUserName?.visibility= View.VISIBLE


        val hideKbd=getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        hideKbd.hideSoftInputFromWindow(view?.windowToken,0)
    }

}
package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.diceroller.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var rollResultIv : ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mBinding : ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        rollResultIv = mBinding.ivRollResult;
        val rollButton: Button =  mBinding.buttonRoll

        rollButton.setOnClickListener{
            rollDice();
        }



    }

    fun rollDice(){
        val randomInt = Random.nextInt(6) + 1
        val diceResource = when (randomInt){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        rollResultIv.setImageResource(diceResource);
    }
}